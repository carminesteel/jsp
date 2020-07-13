<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="user-scalable=no, width=device-width"
	charset="euc-kr" />
<link href="home_mobile.css" rel="stylesheet" type="text/css"
	media="screen and (max-width:799px)">
<link href="home.css" rel="stylesheet" type="text/css"
	media="screen and (min-width:800px)">
<meta charset="UTF-8">
<title>도서검색</title>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<style>
	.box{width:200px; float:left;}
</style>
</head>
<body>
	<div id="divPage">
		<div id="divMenu"><jsp:include page="/menu.jsp" /></div>
		<div id="divHeader">
			<h2>도서검색</h2>
		</div>
		<div id="divCondition">

			<input type="text" id="query" value="자바"> <input
				type="button" value="검색" id="btnSearch"> <select
				id="display">
				<option value=4>4개 출력</option>
				<option value=8>8개 출력</option>
				<option value=12>12개 출력</option>
			</select> 검색건수 : <span id=total></span>
		</div>
		<div id="tbl"></div>
		<script id="temp" type="text/x-handlebars-template">
	{{#each items}}
			<div class=box><a href="{{link}}"><img src={{{image}}} width=150,height=204.88></div>
	{{/each}}
	</script>
	
		<span id="pagination">
			<button id="btnPre">◀</button>
			<button id="btnNext">▶</button>
			[<span id="curPage"></span>/<span id="totPage"></span>]
		</span>
	</div>
</body>
<script>
	var url = "/API/naver/book";
</script>
<script src="home.js"></script>
</html>