package com.spring.boot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class First {
    @GetMapping("")
    public String doFirst(HttpServletRequest request){
        /* 첫 부분! */
        String strRole = "";
        String strAuth = "N";

        HttpSession session = request.getSession();
        if( session != null){
            strRole = (String) session.getAttribute("ss_role");
            log.info("첫 화면에서 로그인한 사용자 권한은 ==> "+ strRole);
        }
        if( strRole !=null && "ADMIN".equals(strRole)){
            strAuth = "Y";
            log.info("첫 화면에서 로그인한 사용자 인가 상태는 ==> "+ strAuth);

        }

        request.setAttribute("ss_auth", strAuth);

        return "/home/home";
    }
}
