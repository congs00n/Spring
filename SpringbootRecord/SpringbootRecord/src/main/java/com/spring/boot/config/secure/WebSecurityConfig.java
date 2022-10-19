package com.spring.boot.config.secure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration // 어노테이션 기반 환경 설정을 한다.
@EnableWebSecurity // 모든 요청 URL이 스프링 시큐리티의 제어를 받도록 하는 어노테이션,, 이를 통해 내부적으로 SpringSecurityFilterChain이 동작한다.
/* WebSecurityConfigurerAdapter를 상속받아야 *시큐리티 설정* 을 활성화 할 수 있다. */
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        @Autowired
        HandlerLoginSuccess handlerLoginSuccess;

        @Autowired
        HandlerLoginFailure handlerLoginFailure;

        // http 인증관련 설정을 정한다.
        @Override
        public void configure(HttpSecurity http) throws Exception{

            /* 인가처리 부분 */
            http
                    /* url별 권한을 설정하기 위함*/
                    .authorizeRequests()
                    .antMatchers("/img/**","/css/**", "/js/**", "/", "/home", "/comm/**", "/secure/login").permitAll()

                    /* hasRole과 hanAuthority 중 hasRole을 더욱 많이 사용한다. */
                    /* study 로 시작하는 모든 부분은 MEMBER, ADMIN 모두가 볼 수 있다. */
                    .antMatchers("/study/**").hasAnyRole("MEMBER", "ADMIN")
                    /* member 로 시작하는 부분은 ADMIN 만 볼 수 있다. */
                    .antMatchers("/member/**").hasRole("ADMIN")
                    .anyRequest().authenticated();

                    /* study 로 시작하는 모든 부분은 MEMBER, ADMIN 모두가 볼 수 있다. */
        //                    .antMatchers("/study/**").hasAnyAuthority("MEMBER", "ADMIN")
                    /* member 로 시작하는 부분은 ADMIN 만 볼 수 있다. */
        //                    .antMatchers("/member/**").hasAuthority("ADMIN")


            /* formLogin 부분 */
            http.formLogin()
                    .loginPage("/secure/login")
                    .loginProcessingUrl("/secure/login_exe")
                    /* .usernameParameter({원하는 name}) 으로 사용자가 입력한 아이디 입력창 name을 설정할 수 있다. */
//                    .usernameParameter("user_name")

                    /* 로그인 성공 시 실행할 부분 => 성공시 실행할 객체를 만든다. */
                    .successHandler(handlerLoginSuccess)
                    /* 로그인 실패 시 실행할 부분 => 실패시 실행할 객체를 만든다. */
                    .failureHandler(handlerLoginFailure)

                    /* 로그인 성공 시 도달할 url */
                    //.defaultSuccessUrl("/") // .defaultSuccessUrl() 이 있으면 .successHandler 가 무시가 된다.
                    .permitAll();

            http.logout()
                    .permitAll();

            /* csrf()를 방지 한다. */
            http.csrf()
                    .disable();

    }



}
