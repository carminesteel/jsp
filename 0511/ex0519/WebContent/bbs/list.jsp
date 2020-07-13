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
				<h2>[게시판목록]</h2>
				<div id="search">
					<form name="frm">
						<select name="key">
							<option value="title" <c:out value="${key=='title'?'selected':''}"/>>제목</option>
							<option value="wdate" <c:out value="${key=='wdate'?'selected':''}"/>>날짜</option>
							<option value="writer" <c:out value="${key=='writer'?'selected':''}"/>>작성자</option>
						</select>
						<input type="text" name="word" value="${word}">
						<input type="submit" value="검색" id="btnSearch">
						검색수:"${count}"
						<input type="text" value="${page}" name="page" hidden>
					</form>
				</div>
				<table id = "tbl" width=700>
				<tr class="title">
					<td>No.</td>
					<td>title</td>
					<td>content</td>
					<td>writer</td>
					<td>wdate</td>
				</tr>
				<c:forEach items="${list}" var="vo">
				<tr class="row">	
					<td>${vo.seqno}</td>
					<td class="center">${vo.title}</td>
					<td>${vo.content}</td>
					<td class="center">${vo.writer}</td>
					<td class="wdate">${vo.wdate}</td>
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