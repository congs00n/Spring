<%@ page import="com.spring.boot.vo.Vo_study" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Home</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">

</head>
<body>

<%-- header 위치 --%>
<%@include file="/WEB-INF/views/comm/header.jsp"%>

  </br>

  <main>
    <div class="container text-center">
        <form name="frm_study_ins" action="/study/insert_exe" method="post" style="background-color: #AACCFF; padding: 200px 200px; border-radius: 10px">

            <div>공부일자 : <input type="text" name="studyDay"></div>
            <br>
            <div>공부내용 : <textarea name="contents"></textarea></div>
            <br>

<%--            수정하기를 누르면 form 태그의 action 주소 번지로 간다. --%>
        <input type="submit" value="등록하기" style="border-radius: 5px">
        </form>
    </div>
  </main>

<%-- footer 위치 --%>
<%@include file="/WEB-INF/views/comm/footer.jsp"%>

</body>
</html>