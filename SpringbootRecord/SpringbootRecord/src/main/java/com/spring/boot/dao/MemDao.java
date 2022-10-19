package com.spring.boot.dao;

import com.spring.boot.vo.Vo_member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemDao {
    public List<Vo_member> doMemberList();

    public int doMemberIns(Vo_member vo_member);

    public int doMemberDel(String strKeyId);

    /* 로그인 */
    public Vo_member doMemberLogin(String strLoginId);

    /* 사용자가 입력한 이메일로 아이디 찾기 */
    public Vo_member findId(String strName);

    public int findIdCheck(String strName);
}
