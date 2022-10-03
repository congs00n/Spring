package com.spring.boot.service;

import com.spring.boot.dao.CommonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CommonLogic {

    @Autowired
    private CommonDao commonDao = null;

    public List<Map<String,Object>> zipcodeList(String dong) {
        List<Map<String, Object>> zipList = null;
        zipList = commonDao.zipcodeList(dong);
        return zipList;
    }
}
