<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
	<meta charset="UTF-8">
	<title>학생목록</title>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script type="text/x-handlebars-template"></script>
</head>
<body>
	<div><%@include file="../menu.jsp"%></div>
	<h1>[학생목록]</h1>
	<a href = "insert">학생등록</a>
	<table id="tbl" border=1 width=700>
		<tr>
			<td>학생번호</td>
			<td>학생이름</td>
			<td>학생학과</td>
			<td>학생학년</td>
			<td>학생생일</td>
			<td>지도교수</td>
		</tr>
		<c:forEach items="${list}" var="vo">
		<tr class = row>
			<td class = scode>${vo.scode}</td>
			<td>${vo.sname}</td>
			<td>${vo.dept}</td>
			<td>${vo.year}</td>
			<td>${vo.birthday}</td>
			<td>${vo.pname}</td>
		</tr>
		</c:forEach>
	</table>
	<div><%@include file="../bottom.jsp" %></div>
</body>
	<!--학생정보보기-->
	<script>
		$("#tbl").on("click", ".row", function(){
			var scode=$(this).find(".scode").html();
			location.href="read?scode="+scode;
		})
	</script>
</html>