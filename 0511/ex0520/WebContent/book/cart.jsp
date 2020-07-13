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
				<h2>[장바구니]</h2>
				<table id="carTbl" width=700>
				<tr>
					<td width=100>코드</td>
					<td width=300>제목</td>
					<td width=100>단가</td>
					<td width=100>수량</td>
					<td width=100>금액</td>
				</tr>
				<c:forEach items="${listCart}" var="vo">
				<tr class=row>
					<td class=code>${vo.code}</td>
					<td class=title>${vo.title}</td>
					<td class=price><fmt:formatNumber value="${vo.price}" pattern="#,###원"/></td>
					<td><input class=number type="text" size="2px" value="<fmt:formatNumber value="${vo.number}" pattern="#,###"/>"><button class=btnUpdate>수정</button></td>
					<td class=sum><fmt:formatNumber value="${vo.price*vo.number}" pattern="#,###원"/></td>
				</tr>
				</c:forEach>
				</table>
			<!-- 여기에 출력할 내용 작성 종료 -->
			</div>
		</div>
		<div id = "footer"><jsp:include page="../footer.jsp"/></div>
	</div>
</body>
<script>
	$("#carTbl").on("click", ".row button", function(){
		var row=$(this).parent().parent();
		var code=row.find(".code").html();
		var number=row.find(".number").val();
		alert(code)
		alert(number)
		if(!confirm(code + "을(를) " + number + "개로 수정하시겠습니까?")) return;
		$.ajax({
			type:"post",
			url:"/book/cartUpdate",
			data:{"code":code,"number":number},
			success:function(){
				alert("수정되었습니다.")
				location.href="/book/cart"
			}
		});		
	});
</script>
</html>