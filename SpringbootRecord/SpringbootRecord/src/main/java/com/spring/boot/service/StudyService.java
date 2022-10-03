package com.spring.boot.service;

import com.spring.boot.dao.StudyDao;
import com.spring.boot.vo.Vo_study;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudyService {
    @Autowired
    StudyDao studyDao;

    public List<Vo_study> doStudyList(){
        List<Vo_study> studyList = new ArrayList<>();
        studyList = studyDao.doStudyList();
       return studyList;
    }

    /* 앞서 getParameter()를 통해 얻은 키값을 받아서
    * 해당 키값에 해당하는 One Row를 수정하는 logic */
    public Vo_study doStudyListOne(String strKeyId){
        Vo_study vo_study = new Vo_study();
        vo_study = studyDao.doStudyListOne(strKeyId);
       return vo_study;
    }


    /* 공부기록 수정 */
    public int doStudyUp(Vo_study vo_study) {
        int intI = studyDao.doStudyUp(vo_study);

        return intI;
    }

    /* 공부기록 삭제 */
    public int doStudyDel(String strKeyId) {
        int intI = studyDao.doStudyDel(strKeyId);

        return intI;
    }

    /* 회원 등록 (가입) */
    public int doStudyIns(Vo_study vo_study) {
        int intI = studyDao.doStudyIns(vo_study);

        return intI;
    }
}
