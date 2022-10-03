package com.spring.boot.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// @Repository로 정하면 인터페이스 코드 전개 - sql 문도 어노테이션 사용하게 된다.
@Service
public class CommonDao {
    @Autowired(required = false)
    private SqlSessionTemplate sqlSessionTemplate = null;
    public List<Map<String, Object>> zipcodeList(String dong) {
        List<Map<String, Object>> zipList = null;
        Map<String, Object> pMap = new HashMap<>();
        pMap.put("dong", dong);
        try {
            sqlSessionTemplate.selectOne("proc_zipcode", pMap);
            zipList = (List<Map<String, Object>>)pMap.get("key");
        }catch (DataAccessException e){
            System.out.println("Exception ==> "+ e);
        }
        return zipList;
    }
}
