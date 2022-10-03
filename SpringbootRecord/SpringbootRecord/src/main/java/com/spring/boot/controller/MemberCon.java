package com.spring.boot.controller;

import com.spring.boot.service.MemberService;
import com.spring.boot.vo.Vo_member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/member")
@Slf4j
public class MemberCon {
    @Autowired
    MemberService memberService;

    /* 전체 멤버 조회 */
    @GetMapping("/list")
    public String doMemberList( Model model){

        List<Vo_member> list = new ArrayList<>();
        list = memberService.doMemberList();

        model.addAttribute("list", list);

        return  "/member/member_list";
    }

    /* 입력 */
    @GetMapping("/insert")
    public String doIns(){
        //System.out.println("Controller - insert");
        return "/member/member_join";
    }

    /* 입력 실행 */
    @PostMapping("/insert_exe")
    public String doInsExe(@ModelAttribute Vo_member vo_member){
        int intI = memberService.doMemberIns(vo_member);
        return "redirect:/member/list";
    }

    /* 회원 삭제 */
    @GetMapping("/delete")
    public String doDel(HttpServletRequest request){
        String strKeyId = request.getParameter("key_id");
        log.info("삭제할 키값 ==> "+strKeyId);
        int intI = memberService.doMemberDel(strKeyId);

        return "redirect:/member/list";
    }
}
