package com.spring.boot.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MemoDao {
    @Autowired(required = false)
    private SqlSessionTemplate sqlSessionTemplate = null;

    public int memoinsert(Map<String, Object> pMap) {
        int result=0;

        try {
            sqlSessionTemplate.selectOne("proc_memoinsert", pMap);
            if(pMap.get("result")!=null){
                result = Integer.parseInt(pMap.get("result").toString());
            }
        }catch (DataAccessException e){
            System.out.println("Exception ==> "+ e);
        }
        return result;
    }
}
