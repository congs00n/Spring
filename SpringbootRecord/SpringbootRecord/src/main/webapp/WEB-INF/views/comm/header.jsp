<%--
header
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String strLoginId = "guest";
    String strName = "guest";
    String strRole = "";

    String strLogInOut ="";
    /* 로그인 Or 로그아웃 뒤에 이동할 컨트롤러 경로! */
    String strUrl = "";

//    false로 하면 기존에 값이 있으면 그것을 사용하겠다는 것이다. (새로 만들지 않고!)
    session = request.getSession(false);
    if(session != null){
        strLoginId = (String) session.getAttribute("ss_login_id");
        strName = (String) session.getAttribute("ss_name");
        strRole = (String) session.getAttribute("ss_role");

        strLogInOut = "LogOut";
        strUrl = "/login/logout";
    }
//    session은 항상 있지만 속성값이 없는 경우의 조건도 따져줘야 한다.
    if(strLoginId == null) {
        strLoginId = "guest";
        strName = "guest";

        strLogInOut = "Login";
        strUrl = "/login/login";
    }

    String strAuth = (String) request.getAttribute("ss_auth");
    /* 권한이 null 이면 즉, 권한이 없으면 */
    if(strAuth == null) { strAuth = "N"; }
%>

<header class="p-3 text-bg-dark">
      <div class="container">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
            <img src="/img/heart.png" width="50px" height="50px">
            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                <li><a href="/home" class="nav-link px-2 text-secondary">🏠Home</a></li>

            <% if("Y".equals(strAuth)){%>
                <li><a href="/study/list" class="nav-link px-2 text-white"> 📚공부기록 </a></li>
                <li><a href="/home/member_reg" class="nav-link px-2 text-white"> 💗회원등록 </a></li>
                <li><a href="/member/list" class="nav-link px-2 text-white"> 👥회원목록조회실습 </a></li>
                <li><a href="/home/zipcode_search" class="nav-link px-2 text-white"> 💌우편번호조회실습 </a></li>
                <li><a href="/home/zipcode_list" class="nav-link px-2 text-white"> 🔎우편번호 리스트 </a></li>
                <li><a href="/file/file_reg" class="nav-link px-2 text-white"> 💾첨부파일 </a></li>
                <li><a href="/file/file_reg" class="nav-link px-2 text-white"> 📬쪽지하기 </a></li>
            <%}%>
            </ul>

          <div class="text-end">
            <label> <%=strName%>[<%=strRole%>]님 안녕하세요! </label> </br>
            <button type="button" class="btn btn-outline-light me-2" onclick="location.href='<%=strUrl%>'" ><%=strLogInOut%></button>

<%--              지금 아이디가 guest 와 같을때만 sign up 버튼을 보여주자         --%>
      <% if("guest".equals(strLoginId)) {%>
            <button type="button" class="btn btn-warning" onclick="location.href='/member/insert'">Sign-up</button>
        <%}%>

          </div>
        </div>
      </div>
</header>

