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

    /* 전체 멤버 리스트를 조회한다. */
    public List<Vo_member> doMemberList(){
        List<Vo_member> memList = new ArrayList<>();
        memList = memDao.doMemberList();
        return memList;
    }

    /* 멤버를 등록한다 == 회원가입 */
    public int doMemberIns(Vo_member vo_member) {
        int intI = memDao.doMemberIns(vo_member);
        return intI;
    }

    /* 멤버를 삭제한다 == 회원탈퇴 */
    public int doMemberDel(String strKeyId) {
        int intI = memDao.doMemberDel(strKeyId);
        return intI;
    }

    /* 로그인한다.*/
    public Vo_member doMemberLogin(String strLoginId) {
        Vo_member vo_member = memDao.doMemberLogin(strLoginId);
        return vo_member;
    }

    public Vo_member findId(String strName){
        Vo_member vo_member = memDao.findId(strName);
        return vo_member;
    }

    public int findIdCheck(String strName){
        int intI = memDao.findIdCheck(strName);
        return intI;
    }
}
