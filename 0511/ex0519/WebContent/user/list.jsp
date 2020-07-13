<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
	<link rel="stylesheet" href="../home.css"/>
	<meta charset="UTF-8">
	<title>한빛 미디어</title>
</head>
<body>
	<div id = "page">
		<div id = "header"><jsp:include page="../header.jsp"/></div>
		<div id = "center">
			<div id = "menu"><jsp:include page="../menu.jsp"/></div>
			<div id = "content">
			<!-- 여기에 출력할 내용 작성 시작 -->
				<h2>[회원목록]</h2>
				<div id="search">
					<form name="frm">
						<select name="key">
							<option value="name" <c:out value="${key=='name'?'selected':''}"/>>이름</option>
							<option value="id" <c:out value="${key=='id'?'selected':''}"/>>아이디</option>
							<option value="tel" <c:out value="${key=='tel'?'selected':''}"/>>전화번호</option>
						</select>
						<input type="text" name="word" value="${word}">
						<input type="submit" value="검색" id="btnSearch">
						검색수:"${count}"
						<input type="text" value="${page}" name="page" hidden>
					</form>
				</div>
				<table id = "tbl" width=700>
				<tr class="title">
					<td>name</td>
					<td>id</td>
					<td>job</td>
					<td>tel</td>
				</tr>
				<c:forEach items="${list}" var="vo">
				<tr class="row">	
					<td>${vo.name}</td>
					<td class="center">${vo.id}</td>
					<td>${vo.job}</td>
					<td class="center">${vo.tel}</td>
				</tr>
				</c:forEach>
				</table>
				<div id="pagination">
					<button id="btnPre">◀</button>
					<button id="btnNext">▶</button>
					[${page}/${totPage}]
				</div>				
			<!-- 여기에 출력할 내용 작성 종료 -->
			</div>
		</div>
		<div id = "footer"><jsp:include page="../footer.jsp"/></div>
	</div>
</body>
<script>
	var totPage="${totPage}";
	var count="${count}";
	var page="${page}";
	if(count==0){
		$("#pagination").hide();
	}
	$("#btnSearch").on("click", function(){
		$(frm.page).val(1);
		$(frm).submit();
	})
	
	$("#btnPre").on("click", function(){
		if(page==1){
			alert("첫페이지")
		}else{
			page--;
			$(frm.page).val(page);
			$(frm).submit();
		}
	});
	
	$("#btnNext").on("click", function(){
		if(page==totPage){
			alert("마지막 페이지")		
		}else{
			page++;
			$(frm.page).val(page);
			$(frm).submit();			
		}		
	});
</script>	
</html>