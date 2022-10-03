<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>우편번호 조회</title>
    <%@include file="../../../common/easyui_common.jsp"%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body>
    <%-- header 위치 --%>
    <%@include file="/WEB-INF/views/comm/header.jsp"%>

    <div class="container text-center" style="margin-top: 100px; margin-bottom: 100px">
        <label for="dong">동이름입력</label>
        <input id="dong" name="dong" class="easyui-textbox" style="width: 300px">
        <a href="javascript:zipcodeSearch()" class="easyui-linkbutton">🔎 검색</a>
        <hr>
        <div id="d_zipcode">
            여기에 검색 결과가 조회될 것임
        </div>
    </div>


    <%-- footer 위치 --%>
    <%@include file="/WEB-INF/views/comm/footer.jsp"%>
</body>
</html>
