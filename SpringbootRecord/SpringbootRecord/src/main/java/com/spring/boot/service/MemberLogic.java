package com.spring.boot.service;

import com.spring.boot.dao.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MemberLogic {
    @Autowired
    private MemberDao memberDao;

    public int memberInsert(Map<String, Object> pMap) {
        int result=0;
        memberDao.memberinsert(pMap);
        return result;
    }
}
