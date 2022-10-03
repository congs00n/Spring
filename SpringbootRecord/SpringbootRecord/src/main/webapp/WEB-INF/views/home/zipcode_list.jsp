<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%
        List<Map<String, Object>> zipList =
                (List<Map<String, Object>>)request.getAttribute("zipList");
%>
<html>
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


    <div class="container text-center">
        <br>
        <h1>우편번호 리스트</h1>
        <hr>
        <table style="border: 5px; width: 500px;">
            <tr>
                <th>우편번호</th>
                <th>우편주소</th>
            </tr>
        <%
            if(zipList == null || zipList.size()==0){
        %>
            <tr>
                <td colspan="2">조회결과가 없습니다.</td>
            </tr>
        <%
            }else{
            for(int i = 0;i<zipList.size(); i++){
                Map<String,Object> rmap = zipList.get(i);
        %>
            <tr>
                <td><a href="javascript:choice('<%=rmap.get("ZIPCODE")%>','<%=rmap.get("ADDRESS")%>')"><%=rmap.get("ZIPCODE")%></a></td>
                <td><%=rmap.get("ADDRESS")%></td>
            </tr>
        <%
            }
        }
        %>
        </table>
    </div>

    <%-- footer 위치 --%>
    <%@include file="/WEB-INF/views/comm/footer.jsp"%>

</body>
</html>
