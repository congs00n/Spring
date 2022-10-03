package com.spring.boot.dao;

import com.spring.boot.vo.Vo_member;
import com.spring.boot.vo.Vo_study;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/* Dao 명명규칙 준수해서 바꿔볼 것!!
*  Dao 에서는 예외처리를 하면 X
* -> 트랜잭션 관련한 처리를 *서비스단 혹은 컨트롤러* 에서 해야 하기 때문에
*/
@Mapper
public interface StudyDao {
    // 값을 가져오는 추상 메소드
    // doStudyList() 에 해당하는 xml을 가져오도록 구체적으로 오버라이딩 해야 한다.

    /* 공부 기록 전체 리스트 */
    public List<Vo_study> doStudyList();
    public List<Vo_member> doMemberList();

    /* 공부 기록 One row */
    public Vo_study doStudyListOne(String strKeyId);

    /* 공부 기록 수정 */
    public int doStudyUp(Vo_study vo_study);

    /* 공부 기록 삭제 */
    public int doStudyDel(String strKeyId);

    public int doStudyIns(Vo_study vo_study);
}
