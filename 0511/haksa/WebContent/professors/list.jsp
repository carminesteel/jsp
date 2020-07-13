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
			<div id="divHeader"><h2>교 수 목 록</h2></div>
			<div id="divCondition">
				<div id="divSearch">
					<select id="selKey">
						<option value="pcode">교수번호</option>
						<option value="pname">교수이름</option>
						<option value="dept">교수학과</option>
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
						<option value="pcode">번호</option>
						<option value="pname">이름</option>
						<option value="dept">학과</option>
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
					<td width=100>교수번호</td>
					<td width=100>교수이름</td>
					<td width=80>교수학과</td>
					<td width=100>교수직급</td>
					<td width=110>임용일자</td>
					<td width=100>급여</td>
					<td width=80>정보조회</td>
				</tr>
				{{#each array}}
				<tr class="row">
					<td class="pcode">{{pcode}}</td>
					<td class="pname">{{pname}}</td>
					<td class="dept">{{dept}}</td>
					<td class="ptitle">{{title}}</td>
					<td class="hiredate">{{hiredate}}</td>
					<td class="salary">{{salary}}</td>
					<td class=""><button>정보조회</button></td>
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
	var url="/professors/list";
	
	$("#tbl").on("click",".row button", function(){
		var pcode=$(this).parent().parent().find(".pcode").html();
		location.href="/professors/read?pcode="+pcode;
	});
</script>
<script src="../home.js"></script>
</html>