<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script type="text/x-handlebars-template"></script>
	<meta charset="UTF-8">
	<title>교수 등록</title>
</head>
<body>
<div><%@include file="../menu.jsp"%></div>
	<h1>[교수 등록]</h1>
	<form name="frm" action = "insert" method="post" >
	<table border=1>
		<tr>
			<td>교수번호:</td>
			<td><input type="text" name="pcode" maxlength=3></td>			
		</tr>
		<tr>
			<td>교수이름:</td>
			<td><input type="text" name="pname"></td>
		</tr>
		<tr>
			<td>교수학과:</td>
			<td>
				<select name="dept">
					<option>전산</option>
					<option>전자</option>
					<option selected>건축</option>			
				</select>
			</td>
		</tr>
		<tr>
			<td>교수직급:</td>
			<td>
				<input type="radio" name="title" value = "정교수">정교수
				<input type="radio" name="title" value = "부교수">부교수
				<input type="radio" name="title" value = "조교수" checked>조교수
			</td>
		</tr>
		<tr>
			<td>임용일:</td>
			<td><input type="date" name="hiredate"></td>
		</tr>
		<tr>
			<td>급여:</td>
			<td><input type="number" name="salary"></td>
		</tr>
	</table>
	<input type = "submit" value= "저장">
	<input type = "reset" value= "취소">
	<input type = "button" value="목록" onClick="location.href='list'">
	</form>
</body>
<script>
	$(frm).submit(function(e){
		e.preventDefault();
		if(!confirm("저장하시겠습니까"))return;
		
		var pcode=$(frm.pcode).val();
		var salary=$(frm.salary).val();
		var pname=$(frm.pname).val();
		
		if(pcode.length!=3){
			alert("교수코드를 다시입력하세요!");
			$(frm.pcode).focus();
		}else if(salary==""){
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
</script>
</html>