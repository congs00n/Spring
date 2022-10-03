package com.spring.boot.controller;

import com.spring.boot.service.StudyService;
import com.spring.boot.vo.Vo_study;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


/* 등록, 수정, 삭제 이 세가지 컨트롤을 담는 클래스 입니다.*/
@Controller
@RequestMapping("/study")
@Slf4j
public class StudyRegCon {

        @Autowired
        StudyService studyService;

    @GetMapping("/list")
    public String doStudy_reg(HttpServletRequest request, Model model){

        List<Vo_study> list = new ArrayList<>();
        list = studyService.doStudyList();

        request.setAttribute("study_list", list);
        return "/study/study_reg";
    }

        /*입력*/
        @GetMapping("/insert")
        public String doIns(){
            return "/study/study_form";
        }

        /*수정
        * 수정을 하기 위해서는 단일 SELECT 먼저 진행이 되어야 한다.
        * 따라서 선택된 parameter를(request로 받아온) 인자로 사용해서 Service와 DAO 단에서 데이터를 가져오도록 관리한다.
        * 그리고 그 데이터를 View에 띄워준다.
        * */
        @GetMapping("/modify")
        public String doMod(HttpServletRequest request){
            String strKeyId = request.getParameter("key_id");
            log.info("수정할 키값 ==> "+strKeyId);
            Vo_study vo_study = new Vo_study();
            vo_study = studyService.doStudyListOne(strKeyId);

            request.setAttribute("oneStudy", vo_study);

            /**/
            return "/study/study_mod";
        }

        /* 수정 - 실행
        * @ModelAttribute
        * ==> vo 객체의 값을 한번에 받아올 수 있는 기능.
        * ==> 쿼리스트링을 자동으로 모두 매핑해준다.
        *  */
        @PostMapping("/modify_exe")
        public String doModExe(@ModelAttribute Vo_study vo_study){

            /* 실질적으로 수정 서비스를 실행해 주는 곳 */
            int intI = studyService.doStudyUp(vo_study);

            /* 수정이 끝나고 갈 위치를 지정해 준다. -> 수정이니 따로 넘겨줄 부분은 없다. */

            /* jsp를 호출하는 것이 아닌.. Home 컨트롤러에 속해있는 컨트롤러를 호출해준다. */
            return "redirect:/study/list";
        }

        /*삭제*/
        @GetMapping("/delete")
        public String doDel(HttpServletRequest request){
            String strKeyId = request.getParameter("key_id");
            log.info("삭제할 키값 ==> "+strKeyId);
            int intI = studyService.doStudyDel(strKeyId);

            return "redirect:/study/list";
        }

    /* 입력 - 실행
     * @ModelAttribute
     * ==> vo 객체의 값을 한번에 받아올 수 있는 기능.
     * ==> 쿼리스트링을 자동으로 모두 매핑해준다.
     *  */
    @PostMapping("/insert_exe")
    public String doInsExe(@ModelAttribute Vo_study vo_study){

        /* 실질적으로 입력 서비스를 실행해 주는 곳 */
        int intI = studyService.doStudyIns(vo_study);

        /* 입력이 끝나고 갈 위치를 지정해 준다. -> 수정이니 따로 넘겨줄 부분은 없다. */

        /* jsp를 호출하는 것이 아닌.. Home 컨트롤러에 속해있는 컨트롤러를 호출해준다. */
        return "redirect:/study/list";
    }
}
