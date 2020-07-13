<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script type="text/x-handlebars-template"></script>
	<meta charset="UTF-8">
	<title>강의정보</title>
</head>
<body>
	<h1>[강의정보]</h1>
	<form action="update" method="post" name="frm">
	<table border=1 width=700>
		<tr>
			<td>강의번호</td>
			<td><input type="text" name="lcode" value="${vo.lcode}" readonly></td>
		</tr>
		<tr>
			<td>강의이름</td>
			<td><input type="text" name="lname" value="${vo.lname}"></td>
		</tr>
		<tr>
			<td>시수</td>
			<td><input type="text" name="hours" value="${vo.hours}"></td>
		</tr>
		<tr>
			<td>강의실</td>
			<td><input type="text" name="room" value="${vo.room}"></td>
		</tr>
		<tr>
			<td>지도교수</td>
			<td><input type="text" name="instructor" value="${vo.instructor}"></td>
		</tr>
		<tr>
			<td>수용인원</td>
			<td><input type="text" name="capacity" value="${vo.capacity}"></td>
		</tr>
		<tr>
			<td>수강목록</td>
			<td><input type="text" name="persons" value="${vo.persons}"></td>
		</tr>
	</table>
	<input type = "submit" value="수정">
	<input type = "button" value="삭제" id="btnDel">
	<input type = "reset" value="취소">
	<input type = "button" value="목록" onClick="location.href='list'">
	</form>
</body>

<script>
	$(frm).submit(function(e){
		e.preventDefault();
		if(!confirm("저장하시겠습니까?")) return;
			frm.submit();
		});
	 

	$("#btnDel").on("click", function(){
		var lcode="${vo.lcode}";
		alert(lcode);
		if(!confirm(lcode+"을(를) 삭제하시겠습니까?")) return;		
		location.href="delete?lcode="+lcode;
	})
</script>
</html>