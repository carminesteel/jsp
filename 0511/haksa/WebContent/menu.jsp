<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="menuItem"><a href="/index.jsp">Home</a></div>

<div>
	<c:if test="${id!=null}">
		<div class="menuItem"><a href="/professors/list.jsp">교수목록</a></div>
		<div class="menuItem"><a href="/professors/insert.jsp">교수등록</a></div>
		<div class="menuItem"><a href="/students/list.jsp">학생목록</a></div>
		<div class="menuItem"><a href="/students/insert.jsp">학생등록</a></div>
		<div class="menuItem"><a href="/courses/list.jsp">강좌목록</a></div>
		<div class="menuItem"><a href="/courses/insert.jsp">강좌등록</a></div>
			<span style="font-size:12px">안녕하세요! ${name}님</span>
			<a href="/user/logout">로그아웃</a>
	</c:if>
	<c:if test="${id==null}">
		<div class="menuItem"><a href="/user/login.jsp">교수목록</a></div>
		<div class="menuItem"><a href="/user/login.jsp">교수등록</a></div>
		<div class="menuItem"><a href="/user/login.jsp">학생목록</a></div>
		<div class="menuItem"><a href="/user/login.jsp">학생등록</a></div>
		<div class="menuItem"><a href="/user/login.jsp">강좌목록</a></div>
		<div class="menuItem"><a href="/user/login.jsp">강좌등록</a></div>
		<div class="menulogin" style=float:right;margin-right:20px;>
			<a href="/user/login.jsp">로그인</a>
	</c:if>
</div>