package com.spring.boot.service;

import com.spring.boot.dao.MemberDao;
import com.spring.boot.dao.MemoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MemoLogic {
    @Autowired
    private MemoDao memoDao;

    public int memoInsert(Map<String, Object> pMap) {
        return 0;
    }
}
