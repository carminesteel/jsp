<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
	<meta charset="UTF-8">
	<title>강의목록</title>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script type="text/x-handlebars-template"></script>
</head>
<body>
	<div><%@include file="../menu.jsp"%></div>
	<h1>[강의목록]</h1>
	<a href = "insert">강의등록</a>
	<table id="tbl" border=1 width=700>
		<tr>
			<td>강의코드</td>
			<td>강의이름</td>
			<td>시수</td>
			<td>강의실</td>
			<td>지도교수</td>
			<td>수강가능인원</td>
			<td>수강인원</td>
		</tr>
		<c:forEach items="${array}" var="vo">
		<tr class = row>
			<td class = lcode>${vo.lcode}</td>
			<td>${vo.lname}</td>
			<td>${vo.hours}</td>
			<td>${vo.room}</td>
			<td>${vo.instructor}</td>
			<td>${vo.capacity}</td>
			<td>${vo.persons}</td>
		</tr>
		</c:forEach>
	</table>
	<div><%@include file="../bottom.jsp" %></div>
</body>
	<!--강좌정보보기-->
	<script>
		$("#tbl").on("click", ".row", function(){
			var lcode=$(this).find(".lcode").html();
			location.href="read?lcode="+lcode;
		})
	</script>
</html>