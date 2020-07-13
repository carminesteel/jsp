<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
	#menu {background:gray; color:white; width:600px; padding:10px; overflow:hidden;}
	#menu a{text-decoration:none; color:white;}
	#menu a:hover{background:black; padding:5px;}
	.item:hover {background:black;padding:5px;}
	.item{float:left; width:100px;}
	.login{float:right;}
	.info{float:right;}
		
</style>
    
<div id="menu">

	<c:if test="${id==null}" >
	<div class = "login"><a href="/login">로그인</a></div>
	<div class = "item"><a href="/login">교수관리</a></div>
	<div class = "item"><a href="/login">학생관리</a></div>
	<div class = "item"><a href="/login">강좌관리</a></div>
	</c:if>
	
	<c:if test="${id!=null}" >	
	<div class = "item"><a href="../pro/list">교수관리</a></div>
	<div class = "item"><a href="../stu/list">학생관리</a></div>
	<div class = "item"><a href="../cou/list">강좌관리</a></div>
	<div class = "logout"><a href="/logout">로그아웃</a></div>
	</c:if>
	
	<div class = "info">${id}:${name}</div>

</div>