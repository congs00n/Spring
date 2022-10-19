<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String strMessage = (String) request.getAttribute("message");

  if(strMessage == null){
    strMessage = "ID와 Password를 입력하세요.";
  }
%>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Home</title>
  <link rel="canonical" href="https://getbootstrap.com/docs/5.2/examples/sign-in/">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body class="text-center">

<%-- header 위치 --%>
<%@include file="/WEB-INF/views/comm/header.jsp"%>

  </br>
  </br>
  </br>
  </br>

  <main class="form-signin w-50 m-auto">
    <form action="/login/login_exe" method="post"
          style="background-color: #AACCFF; padding: 50px 50px; border-radius: 10px">
      <br>
      <br>
      <h1 class="h3 mb-3 fw-normal">Please sign in</h1>
      <div>
        <label><%=strMessage%></label>
      </div>
      <br>

      <div class="form-floating">
        <input type="text" name="loginId" class="form-control" id="floatingInput">
        <label for="floatingInput">Member ID</label>
      </div>
      <div class="form-floating">
        <input type="password" name="password" class="form-control" id="floatingPassword" placeholder="Password">
        <label for="floatingPassword">Password</label>
      </div>
      <br>
      <button class="w-100 btn btn-lg btn-primary" type="submit">Login</button>
      <br>
      <br>
      <br>
    </form>
  </main>

  </br>
  </br>
  </br>
  </br>

<%-- footer 위치 --%>
<%@include file="/WEB-INF/views/comm/footer.jsp"%>

</body>
</html>