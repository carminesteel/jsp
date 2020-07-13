<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script> 
	<meta charset="UTF-8">
	<title>교수</title>
</head>
<body>
	<div><%@include file="../menu.jsp"%></div>
	<h1>[교수 목록]</h1>
	<a href = "insert">교수등록</a>
	<table border=1 width=500 id="tbl">
		<tr>
			<td>교수번호</td>
			<td >교수이름</td>
			<td>학과</td>
			<td>직급</td>
			<td>급여</td>
			<td>임용일</td>
			<td>삭제</td>
			<td>담당과목</td>
		</tr>
		<c:forEach items="${list}" var="vo">
		<tr class = row>
			<td class = pcode>${vo.pcode}</td>
			<td class=pname>${vo.pname}</td>
			<td>${vo.dept}</td>
			<td>${vo.title}</td>
			<td><fmt:formatNumber value="${vo.salary}" pattern="#,###"/></td>
			<td><fmt:formatDate value="${vo.hiredate}" pattern="yyyy년MM월dd일"/></td>
			<td><button class=btnDelete>삭제</button></td>	
			<td><button class=subject>담당과목</button></td>	
		</tr>
		</c:forEach>
		
		<div id="enroll">
		<h1>[수강신청]</h1>
		<div id="apply">
			<table id = tbl1 border=1 width=700></table>
		<script id="temp" type="text/x-handlebars-template">
				<tr class=row>
					<td class=scode>학번</td>
					<td>이름</td>
					<td>성적</td>
					<td>수강신청일</td>
				</tr>
			{{#each .}}
				<tr class=row>
					<td class=scode>{{scode}}</td>
					<td>{{sname}}</td>
					<td>{{grade}}</td>
					<td>{{edate}}</td>					
				</tr>
			{{/each}}
		</script>			
		</div>
	</div>
	</table>	
	<div><%@include file="../bottom.jsp" %></div>
</body>
<script>
	$("#enroll").hide();

	$("#tbl").on("click",".row .btnDelete", function(){
		var row = $(this).parent().parent();
		var pcode = row.find(".pcode").html();
		if(!confirm(pname + "을(를) 삭제하시겠습니까?")) return;
		location.href="delete?pcode="+pcode;
	})
	
	$("#tbl").on("click",".row .subject", function(){
		var row = $(this).parent().parent();
		var pcode = row.find(".pcode").html();
		alert(pcode)
		function getList(){
		   $.ajax({
			      type:"get",
			      url:"/cou/enroll",
			      data:{"pcode":pcode},
			      dataType:"json",
			      success:function(data){
			         var temp=Handlebars.compile($("#temp").html());
			         $("#tbl1").html(temp(data));
			         $("#enroll").show();
			      }
			})
			}
	})
	
	//수정화면 이동
	$("#tbl").on("click", ".row .pname", function(){
		var row=$(this).parent();
		var pcode=row.find(".pcode").html();
		alert(pcode)
		location.href="read?pcode="+pcode;
	})
</script>