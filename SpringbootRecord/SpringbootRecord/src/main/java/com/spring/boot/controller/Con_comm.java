package com.spring.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

@RestController
@RequestMapping("/comm")
public class Con_comm {

    @GetMapping("/sessionInfo")
    public String doSession(HttpServletRequest req) {

        String strReturn="";
        HttpSession session = req.getSession();

        /* 세션의 ID를 가져온다 */
        String strSessionId = session.getId();
        strReturn = "session ID : "+ strSessionId + "<br>";
        System.out.println("session ID ==> " + strSessionId);

        /* 세션이 가지고 있는 모든 속성값을 배열에 넣는다. */
        Enumeration<String> names = session.getAttributeNames();

        /* Enumeration 추출 */
        String strSession="";
        /* names 있으면.. */
        while (names.hasMoreElements()) {
            strSession = names.nextElement();
            strReturn+=session.getAttribute(strSession) + "</br>";
            /* 화면에 뿌린다. */
//            System.out.println(strSession + " : " + session.getAttribute(strSession));
        }
        return strReturn;
    }
}
