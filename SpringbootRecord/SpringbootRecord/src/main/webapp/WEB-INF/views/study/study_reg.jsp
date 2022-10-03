<%@ page import="java.util.List" %>
<%@ page import="com.spring.boot.vo.Vo_study" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Vo_study> list = (List<Vo_study>) request.getAttribute("study_list");
%>
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
      <p> request 객체 사용 > vo 객체 사용 > lombok 사용 > myBatis의 resultMap 사용 </p></br>
    </div>
    <div class="container text-right">
      <button type="button" onclick="location.href='/study/insert'"
              style="float: right; background-color: #FBEC88; border-radius: 10px">
        등록하기
      </button>
      <a href="javascript:loadDocArray()">ajax</a>
      </br>
    </div>
    </br>
    </br>

    <div class="container text-center" style="background-color: #95B8E7; border-radius: 10px; padding: 20px 20px;">
      <div class="row md-2">
        <div class="col">  </div>
        <div class="col"> 공부일자 </div>
        <div class="col"> 공부내용 </div>
        <div class="col"> 등록일자 </div>
        <div class="col"> 수정하기 </div>
        <div class="col"> 삭제하기 </div>
      </div>
    </div>
    <br>

    <%for(Vo_study vo_study : list) { %>
    <div class="container text-center">
      <div class="row md-2">
        <div class="col"> <%=vo_study.getKeyId()%> </div>
        <div class="col"> <%=vo_study.getStudyDay()%> </div>
        <div class="col"> <%=vo_study.getContents()%> </div>
        <div class="col"> <%=vo_study.getRegDay()%> </div>
        <div class="col"> <a href="/study/modify?key_id=<%=vo_study.getKeyId()%>"> 수정 </a>  </div>
        <div class="col"> <a href="/study/delete?key_id=<%=vo_study.getKeyId()%>"> 삭제 </a> </div>
      </div>
    </div>
    <% } %>

  </main>

<%-- footer 위치 --%>
<%@include file="/WEB-INF/views/comm/footer.jsp"%>

<%--<script>--%>
<%--  function loadDoc(){--%>
<%--    const xhttp = new XMLHttpRequest();--%>
<%--    xhttp.onreadystatechange = function() {--%>
<%--      if (this.readyState == 4 && this.state() == 200) {--%>
<%--        document.getElementById("demo").innerHTML =--%>
<%--                this.responseText;--%>
<%--      }--%>
<%--    };--%>
<%--    /* 아래 부분이 프로그램을 넣어햐 하는 WAS 부분이 되는 것이다.--%>
<%--    * 이 부분을 백엔드랑 바로 연결하면 프론트가 잘 되는지, 백이 잘 되는지 파악이 어렵다. */--%>
<%--      xhttp.open("GET", "");--%>
<%--      xhttp.send();--%>
<%--    }--%>
<%--</script>--%>

</body>
</html>