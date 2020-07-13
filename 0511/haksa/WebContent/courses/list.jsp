<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel ="stylesheet" href="../home.css">
	<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
	<title>학사관리 시스템</title>
</head>
<body>
	<div id="divPage">
		<div id="divTop"><jsp:include page="../header.jsp"/></div>
	<div id="divCenter">
		<div id="divMenu"><jsp:include page="../menu.jsp"/></div>
		<div id="divContent">
			<!-- 여기에 내용 등록 시작-->
			<div id="divHeader"><h2>강 의 목 록</h2></div>
			<div id="divCondition">
				<div id="divSearch">
					<select id="selKey">
						<option value="lcode">강의번호</option>
						<option value="pname">교수이름</option>
						<option value="lname">강의명</option>
					</select>
					<input type="text" id="txtWord">
					<select id="selperpage">
						<option value="3">3행</option>
						<option value="5">5행</option>
						<option value="10">10행</option>
					</select>
					<input type="button" id="btnSearch" value="검색">
					<span style="font-size:12px;">검색수: <b id="count"></b>건</span>
				</div>
				<div id="divSort">
					<select id="selOrder">
						<option value="lcode">강의번호</option>
						<option value="pname">교수이름</option>
						<option value="lname">강의명</option>
					</select>
					<select id="selDesc">
						<option value="">오름차순</option>
						<option value="desc">내림차순</option>
					</select>
				</div>
			</div>
			<table id="tbl"></table>
			<script id="temp" type="text/x-handlebars-template">
				<tr class="title">
					<td width=130>강의번호</td>
					<td width=130>강의이름</td>
					<td width=130>교수이름</td>
					<td width=130>수강인원</td>
					<td width=60>강의실</td>
					<td width=70>강좌정보</td>
				</tr>
				{{#each array}}
				<tr class="row">
					<td class="lcode">{{lcode}}</td>
					<td class="lname">{{lname}}</td>
					<td class="pname">{{pname}}</td>
					<td class="persons">{{persons}}</td>
					<td class="room">{{room}}</td>
					<td><button>강좌정보</button></td>
				</tr>
				{{/each}}
 			</script>
 			<div id="pagination">
 				<button id="btnPre">◀</button> <button id="btnNext">▶</button>
				[<span id="curPage"></span>/<span id="totPage"></span>]
 			</div>
			<!-- 여기에 내용 등록 종료-->
		</div>
	</div>
	<div id="divBottom"><jsp:include page="../footer.jsp"/></div>
	</div>
</body>
<script>
	var url="/courses/list";
	$("#tbl").on("click", ".row button", function(){
		var lcode=$(this).parent().parent().find(".lcode").html();
		alert(lcode);
		location.href="read?lcode="+lcode;
	})	
</script>
<script src="../home.js"></script>
</html>