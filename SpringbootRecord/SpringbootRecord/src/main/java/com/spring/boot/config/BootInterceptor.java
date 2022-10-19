package com.spring.boot.config;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/* 컨트롤러에 들어오기 이전에 인가처리를 하고 싶다!!
* @component를 해야 bean IoC가 해당 클래스를 읽는다.
*/
//@Component
public class BootInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {

        HttpSession session = request.getSession();
        String strLoginId = (String) session.getAttribute("ss_login_id");
        System.out.println("preHandle => " + strLoginId);

        /* session 에 로그인 값이 담겨 있지 않을 경우라면 == 로그인이 안된 상태
        * 로그인 화면으로 가라 */
        if(strLoginId == null){
            System.out.println("preHandle => no Login");
            response.sendRedirect("/login/login");

            /* false로 하면 그 다음 컨트롤러로 넘어가지 않는다. */
            return false;
        }else{
            System.out.println("preHandle => 로그인이 되었으니 원하는 곳으로 가세요");
            return true;
        }
    }
}
