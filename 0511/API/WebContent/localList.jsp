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
<title>장소검색</title>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=550c2430589d8623c802155ee1472416"></script>
</head>
<body>
	<div id="divPage">
		<div id="divMenu"><jsp:include page="/menu.jsp" /></div>
		<div id="divHeader">
			<h2>장소검색</h2>
		</div>
		<div id="divCondition">

			<input type="text" id="query" value="자바"> <input
				type="button" value="검색" id="btnSearch"> <select id="size">
				<option value=5>5행 출력</option>
				<option value=10>10행 출력</option>
			</select> 검색건수 : <span id=total></span>
		</div>
		<table id="tbl"></table>
		<script id="temp" type="text/x-handlebars-template">
		<tr>
			<td class="tdTitle1" width=180px>장소이름</td>
			<td class="tdTitle1" width=270px>주소</td>
			<td class="tdTitle1" width=150px>전화번호</td>
		</tr>	
	{{#each documents}}
		<tr class="row">
			<td class="tdTitle">{{{place_name}}}</td>
			<td>{{{address_name}}}<input type="hidden" class="x" value={{x}}><input type="hidden" class="y" value={{y}}></td>
			<td>{{{phone}}}</td>
		</tr>
	{{/each}}
	</script>
		<div id="pagination">
			<button id="btnPre">◀</button>
			<button id="btnNext">▶</button>
			[<span id="curPage"></span>/<span id="totPage"></span>]
		</div>
		<div id="map"
			style="width: 750px; height: 400px; margin: auto; margin-top: 15px;"></div>
	</div>
</body>
<script>
	var page = 1, size, query, total, x, y, name;

	getList();

	$("#tbl").on("click", ".row", function() {
		x = $(this).find(".x").val();
		y = $(this).find(".y").val();
		name = $(this).find(".tdTitle").html();
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		mapOption = {
			center : new kakao.maps.LatLng(y, x), // 지도의 중심좌표
			level : 3
		// 지도의 확대 레벨
		};

		var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

		// 마커가 표시될 위치입니다 
		var markerPosition = new kakao.maps.LatLng(y, x);

		// 마커를 생성합니다
		var marker = new kakao.maps.Marker({
			position : markerPosition
		});

		// 마커가 지도 위에 표시되도록 설정합니다
		marker.setMap(map);
	});

	$("#btnSearch").on("click", function() {
		page = 1;
		getList();
	});

	$("#display, #query").on("change", function() {
		page = 1;
		getList();
	})

	$("#btnNext").click(function() {
		page++;
		getList();
	});

	$("#btnPre").click(function() {
		page--;
		getList();
	});

	function getList() {
		query = $("#query").val();
		size = $("#size").val();
		$.ajax({
			type : "get",
			url : "https://dapi.kakao.com/v2/local/search/keyword.json",
			headers : {
				"Authorization" : "KakaoAK 550c2430589d8623c802155ee1472416"
			},
			dataType : "json",
			data : {
				"query" : query,
				"page" : page,
				"size" : size
			},
			success : function(data) {
				var template = Handlebars.compile($("#temp").html());
				$("#tbl").html(template(data));

				total = data.meta.pageable_count;
				if (total % size == 0) {
					totPage = total / size;
				} else {
					totPage = parseInt(total / size) + 1;
				}

				if (page == 1) {
					$("#btnPre").attr("disabled", true);
				} else {
					$("#btnPre").attr("disabled", false);
				}

				if (page == totPage) {
					$("#btnNext").attr("disabled", true);
				} else {
					$("#btnNext").attr("disabled", false);
				}

				$("#curPage").html(page);
				$("#totPage").html(totPage);
				$("#total").html(total);

			}
		})
	}
</script>

</html>