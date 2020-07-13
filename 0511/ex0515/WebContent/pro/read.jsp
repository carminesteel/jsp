<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script type="text/x-handlebars-template"></script>
	<meta charset="UTF-8">
	<title>교수 정보</title>
</head>
<body>
<div><%@include file="../menu.jsp"%></div>
	<h1>교수 정보</h1>
	<form name="frm" action = "update" method="post" >
	<table border=1>
		<tr>
			<td>교수번호:</td>
			<td><input type="text" name="pcode" maxlength=3 value="${vo.pcode}" readonly></td>			
		</tr>
		<tr>
			<td>교수이름:</td>
			<td><input type="text" name="pname" value="${vo.pname}"></td>
		</tr>
		<tr>
			<td>교수학과:</td>
			<td>
				<select name="dept" value="${vo.dept}">
					<option <c:out value="${vo.dept.equals('전산')?'selected':''}"/>>전산</option>
					<option <c:out value="${vo.dept.equals('전자')?'selected':''}"/>>전자
					<option <c:out value="${vo.dept.equals('건축')?'selected':''}"/>>건축</option>			
				</select>
			</td>
		</tr>
		<tr>
			<td>교수직급:</td>
			<td>
				<input type="radio" name="title" value="정교수" <c:out value="${vo.title.equals('정교수')?'checked':''}"/>>정교수
				<input type="radio" name="title" value="부교수" <c:out value="${vo.title.equals('부교수')?'checked':''}"/>>부교수
				<input type="radio" name="title" value="조교수" <c:out value="${vo.title.equals('조교수')?'checked':''}"/>>조교수
			</td>
		</tr>
		<tr>
			<td>임용일:</td>
			<td><input type="date" name="hiredate" value="${vo.hiredate}"></td>
		</tr>
		<tr>
			<td>급여:</td>
			<td><input type="number" name="salary" value="${vo.salary}"></td>
		</tr>
	</table>
	<input type = "submit" value= "수정">
	<input type = "button" value="삭제" id=btnDelete>
	<input type = "reset" value= "취소">
	<input type = "button" value="목록" onClick="location.href='list'">
	</form>
</body>
<script>
	$(frm).submit(function(e){
		e.preventDefault();
		if(!confirm("수정하시겠습니까"))return;
		
		var pcode=$(frm.pcode).val();
		var salary=$(frm.salary).val();
		var pname=$(frm.pname).val();
		
		if(salary==""){
			alert("급여를 입력하세요!");
			$(frm.salary).focus();
		}else if(pname==""){
			alert("이름을 입력하세요");
			$(frm.pname).focus();
		}
		else{
			frm.submit();
		}
	})
	
	$("#btnDelete").on("click", function(){
		var pcode=${vo.pcode};
		if(!confirm(pcode+"을(를) 삭제하시겠습니까?")) return;
		location.href='delete?pcode='+pcode;
	})
</script>
</html>