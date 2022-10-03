package com.spring.boot.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 모델 계층에 붙이는 @Component의 자손 어노테이션이다.
@Service
public class MemberDao {
    @Autowired(required = false)
    private SqlSessionTemplate sqlSessionTemplate = null;

    public int memberinsert(Map<String, Object> pMap) {
        int result=0;

        try {
            sqlSessionTemplate.selectOne("proc_memberinsert", pMap);
            if(pMap.get("result")!=null){
                result = Integer.parseInt(pMap.get("result").toString());
            }
        }catch (DataAccessException e){
            System.out.println("Exception ==> "+ e);
        }
        return result;
    }
}
