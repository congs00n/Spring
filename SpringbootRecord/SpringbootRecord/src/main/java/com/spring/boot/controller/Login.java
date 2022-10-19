package com.spring.boot.controller;

import com.spring.boot.service.MemberService;
import com.spring.boot.vo.Vo_member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
@Slf4j
public class Login {

    @Autowired
    MemberService memberService;

    @GetMapping("/login")
    public String doLogin(){
        return "/login/loginForm";
    }

    @PostMapping("/login_exe")
    public String doLoginExe(@RequestParam(value="loginId", defaultValue = "--") String strLoginId,
                             @RequestParam(value="password", defaultValue = "--") String strPassword,
                             Model model,
                             HttpServletRequest request){
        Vo_member vo_member = memberService.doMemberLogin(strLoginId);

        log.info("엔티티에서 받아온 사용자 아이디 ==> " + vo_member.getLoginId());
        log.info("엔티티에서 받아온 사용자 비밀번호 ==> " + vo_member.getPassword());
        log.info("파라미터로 넘겨받은 아이디(사용자가 입력한 아이디) ==> " + strLoginId);
        log.info("파라미터로 넘겨받은 비밀번호(사용자가 입력한 비밀번호) ==> " + strPassword);

        String strReturn = "";
        String strMessage = "";
        boolean bl_login = false;

        if(vo_member == null) {
            strReturn = "/login/loginForm";
            strMessage = "ID가 존재하지 않습니다.";
        }else {
            if(!strPassword.equals(vo_member.getPassword())){
                strReturn = "/login/loginForm";
                strMessage = "Password가 일치하지 않습니다.";
            }else{
                strReturn = "redirect:/";
                strMessage = "로그인 성공!";
                String strAuth = (String) request.getAttribute("ss_auth");
                log.info("로그인 후 권한 상태 ==> "+ strAuth);
                log.info("로그인한 사용자의 권한 ==> "+vo_member.getRole());
//                로그인을 했으면 true로 바꿈
                bl_login = true;
            }
        }

        model.addAttribute("message", strMessage);

        /* About Session
            * <<세션이 언제 생성되고 어떻게 사용되는지>>를 아는 것은 중요한 부분이다.
            * 1) 세션정보를 가져오는 컨트롤러 생성 및 정보 확인
            * 2) 세션은 언제 만들어질까?
            * 3) 이미지를 통한 세션의 이해
            * 4) 세션정보를 브라우저에서 쿠키값으로 확인
            * 5) 브라우저 간 세션정보는 어떻게 공유가 되는가?
            * 6) 로그인은 세션과 어떤 관계를 갖는가?
            * 7) 브라우저 쿠키의 세션값의 위변조에 대해
            *
            * 세션이 있으면 session의 정보를 가져오는 controller를 만든다.
            * 로그인의 정보를 세션에 담아야 한다.
            * 세션을 가져오기 위해서는 request 객체에서 가져와야 한다.
            *
            * */

        /* .getSession(true가 있는 것임)
            ==> 있는 세션이 있으면 가지고 와라
            ==> 없으면 만들어라
        */
        HttpSession session = request.getSession();

        /* 로그인이 되었으면? 세션이 속성값을 넣겠다!
        * ==> 이 속성값을 통해 브라우저가 사용자를 기억할 수 있다. */
        if(bl_login == true){
            log.info("로그인 성공!");
            session.setAttribute("ss_member_id", vo_member.getMemberId());
            session.setAttribute("ss_login_id", vo_member.getLoginId());
            session.setAttribute("ss_name", vo_member.getName());
            session.setAttribute("ss_role", vo_member.getRole());
        }


        return strReturn;
    }

    /* "/login/logout 처리 부분!" */
    @GetMapping("/logout")
    public String doLogout(HttpServletRequest request){
        /* false ==> 기존에 가지고 있는 세션을 쓰도록 하겠다. */
        HttpSession session = request.getSession(false);
        /* 세션을 버리는 메소드로 세션을 날리도록 하겠다. ==> 로그아웃 */
        session.invalidate();
        return "redirect:/";
    }

    /* 비밀번호*/
    @RequestMapping(value="/findIdView", method = RequestMethod.GET)
    public String findIdView(){
        return "/login/findIdView";
    }

    @RequestMapping(value="/findId", method=RequestMethod.POST)
    public String findId(Vo_member vo_member, Model model){
        log.info("memberName ==> "+vo_member.getName());
        /* 1) 사용자가 입력한 이름이 DB에 없을 경우
        *  2) 사용자가 입력한 이름이 DB에 있을 경우
        * */
        if(memberService.findIdCheck(vo_member.getName())==0){
            model.addAttribute("msg", "이름을 확인해 주세요.");
            return "/login/findIdView";
        }else {
            model.addAttribute("member", memberService.findId(vo_member.getName()));
            return "/login/findId";
        }

    }

}

