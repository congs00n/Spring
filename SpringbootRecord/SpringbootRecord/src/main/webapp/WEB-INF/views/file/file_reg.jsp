<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>첨부파일 연습</title>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="../../../data.js" ></script>
<%--    easy-ui     --%>
    <%@include file="../../../common/easyui_common.jsp"%>
<%--    bootstrap   --%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<script>
    $(function(){
        $("#search_box").autocomplete({
            source:List,
            focus : function(event, ui){
                return false;
            },
            minLength: 1,
            delay : 100
        })
    })
</script>
<body>
<%-- header 위치 --%>
<%@include file="/WEB-INF/views/comm/header.jsp"%>

    <div class="container text-center" style="margin-top: 100px; margin-bottom: 100px">
        <form id="fileUpload" action="" method="get">
            <label>파일이름</label>
            <input id="file_name" name="file_name" class="easy-textbox" style="width: 100px">
            <a href="#" class="easyui-linkbutton"> 업로드 </a>
            </br>
        </form>
    </div>

    <div class="container text-center" style="margin-top: 100px; margin-bottom: 100px">
            <label>자동 검색어 추천</label>
            <input id="search_box" type="text" name="file_name" style="width: 100px">
    </div>

<%-- footer 위치 --%>
<%@include file="/WEB-INF/views/comm/footer.jsp"%>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"
        integrity="sha512-uto9mlQzrs59VwILcLiRYeLKPPbS/bT71da/OEBYEwcdNUk8jYIy+D176RYoop1Da+f9mvkYrmj5MCLZWEtQuA=="
        crossorigin="anonymous"
        referrerpolicy="no-referrer"
></script>
</body>
</html>
