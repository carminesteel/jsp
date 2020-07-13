<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>저장완료...</h1>
	<h1>작성자:<%=request.getAttribute("n") %></h1>
	<h1>제목:<%=request.getAttribute("t") %></h1>
	<h1>내용:<%=request.getAttribute("c") %></h1>
</body>
</html>