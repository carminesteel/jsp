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
			<form name="frm" action="insert" method="post">
				 <table>
					 <tr>
						 <td class="title">강좌번호</td><td><input type="text" size=10 name="lcode" placeholder="강좌코드"></td>
						 <td class="title" width=150>강의실</td><td><input type="text" size=5 name="room" placeholder="강의실명"></td>
						 <td class="title" width=150>강의시수</td><td><input type="text" size=5 name="hours" placeholder="시수"></td>
					 </tr>
					 <tr>
						 <td class="title">강좌이름</td><td colspan=3><input type="text" size=60 name="lname" placeholder="강좌명"></td>
						 <td class="title">최대수강인원</td><td><input type="text" size=5 name="capacity" placeholder=""></td>
					 </tr>
					 <tr>
						 <td width=90 class="title">담당교수</td>
						 <td width=400 colspan=3>
						 <input type="text" size=5 name="pcode" value="">
						 <input type="text" size=10 name="pname" value="">
					 	</td>
					 	<td class="title">수강신청인원</td><td><input type="text" size=5 name="persons" value="${vo.persons}"></td>
					 </tr>
				 </table>
			 <div id="pagination">
				 <input type="submit" value="저장" id="btnInsert">
				 <input type="reset" value="취소">
			 </div>
			</form>
			<!-- 여기에 내용 등록 종료--------------------------------------------->
		</div>
	</div>
	<div id="divBottom"><jsp:include page="../footer.jsp"/></div>
	</div>
</body>
<script>
	$(frm).submit(function(e){
		e.preventDefault();
		if(!confirm("새로운 강좌를 등록하시겠습니까?")) return;
		var lcode=$(frm.lcode).val();
		$.ajax({
			type:"get",
			url:"/courses/ck",
			data:{"lcode":lcode},
			dataType:"json",
			success:function(data){
				if(data.count==0){
					frm.submit();
					alert("등록되었습니다.");
				}else{
					alert(data.count);
					alert("이미 사용된 강좌번호입니다.");					
					$(frm.lcode).focus();
				}
			}
		})	
	})
	
	$(frm.pcode).on("click", function(){
		window.open("/professors/listAll.jsp","advisor","width=320,height=300,top=420,left=900")
	})

	
	$("#btnInsert").on("click", function(){
		if(!confirm("저장하시겠습니까?")) return;
		
		var dept=$(frm.dept).val();
		var year=$('input[name="year"]:checked').val();
		var birthday=$(frm.yy).val()+"-"+$(frm.mm).val()+"-"+$(frm.dd).val();
		var advisor=$(frm.pcode).val();
		
		var fmtDate = /^(19|20)\d{2}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[0-1])$/;
		if(scode==""||sname==""||birthday==""||advisor==""){
			alert("학번, 학생이름을 입력하세요!"); return;
		}else if(!fmtDate.test(birthday)){
			alert("날짜는 yyyy-mm-dd 형식으로 입력해주세요."); return;
			return;
		}
		$.ajax({
			type:"post",
			url:"insert",
			data:{"scode":scode,"sname":sname,"dept":dept,"year":year,"advisor":advisor,"birthday":birthday},
			dataType:"json",
			success:function(data){
				if(data.count==0){
					alert("등록되었습니다.");
					location.href="list.jsp";
				}else{
					alert("이미 사용된 학번입니다.");
				}
			}
		})
	});
	
	$(frm.pcode).on("click", function(){
		window.open("/professors/listAll.jsp","advisor","width=320,height=300,top=420,left=900")
	})
</script>
</html>
