<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "ex02.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>User 목록</title>
</head>
<body>
	<h1>사용자목록</h1>
	<table border = 1 width = 500px>
		<tr>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>성명</td>	
		</tr>
	<%
		ArrayList<UserVO> list=(ArrayList<UserVO>)request.getAttribute("list");
		for(UserVO vo:list){
			out.print("<tr>");
			out.print("<td>" + vo.getId() + "</td>");
			out.print("<td>" + vo.getPass() + "</td>");
			out.print("<td>" + vo.getUname() + "</td>");
			out.print("</tr>");
		}
	%>	
	</table>
	<a href="insert">회원가입</a>
</body>
</html>