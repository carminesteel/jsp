<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.io.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>파일읽기</title>
</head>
<body>
<%
	BufferedReader reader = null;
	try{
		String filePath=application.getRealPath("/WEB-INF/lib/input.txt");
		reader = new BufferedReader(new FileReader(filePath));
	
		while(true){
			String str=reader.readLine();
			if(str==null){
				break;
			}
			out.println("<h1>" + str + "</h1>" + "<br>");
		}
		reader.close();
	}catch(Exception e){out.println(e.toString());}
%>
</body>
</html>