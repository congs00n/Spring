<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>회원등록</title>
    <%@include file="../../../common/easyui_common.jsp"%>
    <script>
        function choice(zipcode, address){
            $("#_easyui_textbox_input3").val(zipcode);
            $("#_easyui_textbox_input5").val(address);
            $("#dlg_zipcode").dialog('close');
        }

        function zipcodeSearch(){
            console.log("zipcodeSearch() 호출 성공!");
            const u_dong = $('#dong').textbox('getValue');
            $.ajax({
                url: "home/zipcode_list?dong="+u_dong
                ,method: "GET"
                ,success:function(data){
                    $("#d_zipcode").html(data);
                }
            });
        }

        function openSearchForm(){
            console.log("openSearchForm() 호출 성공!");
          $("#dlg_zipcode").dialog({
            title:"우편번호 찾기",
            href:"zipcode_search.jsp",
            modal:true,
            closed:true
          });
          $("#dlg_zipcode").dialog('open');
        }

        function memberShip() {
            // alert($("#mem_zipcode").textbox());
            $("#f_member").submit();
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
          </br>
          <form id="f_member" method="get" action="/home/memberInsert">
              <label for="mem_id">아이디</label>
              <input id="mem_id" name="mem_id" class="easy-textbox" style="width: 100px">
              </br>
              <label for="mem_pw">비  번</label>
              <input id="mem_pw" name="mem_pw" class="easy-textbox" style="width: 100px">
              </br>
              <label for="mem_name">이  름</label>
              <input id="mem_name" name="mem_name" class="easy-textbox" style="width: 100px">
              </br>
              <label for="mem_zipcode">우편번호</label>
              <input id="mem_zipcode" name="mem_zipcode" class="easy-textbox" style="width: 100px">
              <a href="javascript:openSearchForm()" class="easyui-linkbutton"> 우편번호 찾기 </a>
              </br>
              <label for="mem_address">주  소</label>
              <input id="mem_address" name="mem_name" class="easy-textbox" style="width: 100px">
              </br>
          </form>
          <a href="javascript:memberShip()" class="easyui-linkbutton"> 가입 </a>
          </br>
      </div>
<%--  우편번호 검색기 다이얼로그 화면 시작    --%>
      <div id="dlg_zipcode" footer="#btn_zipcode" class="easyui-dialog"
           title="우편번호찾기" data-options="modal:true, closed:true"
           style="width: 600px; height: 400px; padding: 10px;">
          <div id="btn_zipcode" align="right">
              <a href="javascript:zipcodeClose()" class="easyui-linkbutton" iconCls="icon-clear">닫기</a>
          </div>
      </div>
<%--  우편번호 검색기 다이얼로그 화면 끝    --%>
  </main>

<%-- footer 위치 --%>
<%@include file="/WEB-INF/views/comm/footer.jsp"%>

</body>
</html>