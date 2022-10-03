<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>첨부파일 연습</title>
<%--    easy-ui     --%>
    <%@include file="../../../common/easyui_common.jsp"%>
<%--    bootstrap   --%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body>
<%-- header 위치 --%>
<%@include file="/WEB-INF/views/comm/header.jsp"%>

    <div class="container text-center" style="margin-top: 100px; margin-bottom: 100px">
        <form id="fileUpload" action="get">
            <label>파일이름</label>
            <input id="file_name" name="file_name" class="easy-textbox" style="width: 100px">
            <a href="#" class="easyui-linkbutton"> 업로드 </a>
            </br>
        </form>
    </div>

<%-- footer 위치 --%>
<%@include file="/WEB-INF/views/comm/footer.jsp"%>
</body>
</html>
