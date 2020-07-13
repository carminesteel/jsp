<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel ="stylesheet" href="../home.css">
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
	<title>학사관리 시스템</title>
	
</head>
<body>
	<div id="divPage">
		<div id="divTop"><jsp:include page="../header.jsp"/></div>
	<div id="divCenter">
		<div id="divMenu"><jsp:include page="../menu.jsp"/></div>
		<div id="divContent">
			<!-- 여기에 내용 등록 시작--------------------------------------------->
			<div id="divHeader"><h2>강 좌 등 록</h2></div>
			<form name="frm" action="update" method="post">
				 <table>
					 <tr>
						 <td class="title">강좌번호</td><td><input type="text" size=10 name="lcode" value="${vo.lcode}" readonly></td>
						 <td class="title" width=150>강의실</td><td><input type="text" size=5 name="room" value="${vo.room}"></td>
						 <td class="title" width=150>강의시수</td><td><input type="text" size=5 name="hours" value="${vo.hours}"></td>
					 </tr>
					 <tr>
						 <td class="title">강좌이름</td><td colspan=3><input type="text" size=60 name="lname" readonly value="${vo.lname}"></td>
						 <td class="title">최대수강인원</td><td><input type="text" size=5 name="capacity" value="${vo.capacity}"></td>
					 </tr>
					 <tr>
						 <td width=90 class="title">담당교수</td>
						 <td width=400 colspan=3>
							 <input type="text" size=5 name="pcode" value="${vo.instructor}">
							 <input type="text" size=10 name="pname" value="${vo.pname}">
						 </td>
					 	<td class="title">수강신청인원</td><td><input type="text" size=5 name="persons" value="${vo.persons}"></td>
					 </tr>
				 </table>
				 <div id="pagination">
					 <input type="submit" value="수정" id="btnInsert">
					 <input type="button" value="삭제" id="btnDelete">
					 <input type="reset" value="취소">
				 </div>
			</form>
			<div id="divHeader"><h2>성 적 입 력</h2></div>
			<div>
 				<button id=btnUpdate style= "margin-left:91px;margin-bottom:10px;">선택저장</button>
 			</div>
			<table id="tbl"></table>
			<script id="temp" type="text/x-handlebars-template">
				<tr class="title">
					<td width=20><input type = "checkbox" id="chkAll"></td>
					<td width=100>학번</td>
					<td width=100>학생이름</td>
					<td width=100>학과</td>
					<td width=100>학년</td>
					<td width=150>수강일</td>
					<td width=100>점수</td>
				</tr>
				{{#each array}}
				<tr class="row">
					<td class="lcode"><input type = "checkbox" class="chk"></td>
					<td class="scode">{{scode}}</td>
					<td class="sname">{{sname}}</td>
					<td class="dept">{{dept}}</td>
					<td class="year">{{year}}</td>
					<td class="edate">{{edate}}</td>
					<td><input type = "text" class="grade" size=1 value={{grade}} ><button>수정</button></td>
				</tr>
				{{/each}}
 			</script>
 			
			<!-- 여기에 내용 등록 종료--------------------------------------------->
		</div>
	</div>
	<div id="divBottom"><jsp:include page="../footer.jsp"/></div>
	</div>
</body>
<script>
	var lcode="${vo.lcode}";
	var lname="${vo.lname}";
	
	getList();
	
	var preGrade;
	$("#tbl").on("focus", ".row .grade", function(){
		preGrade=$(this).val();
		});
	$("#tbl").on("change keyup paste",".row .grade", function(e){
		var row=$(this).parent().parent();
		var grade=row.find(".grade").val();
		if(grade<0 || grade>100){
			alert("점수를 0~100 사이의 값을 입력하세요.");
			$(this).val(preGrade);
			$(this).focus();
		}
	});

	
	//점수수정 버튼을 눌렀을 때
	$("#tbl").on("click",".row button",function(){
		var scode=$(this).parent().parent().find(".scode").html();
		var grade=$(this).parent().find(".grade").val();
		if(!confirm(scode+"의 점수를"+grade+"로 수정하시겠습니까?")) return;
		$.ajax({
			type:"post",
			url:"/enroll/update",
			data:{"lcode":lcode,"scode":scode,"grade":grade},
			success:function(){
				alert("수정되었습니다.");
				getList();
				}
		})
	});
	
	//선택저장 버튼을 클릭한 경우
	$("#btnUpdate").on("click", function(){
		if(!confirm("선택한 학생들의 점수를 수정하시겠습니까?")) return;
		$("#tbl .row .chk:checked").each(function(){
			var scode=$(this).parent().parent().find(".scode").html();
			var grade=$(this).parent().parent().find(".grade").val();
			$.ajax({
				type:"post",
				url:"/enroll/update",
				data:{"lcode":lcode,"scode":scode,"grade":grade},
				success:function(){}
			})		
		})
		alert("수정되었습니다.");
		getList();
	})
	
	//전체체크 버튼 눌렀을 때
	$("#tbl").on("click",".title #chkAll",function(){
        if($("#chkAll").prop("checked")){
            $("input[class=chk]").prop("checked",true);
        }else{
            $("input[class=chk]").prop("checked",false);
        }
    });
	
	//각 행의 체크버튼 클릭한 경우
	$("#tbl").on("click",".row .chk",function(){
		var isChkAll=true;
		$("input[class=chk]").each(function(){if(!$(this).is(":checked")) isChkAll=false;});
		if(isChkAll){
			$("input[id=chkAll]").prop("checked", true);
		}else{
			$("input[id=chkAll]").prop("checked", false);
			}
	});
		
		

	
	function getList(){
		$.ajax({
			type:"get",
			url:"/es",
			data:{"lcode":lcode},
			dataType:"json",
			success:function(data){
				var template = Handlebars.compile($("#temp").html());
				$("#tbl").html(template(data));
				}
		})
	}


	var lname="${vo.lname}";
	$("#btnDelete").on("click",function(){
		if(!confirm(lname + "을(를) 삭제하시겠습니까?")) return;
		$.ajax({
			type:"get",
			url:"/courses/delete",
			data:{"lcode":lcode},
			dataType:"json",
			success:function(data){
				if(data.count==0){
					alert(lname+"삭제되었습니다.");
					location.href="list.jsp";
				}else{
					alert(data.count+"명이 남았음")
				}
			}
		})
	})
	
	$(frm).submit(function(e){
		e.preventDefault();		
		if(!confirm("수정하시겠습니까?")) return;		
		frm.submit();
		})	

	
	$(frm.pcode).on("click", function(){
		window.open("/professors/listAll.jsp","advisor","width=320,height=300,top=420,left=900")
	})
</script>
</html>