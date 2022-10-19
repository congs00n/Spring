package com.spring.boot.controller;

import com.spring.boot.service.CommonLogic;
import com.spring.boot.service.MemberService;
import com.spring.boot.service.StudyService;
import com.spring.boot.vo.Vo_member;
import com.spring.boot.vo.Vo_study;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/home")
@Slf4j
public class Home {

//    루트로 req가 오면 views 밑에 있는 home.html으로 이동을 한다.
//    return "/WEB-INF/views/home.jsp"
//    확징자가 "/WEB-INF/views/xxx.html" 이면 에러 화면이 뜨게 된다. 왜?
//    ** (중요) controller 에서 view 로 넘어갈 때 req가 출발을 해서 controller에서 멈추는 것이 아니라 view로 다이렉트로 가는 것이다 **

    @Autowired
    StudyService studyService;

    @Autowired
    MemberService memberService;

    @Autowired
    CommonLogic commonLogic;


//    @Autowired
//    Vo_study vo;

    @GetMapping("")
    public String doHome(){
        return "/home/home";
    }

    @GetMapping("/study_reg")
    public String doStudy_reg(HttpServletRequest request, Model model){

            List<Vo_study> studylist = new ArrayList<>();
            studylist = studyService.doStudyList();

//            System.out.println("voStudy를 쓰겠다.");
        /*
            log.info("vo_study");
            for(Vo_study vo : studylist){
                log.info(vo.getKeyId());
                log.info(vo.getStudyDay());
                log.info(vo.getContents());
                log.info(vo.getRegDay());
            }

         */

            // request 객체에 값을 담는 방법..
             request.setAttribute("study_list", studylist);

            // model 객체에 값을 담는 방법..
            // model.addAttribute("study_list", studylist);
            return "/study/study_reg";
    }

    @GetMapping("/member_reg")
    public String doMember_reg(){
        return "/home/member_reg";
    }

    @GetMapping("/member_list")
    public String doMember_list(){
        return "/home/member_list";
    }

    @GetMapping("/zipcode_search")
    public String goSearch(){
        return "/home/zipcode_search";
    }

    @GetMapping("/zipcode_list")
    public String goList(@RequestParam String dong, Model model){
        List<Map<String, Object>> zipList = null;
        zipList = commonLogic.zipcodeList(dong);
        model.addAttribute("zipList", zipList);
        return "/home/zipcode_list";
    }


}


/**
 @RequestMapping("/home")
 public String doHome2(){
 - response.reDirect() 는 요청 뒤에 응답을 던지기 때문에 컨트롤러에서 흐름이 한 번 끊긴다.
 - 끊긴 흐름 처음 req가 그대로 이어지지 않음 ==> 따라서 URL이 바뀌게 된다.
 return "redirect:/WEB-INF/views/home.html";
 }

 @RequestMapping("/home3")
 public String doHome3(){
 return "redirect:/base/home.html";
 }
 **/
