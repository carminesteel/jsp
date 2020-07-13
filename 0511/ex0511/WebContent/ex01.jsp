<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>1~100까지의 합</title>
</head>
<body>
<%
	//1~100까지의 합
	int sum = 0;
	for(int i=1; i<=100; i++){
		sum = sum + i;		
	}
	
	int etot = 0;
	for(int i=2; i<=100; i+=2){
		etot=etot+i;
	}
	
	
	int etot2 = 0;
	for(int i=1; i<=100; i+=2){
		etot2=etot2+i;
	}
	
	
%>
	<h1>1~100까지의 합 = <%= sum%></h1>
	<h1>1~100까지의 짝수 합 = <%= etot%></h1>
	<h1>1~100까지의 홀수 합 = <%= etot2%></h1>
</body>
</html>