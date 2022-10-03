<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Home</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">

</head>
<body>

<%-- header 위치 --%>
<%@include file="/WEB-INF/views/comm/header.jsp"%>
 
  <main>
    <div class="px-4 py-5 my-5 text-center">
      <img class="d-block mx-auto mb-4" src="/img/congsoon.png" alt="" width="100" height="100" style="border-radius: 10px">
      <h1 class="display-5 fw-bold">Spring Study</h1>
      <hr>
      <div class="col-lg-6 mx-auto">
        <p class="lead mb-4">
          자바 웹 개발을 위해 Spring boot 를 공부하고 있습니다. </br>
          IT 늦공 유튜브를 보며 스스로 공부한 내용을 까먹지 않기 위해 만들고 있습니다.</br>
          열심히 해보자~! </br>
        </p>
          Java 버전 : 11 </br>
          개발툴 : Intelli J </br>
          DBMS : ORACLE 11 </br>
          View : JSP </br>
          MAPPER : MYBATIS </br>
      </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
  </main>


<%-- footer 위치 --%>
<%@include file="/WEB-INF/views/comm/footer.jsp"%>

</body>
</html>