<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="../home.css"/>
	<meta charset="UTF-8">
	<title>한빛 미디어</title>
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
</head>
<body>
	<div id = "page">
		<div id = "header"><jsp:include page="../header.jsp"/></div>
		<div id = "center">
			<div id = "menu"><jsp:include page="../menu.jsp"/></div>
			<div id = "content">
			<!-- 여기에 출력할 내용 작성 시작 -->
				<h2>[게시판 글쓰기]</h2>
				<form action="insert" method="post" name="frm">
				<c:if test="${id==null}">
					<input type="hidden" value="guest" name="writer">
				</c:if>
				<c:if test="${id!=null}">
					<input type="hidden" value="${id}" name="writer">
				</c:if>
				
				<input type="hidden" value="guest" name="writer">
				<table width=500 id="tbl">
				<tr>
					<td class = "title">제목</td>
					<td><input type="text" size=60 name="title"></td>
				</tr>
				<tr>
					<td colspan=2>
						<textarea rows="15" cols="70" name="content"></textarea>
					</td>
				</tr>
				</table>
				<input type="submit" value="저장" id="btnInsert">
				<input type="button" value="취소">	
				</form>			
			<!-- 여기에 출력할 내용 작성 종료 -->
			</div>
		</div>
		<div id = "footer"><jsp:include page="../footer.jsp"/></div>
	</div>
</body>
<script>
	$(frm).submit(function(){
		e.preventDefault();
		if(!confirm("저장하시겠습니까?")) return;
		
		var title=$(frm.title).val();
		var content=$(frm.content).val();
		
		if(title==""){
			alert("제목을 입력하세요!");
			$(frm.title).focus();
		}else if(content==""){
			alert("내용을 입력하세요!");
			$(frm.content).focus();
		}else{
			frm.submit();
		}
	})
</script>
</html>