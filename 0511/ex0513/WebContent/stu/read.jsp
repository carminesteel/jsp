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
	<title>학생정보</title>
</head>
<body>
	<h1>[학생정보]</h1>
	<form action="update" method="post" name="frm">
	<table border=1 width=700>
		<tr>
			<td>학생번호</td>
			<td><input type="text" name="scode" maxlength=8 value="${vo.scode}" readonly></td>
		</tr>
		<tr>
			<td>학생이름</td>
			<td><input type="text" name="sname" value="${vo.sname}"></td>
		</tr>
		<tr>
			<td>학생학과</td>
			<td>
				<select name="dept">
					<option <c:out value="${vo.dept.equals('전산')?'selected':''}"/>>전산</option>
					<option <c:out value="${vo.dept.equals('전자')?'selected':''}"/>>전자</option>
					<option <c:out value="${vo.dept.equals('건축')?'selected':''}"/>>건축</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>학년</td>
			<td>
				<input type="radio" <c:out value="${vo.year==(1)?'checked':''}"/>>1학년
				<input type="radio" <c:out value="${vo.year==(2)?'checked':''}"/>>2학년
				<input type="radio" <c:out value="${vo.year==(3)?'checked':''}"/>>3학년
				<input type="radio" <c:out value="${vo.year==(4)?'checked':''}"/>>4학년
			</td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td><input type="text" name="birthday" value="${vo.birthday}"></td>
		</tr>
		<tr>
			<td>지도교수:</td>
			<td>
				<select name="advisor">
					<c:forEach items="${plist}" var="v">
						<option value="${v.pcode}" <c:out value="${vo.advisor==v.pcode?'selected':''}"/>>${v.pname}</option>
					</c:forEach>
				</select>
			</td>
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
		}
	} );

	$("#btnDel").on("click", function(){
		if(!confirm("삭제하시겠습니까")) return;
		frm.action="delete";
		frm.method="post";
		frm.submit();
	})
</script>
</html>