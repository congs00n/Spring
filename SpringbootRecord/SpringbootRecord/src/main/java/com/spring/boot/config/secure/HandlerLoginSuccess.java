package com.spring.boot.config.secure;

import com.spring.boot.service.MemberService;
import com.spring.boot.vo.Vo_member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Member;

@Component
public class HandlerLoginSuccess implements AuthenticationSuccessHandler {

    @Autowired
    MemberService memberService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        System.out.println("===================== onAuthenticationSuccess ======================");

        Vo_member vo_member = memberService.doMemberLogin(authentication.getName());

        /* ========================= 성공시 보여줄 메세지를 세션값에 담는다. ============================= */
        HttpSession session = request.getSession();

        session.setAttribute("ss_member_id", vo_member.getMemberId());
        session.setAttribute("ss_login_id", vo_member.getLoginId());
        session.setAttribute("ss_name", vo_member.getName());
        session.setAttribute("ss_role", vo_member.getRole());


        /* ================================ 성공시 url 이동 위치 =====================================
        1) 디폴트 한 가지 경로를 지정할 수 있다.
        2) 시큐리티가 요청을 가로채기 전에 사용자가 요쳥했던 URL 경로로 지정할 수 있다.
        * ======================================================================================== */

        /* 1) 의 경우에 이동할 디폴트 경로 */
        String strUrl = "/";

        /* 2) 의 경우에 이동할 경로를 구하는 방법 */
        /* RequestCache ==> Security 가 요청을 가로챈 경우에 사용자가 직전에 요청했던 URL 을 저장해주는 객체이다. */
        RequestCache requestCache = new HttpSessionRequestCache();
        SavedRequest savedRequest = requestCache.getRequest(request, response); // requestCache가 저장한 URL의 요청과 응답을 savedRequest 객체가 저장한다.

        /* 사용자가 직전에 요청한 url 이 있을 경우에 */
        if(savedRequest != null){
            strUrl = savedRequest.getRedirectUrl(); // 저장된 요청의 redirect url을 경로에 저장한다.
            requestCache.removeRequest(request, response); // 세션에 저장된 객체를 다 사용한 후에는 지워서 메모리 누수를 방지한다.
        }

        response.sendRedirect(strUrl);
    }
}
