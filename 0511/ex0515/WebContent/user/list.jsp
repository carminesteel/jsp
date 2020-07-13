<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "user.*, java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script type="text/x-handlebars-template"></script>
	<meta charset="UTF-8">
	<title>사용자 목록</title>
</head>
<body>
	<h1>[사용자 목록]</h1>
	<a href = "insert">사용자등록</a>
	<table border=1 width=500 id="tbl">
		<tr>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>성명</td>
			<td>삭제</td>
			<td>삭제</td>
		</tr>
		<c:forEach items="${list}" var="vo">
		<tr class = row>
			<td class = id>${vo.id}</td>
			<td>${vo.pass}</td>
			<td><input type=text class="uname" value="${vo.uname}"></td>
			<td><button class=del>삭제</button>
			<td><button class=update>수정</button>			
		</tr>
		</c:forEach>
	</table>	
	<div><%@include file="../bottom.jsp" %></div>
</body>
<script>

	$("#tbl").on("click", ".del", function(){
		var row=$(this).parent().parent();
		var id=row.find(".id").html();
		if(!confirm(id + "을(를) 삭제하시겠습니까?")) return;
		location.href="delete?id="+id;		
	})
	
	$("#tbl").on("click", ".update", function(){
		var row=$(this).parent().parent();
		var id=row.find(".id").html();
		var uname=row.find(".uname").val();
		if(!confirm(uname + "으로 수정하시겠습니까?")) return;
		location.href="update?id="+id+"&uname="+uname;		
	})
	
</script>
</html>