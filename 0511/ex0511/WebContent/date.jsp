<%@page import="java.util.GregorianCalendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*, java.text.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>

	<%
		//GregorianCalendar now = new GregorianCalendar();		
		//String date = String.format("%TF", now);
		//String time = String.format("%TT", now);
		
		Date now = new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy/MM/dd");
		String date = sdf.format(now);
		
		SimpleDateFormat sdf1= new SimpleDateFormat("hh시mm분ss초");
		String time = sdf1.format(now);
	
		double num=0.513;
		DecimalFormat df = new DecimalFormat("#.###");
		String strNum=df.format(num);
	%>
	
		<h1>오늘의 날짜:<%=date %></h1>
		<h1>오늘의 시간:<%=time %></h1>
		<h1>num:<%=strNum %></h1>
		
</body>
</html>