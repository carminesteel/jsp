<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script type="text/x-handlebars-template"></script>
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
			<td>교수이름</td>
			<td>학과</td>
			<td>직급</td>
			<td>급여</td>
			<td>임용일</td>
			<td>삭제</td>
		</tr>
		<c:forEach items="${list}" var="vo">
		<tr class = row>
			<td class = pcode>${vo.pcode}</td>
			<td>${vo.pname}</td>
			<td>${vo.dept}</td>
			<td>${vo.title}</td>
			<td><fmt:formatNumber value="${vo.salary}" pattern="#,###"/></td>
			<td><fmt:formatDate value="${vo.hiredate}" pattern="yyyy년MM월dd일"/></td>
			<td><button>삭제</button></td>		
		</tr>
		</c:forEach>
	</table>	
	<div><%@include file="../bottom.jsp" %></div>
</body>
<script>
	$("#tbl").on("click",".row button", function(){
		var row = $(this).parent().parent();
		var pcode = row.find(".pcode").html();
		if(!confirm(pcode + "을(를) 삭제하시겠습니까?")) return;
		location.href="delete?pcode="+pcode;
	})
	
	//수정화면 이동
	$("#tbl").on("click", ".row", function(){
		var pcode=$(this).find(".pcode").html();
		location.href="read?pcode="+pcode;
	})
</script>