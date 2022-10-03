package com.spring.boot.controller;

import com.google.gson.Gson;
import com.spring.boot.service.CommonLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

// json 포맷을 사용하는 controller 입니다.
// @Controller + @ResponseBody 결과와 같습니다.
@RestController
public class CommonController {

    /* required=false 인자의 의미는?
    * 의존성을 선택적으로 주입하는 것이다. */
    @Autowired(required = true)
    private CommonLogic commonLogic = null;

    @GetMapping("/zipcode/jsonZipcodeList")
    public String zipcodeList(@RequestParam String dong){
        List<Map<String, Object>> zipList = null;
        zipList = commonLogic.zipcodeList(dong);
        Gson g = new Gson();
        String imsi = g.toJson(zipList);
        return imsi;
    }
}
