package com.spring.boot.controller;

import com.spring.boot.service.MemberLogic;
import com.spring.boot.service.MemoLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/home")
public class MemoController {
    @Autowired(required = false)
    private MemoLogic memoLogic;

//    @GetMapping("/memoInsert")
//    public String memoInsert(@RequestParam Map<String, Object> pMap){
//
////        회원 등록 후에는 보통 로그인 화면으로 가기때문에 로그인 화면으로 간다.
//        return "/login/login";
//    }
}
