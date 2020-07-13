<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>학사관리 시스템</title>
   <link rel="stylesheet" href="../home.css">
   <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
</head>
<body>
   <div id="divPage">
      <div id="divTop"><jsp:include page="../header.jsp"/></div>
      <div id="divCenter">
         <div id="divMenu"><jsp:include page="../menu.jsp"/></div>
         <div id="divContent">
         <!-- 여기에 출력 내용 시작 -->
         <div id="divHeader"><h2>교 수 등 록</h2></div>
         <form name="frm" action="update" method="post">
             <table>
                <tr>
                  <td width=100 class="title" width=150>교수번호</td>
                  <td width=100><input type="text" name="pcode" value="${vo.pcode}" size=10 placeholder="교수번호"></td>
                  <td width=100 class="title" width=150>교수학과</td>
                  <td width=100>
                      <select name="dept">
                     <option <c:out value="${vo.dept=='전산'?'selected':''}"/>>전산</option>
                     <option <c:out value="${vo.dept=='전자'?'selected':''}"/>>전자</option>
                     <option <c:out value="${vo.dept=='건축'?'selected':''}"/>>건축</option>
                   </select>
                   </td>
                  <td width=100 class="title" width=150>임용일자</td>
                  <td>
                     <input type="text" name="yy" value="${fn:substring(vo.hiredate,0,4)}" maxlength=4 size=2 placeholder="yyyy">년
                     <input type="text" name="MM" value="${fn:substring(vo.hiredate,5,7)}" maxlength=2 size=2 placeholder="MM">월
                     <input type="text" name="dd" value="${fn:substring(vo.hiredate,8,10)}" maxlength=2 size=2 placeholder="dd">일
                  </td>
                </tr>
                <tr>
                  <td width=100 class="title" width=150>교수이름</td>
                  <td width=100><input type="text" name="pname" value="${vo.pname}" size=10 placeholder="교수이름"></td>
                  <td width=100 class="title" width=150>교수급여</td>
                  <td><input type="text" name="salary" value="${vo.salary}" maxlength=12 placeholder="급여"></td>
                  <td width=100 class="title" width=150>교수직급</td>
                  <td>
                     <input type="radio" name="title" value="정교수" <c:out value="${vo.title=='정교수'?'checked':''}"/>>정교수
                     <input type="radio" name="title" value="부교수" <c:out value="${vo.title=='부교수'?'checked':''}"/>>부교수
                     <input type="radio" name="title" value="조교수" <c:out value="${vo.title=='조교수'?'checked':''}"/>>조교수
                  </td>
                </tr>
             </table>
             <div id="pagination">
                 <input type="submit" value="저장" >
                 <input type="button" value="삭제" id="btnDelete">  
                 <input type="reset" value="취소">
              </div>
         </form>
         <div id="divHeader"><h2>담 당 강 좌</h2></div>
         <table id="tbl"></table>
			<script id="temp" type="text/x-handlebars-template">
				<tr class="title">
					<td width=100>강좌번호</td>
					<td width=100>강좌이름</td>
					<td width=80>강의실</td>
					<td width=100>강의시수</td>
					<td width=110>최대수강인원</td>
					<td width=100>수강신청인원</td>
					<td width=80>강좌정보</td>
				</tr>
				{{#each cArray}}
				<tr class="row">
					<td class="lcode">{{lcode}}</td>
					<td class="lname">{{lname}}</td>
					<td class="room">{{room}}</td>
					<td class="hours">{{hours}}</td>
					<td class="capacity">{{capacity}}</td>
					<td class="persons">{{persons}}</td>
					<td><button class="cButton">강좌정보</button></td>
				</tr>
				{{/each}}
 			</script>
 			
 			 <div id="divHeader"><h2>담 당 학 생</h2></div>
         <table id="tbl2"></table>
			<script id="temp2" type="text/x-handlebars-template">
				<tr class="title">
					<td width=100>학생번호</td>
					<td width=100>학생이름</td>
					<td width=80>학과</td>
					<td width=100>학년</td>
					<td width=110>생년월일</td>
					<td width=100>학생정보</td>
				</tr>
				{{#each sArray}}
				<tr class="row">
					<td class="scode">{{scode}}</td>
					<td class="sname">{{sname}}</td>
					<td class="dept">{{dept}}</td>
					<td class="year">{{year}}</td>
					<td class="birthday">{{birthday}}</td>
					<td><button class="sButton">학생정보</button></td>
				</tr>
				{{/each}}
 			</script>
         <!-- 여기에 출력 내용 종료 -->
         </div>
      </div>
      <div id="divBottom"><jsp:include page="../footer.jsp"/></div>
   </div>
</body>
<script>
   var pcode = "${vo.pcode}";
   var pname = "${vo.pname}";
 
   getList();
   
   function getList(){
		$.ajax({
			type:"get",
			url:"/professors/cslist",
			data:{"pcode":pcode},
			dataType:"json",
			success:function(data){
				var template = Handlebars.compile($("#temp").html());
				$("#tbl").html(template(data));	
				
				var template2 = Handlebars.compile($("#temp2").html());
				$("#tbl2").html(template2(data));
			}
		});
	}
   
   $("#tbl").on("click", ".row .cButton", function(){
		var lcode=$(this).parent().parent().find(".lcode").html();
		location.href="/courses/read?lcode="+lcode;
	})
	
	$("#tbl2").on("click", ".row .sButton", function(){
		var scode=$(this).parent().parent().find(".scode").html();
		location.href="/students/read?scode="+scode;
	})
   
   //삭제버튼 클릭
      $("#btnDelete").on("click",function(){
      if(!confirm(pcode + "교수를 삭제하시겠습니까?")) return;
          $.ajax({
             type:"post",
             url:"/professors/delete",
             data:{"pcode":pcode},
             dataType:"json",
             success:function(data){
                if(data.scount==0 && data.ccount==0){
                   alert("삭제되었습니다");
                   location.href="/professors/list.jsp";
                }else{
                   alert("지도학생: " + data.scount + " 담당과목: " + data.ccount + "이 있어 삭제할 수 없습니다.");
                }
             }
          })
      });
   //코드 중복체크
   $(frm).submit(function(e){
      e.preventDefault();
      if(!confirm(pname +"교수 정보를 수정하시겠습니까?")) return;
      frm.submit();
   });
</script>
</html>