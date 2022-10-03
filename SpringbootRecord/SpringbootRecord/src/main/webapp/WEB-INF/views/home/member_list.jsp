<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.spring.boot.vo.Vo_member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  List<Vo_member> list = (List<Vo_member>) request.getAttribute("member_list");
%>

<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Home</title>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
  <%@include file="../../../common/easyui_common.jsp"%>
  <script>
        function choice(zipcode){
            $("#_easyui_textbox_input3").val(zipcode);
            $("#_easyui_textbox_input5").val(address);
            $("#dlg_zipcode").dialog('close');
        }

        function zipcodeSearch(){
            const u_dong = $('#dong').textbox('getValue');
            $.ajax({
                url: "home/zipcode_list?dong="+u_dong
                ,method: "GET"
                ,success:function(data){
                    $("#d_zipcode").html(data);
                }
            });
        }
        function searchForm(){
          $("#dlg_zipcode").dialog({
            title:"우편번호 찾기",
            href:"zipcode_search.jsp",
            modal:true,
            closed:true
          });
          $("#dlg_zipcode").dialog('open');
        }

  </script>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body>

<%-- header 위치 --%>
<%@include file="/WEB-INF/views/comm/header.jsp"%>


  </br>
  
  <main>
    <div class="container text-center">
      <div class="row md-2">
        <div class="col"> 아이디 </div>
        <div class="col"> 이름 </div>
        <div class="col"> 권한 </div>
        <div class="col"> 등록일자 </div>
        <div class="col"> 회원삭제 </div>
      </div>
    </div>

    <% for(Vo_member vo_member : list) { %>
    <div class="container text-center">
      <div class="row md-2">
        <div class="col"><%= vo_member.getLoginId() %></div>
        <div class="col"><%= vo_member.getName() %></div>
        <div class="col"><%= vo_member.getRole() %></div>
        <div class="col"><%= vo_member.getRegDay() %></div>
        <div class="col"><a href="/member/delete?key_id=<%= vo_member.getMemberId() %>">삭제</a></div>
      </div>
    </div>
    <% } %>
  </main>

<%-- footer 위치 --%>
<%@include file="/WEB-INF/views/comm/footer.jsp"%>

</body>
</html>