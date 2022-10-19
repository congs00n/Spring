package com.spring.boot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

//@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

 //   BootInterceptor에서 설정한 부분을 실제로 실행하는 클래스


    @Autowired
    BootInterceptor bootInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(bootInterceptor)
                .addPathPatterns("/**") // 모든 위치에서 인터셉터를 다 적용하겠다.
                .excludePathPatterns("/", "/home", "/login/**", "/img/**", "/member/insert"); // 예외 적용

    }




}
