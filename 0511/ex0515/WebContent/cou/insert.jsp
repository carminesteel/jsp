<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>강의등록</title>
</head>
<body>
<div><%@include file="../menu.jsp"%></div>
	<h1>[강의등록]</h1>
	<form action="insert" method="post" name="frm">
	<table border=1 width=700>
		<tr>
			<td>강의코드</td>
			<td><input type="text" name="lcode" maxlength=4></td>
		</tr>
		<tr>
			<td>강의이름</td>
			<td><input type="text" name="lname"></td>
		</tr>
		<tr>
			<td>시수</td>
			<td>
				<select name="hours">
					<option>1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>강의실</td>
			<td>
				<input type="text" name="room" maxlength=3>
			</td>
		</tr>
		<tr>
			<td>지도교수</td>
			<td>
				<input type="text" name="instructor">
			</td>
		</tr>
		<tr>
			<td>수용인원</td>
			<td>
				<input type="text" name="capacity">
			</td>
		</tr>		
		<tr>
			<td>수강인원</td>
			<td>
				<input type="text" name="persons">
			</td>
		</tr>
		
	</table>
	<input type = "submit" value="저장">
	<input type = "reset" value="취소">
	<input type = "button" value="목록" onClick="location.href='list'">
	</form>
</body>
<script>
	$(frm).submit(function(e)){
		e.preventDefault();
		if(!confirm("저장하시겠습니까?")) return;

			frm.submit();
		}
	});
</script>
</html>