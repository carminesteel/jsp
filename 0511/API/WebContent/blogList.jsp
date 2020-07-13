<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="user-scalable=no, width=device-width"
	charset="euc-kr" />
<link href="home_mobile.css" rel="stylesheet" type="text/css"
	media="screen and (max-width:799px)">
<link href="homeForblog.css" rel="stylesheet" type="text/css"
	media="screen and (min-width:800px)">
<meta charset="UTF-8">
<title>BLOG 검색</title>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
</head>
<body>
	<div id="divPage">
		<div id="divMenu"><jsp:include page="/menu.jsp" /></div>
		<div id="divHeader">
			<h2>BLOG검색</h2>
		</div>
		<div id="divCondition">

			<input type="text" id="query" value="자바"> <input
				type="button" value="검색" id="btnSearch"> <select
				id="display">
				<option value=5>5행 출력</option>
				<option value=10>10행 출력</option>
			</select> 검색건수 : <span id=total></span>
		</div>
		<table id="tbl"></table>
		<script id="temp" type="text/x-handlebars-template">
		<tr>
			<td class="tdTitle1" width=270px>제목</td>
			<td class="tdTitle1" width=370px>내용</td>
		</tr>	
	{{#each items}}
		<tr class="row">
			<td class="tdTitle" style = "cursor:pointer;" onClick = " location.href='{{{link}}}' 
						" onMouseOver = " window.status ='{{{link}}}' 
						" onMouseOut = " window.status = '' ">{{{title}}}</td>
			<td>{{{description}}}</td>
		</tr>
	{{/each}}
	</script>
		<div id="pagination">
			<button id="btnPre">◀</button>
			<button id="btnNext">▶</button>
			[<span id="curPage"></span>/<span id="totPage"></span>]
		</div>
	</div>
</body>
<script>
	var url="/API/naver/blog";
</script>
<script src="home.js"></script>
</html>