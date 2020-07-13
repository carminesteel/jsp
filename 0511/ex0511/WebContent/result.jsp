<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String uname = request.getParameter("uname"); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>가입완료</title>
</head>
<body>
	<h1><%= request.getParameter("uname") %> 회원가입 완료</h1>
</body>
</html>