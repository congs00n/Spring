package com.spring.boot.service;

import com.spring.boot.dao.MemDao;
import com.spring.boot.dao.StudyDao;
import com.spring.boot.vo.Vo_member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

@Service
public class MemberService {
    @Autowired
    MemDao memDao;

    public List<Vo_member> doMemberList(){
        List<Vo_member> memList = new ArrayList<>();
        memList = memDao.doMemberList();
        return memList;
    }

    public int doMemberIns(Vo_member vo_member) {
        int intI = memDao.doMemberIns(vo_member);
        return intI;
    }

    public int doMemberDel(String strKeyId) {
        int intI = memDao.doMemberDel(strKeyId);
        return intI;
    }

    public Vo_member doMemberLogin(String strLoginId) {
        Vo_member vo_member = memDao.doMemberLogin(strLoginId);
        return vo_member;
    }
}
