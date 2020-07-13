<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>쇼핑몰</title>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<link rel="stylesheet" href="../home.css" />
</head>
<body>
	<div id="divPage">
		<div id="divMenu"><jsp:include page="../menu.jsp" /></div>
		<div id="divHeader">
			<h2>구 매 목 록</h2>
		</div>
		<div id="divCondition">
			<div id="divSearch">
				<select id="selKey">
					<option value="order_id">주문번호</option>
					<option value="prod_name">구매자명</option>
					<option value="address">주소</option>
					<option value="tel">전화번호</option>
				</select> <input type="text" id="txtWord"> <select id="selPerpage">
					<option value="3">3행</option>
					<option value="5">5행</option>
					<option value="10">10행</option>
				</select> <input type="button" id="btnSearch" value="검색"> <span
					style="font-size: 12px;">검색수: <b id="count"></b>건
				</span>
			</div>
			<div id="divSort">
				<select id="selOrder">
					<option value="order_id">주문일</option>
					<option value="name">구매자명</option>
					<option value="tel">전화번호</option>
				</select> <select id="selDesc">
					<option value="">오름차순</option>
					<option value="desc">내림차순</option>
				</select>
			</div>
		</div>
		<table id="tbl"></table>
		<script id="temp" type="text/x-handlebars-template">
 			<tr class="title">
 				<td width=100>주문번호</td>
 				<td width=100>구매자명</td>
 				<td width=300>주소</td>
 				<td width=150>전화번호</td>
 				<td width=150>구매정보</td>
 			</tr>
 			{{#each array}}
 			<tr class="row">
 				<td class="order_id">{{order_id}}</td>
 				<td class="name">{{name}}</td>
 				<td>{{address}}</td>
				<td>{{tel}}</td>
 				<td><button class="btnRead">구매정보</button></td>
 			</tr>
 			{{/each}}
 		</script>
 		<div id="pagination">
			<button id="btnPre">◀</button>
			<button id="btnNext">▶</button>
			[<span id="curPage"></span>/<span id="totPage"></span>]
		</div>
		<div id="divInfo">
			<table id="tbl1"></table>
			<script id="temp1" type="text/x-handlebars-template">
 			<tr class="row1">
				<td class=td1>이름</td>
 				<td id="name">{{name}}</td>
 				<td class=td1>전화</td>
				<td id="tel">{{tel}}</td>
 				<td class=td1>이메일</td>
 				<td id="email">{{email}}</td>
 				<td class=td1>구매일</td>
				<td id="pdate">{{pdate}}</td>
 			</tr>
			<tr class="row1">
				<td class=td1>주소</td>
 				<td id="address" colspan=3>{{address}}</td>
 				<td class=td1>결제</td>
				<td id="payType">{{payType}}</td>
 				<td class=td1>상태</td>
 				<td id="status">{{status}}</td>
 			</tr>
 		</script>

			<table id="tbl2"></table>
			<script id="temp2" type="text/x-handlebars-template">
 			<tr class="title">
 				<td width=100>상품코드</td>
 				<td width=200>상품명</td>
 				<td width=100>제조사</td>
 				<td width=100>가격</td>
 				<td width=100>수량</td>
				<td width=100>합계</td>
 			</tr>
 			{{#each .}}
 			<tr class="row">
 				<td>{{prod_id}}</td>
 				<td>{{prod_name}}</td>
 				<td>{{company}}</td>
				<td>{{price}}</td>
 				<td>{{quantity}}</td>
				<td>{{sum}}</td>
 			</tr>
 			{{/each}}
 		</script>
		</div>
	</div>
</body>
<script>
	var url = "/shop/purchase/list";

	$("#tbl").on("click", ".row button", function() {
		var order_id = $(this).parent().parent().find(".order_id").html();
		$.ajax({
			type:"get",
			url:"/shop/purchase/read",
			data:{"order_id":order_id},
			dataType:"Json",
			success:function(data){
				var template = Handlebars.compile($("#temp1").html());
				$("#tbl1").html(template(data));
				$.ajax({
					type:"get",
					url:"/shop/order/list",
					data:{"order_id":order_id},
					dataType:"Json",
					success:function(data){
						var template = Handlebars.compile($("#temp2").html());
						$("#tbl2").html(template(data));
					}
				})
			}
		})
	})
</script>
<script src="../home.js"></script>