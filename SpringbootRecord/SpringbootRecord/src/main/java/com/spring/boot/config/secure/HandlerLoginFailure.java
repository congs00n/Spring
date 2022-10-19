package com.spring.boot.config.secure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@Component
@Slf4j
public class HandlerLoginFailure implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        System.out.println("=====================onAuthenticationFailure======================");

        // 실패 시 메세지
        String strErrorMsg = exception.getMessage();

        String strMsg ="";

            if(strErrorMsg == null){
                strMsg = "입력하신 계정을 찾지 못했습니다.";
                log.info("strErrorMsg == null ---> "+ strMsg);
            }else{
                strMsg = exception.getMessage()+"비밀번호를 체크해 주세요";
                log.info("else ---> "+ strMsg);
            }
            strMsg = URLEncoder.encode(strMsg, "UTF-8"); // 한글 인코딩 꺠지는 문제 방지

        String strUrl="/secure/login?message=";

        // 이동 위치
        response.sendRedirect(strUrl+strMsg);


        // 실패 시 이동할 url
    }
}
