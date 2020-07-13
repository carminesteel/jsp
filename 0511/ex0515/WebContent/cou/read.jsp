<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
	<meta charset="UTF-8">
	<title>강의정보</title>
</head>
<body>
<div><%@include file="../menu.jsp"%></div>
	<h1>[강의정보]</h1>
	<form action="update" method="post" name="frm">
	<table border=1 width=700>
		<tr>
			<td>강의번호</td>
			<td><input type="text" name="lcode" value="${vo.lcode}" readonly></td>
		</tr>
		<tr>
			<td>강의이름</td>
			<td><input type="text" name="lname" value="${vo.lname}"></td>
		</tr>
		<tr>
			<td>시수</td>
			<td><input type="text" name="hours" value="${vo.hours}"></td>
		</tr>
		<tr>
			<td>강의실</td>
			<td><input type="text" name="room" value="${vo.room}"></td>
		</tr>
		<tr>
			<td>지도교수</td>
			<td><input type="text" name="instructor" value="${vo.instructor}"></td>
		</tr>
		<tr>
			<td>수용인원</td>
			<td><input type="text" name="capacity" value="${vo.capacity}"></td>
		</tr>
		<tr>
			<td>수강목록</td>
			<td><input type="text" name="persons" value="${vo.persons}"></td>
		</tr>
	</table>
	<input type = "submit" value="수정">
	<input type = "button" value="삭제" id="btnDel">
	<input type = "reset" value="취소">
	<input type = "button" value="목록" onClick="location.href='list'">
	</form>
	<div id="enroll">
		<h1>[수강신청]</h1>
		<div id="apply">
			<table id = tbl1 border=1 width=700></table>
		<script id="temp" type="text/x-handlebars-template">
				<tr class=row>
					<td class=scode>학번</td>
					<td>이름</td>
					<td>신청일</td>
					<td>성적</td>
					<td colspan = 2>점수입력</td>
				</tr>
			{{#each .}}
				<tr class=row>
					<td class=scode>{{scode}}</td>
					<td>{{sname}}</td>
					<td>{{edate}}</td>
					<td>{{grade}}</td>
					<td><input type="text" value={{grade}} class="newGrade"></td>
					<td><input type=button value="적용" class="btnApply"></td>
				</tr>
			{{/each}}
		</script>			
		</div>
	</div>
</body>

<script>
	var lcode="${vo.lcode}";
	getList();

	$(frm).submit(function(e){
		e.preventDefault();
		if(!confirm("저장하시겠습니까?")) return;
			frm.submit();
		});
	 

	$("#btnDel").on("click", function(){
		if(!confirm("삭제하시겠습니까")) return;
		frm.action="delete";
		frm.method="post";
		frm.submit();
	})
	
	$("#tbl1").on("click",".btnApply" ,function(){
		var row = $(this).parent().parent();
		var lcode="${vo.lcode}";
		var scode=row.find(".scode").html();
		var grade=$(".newGrade").val();
		if(!confirm("적용?")) return;
		alert(lcode)
		alert(scode)
		alert(grade)
		$.ajax({
			type:"post",
			url:"/enroll/update",
			data:{"lcode":lcode,"scode":scode,"grade":grade},
			success:function(){
				
				getList();
			}
		});
	})

	function getList(){
		alert(lcode);
	   $.ajax({
		      type:"get",
		      url:"/cou/enroll",
		      data:{"lcode":lcode},
		      dataType:"json",
		      success:function(data){
		         var temp=Handlebars.compile($("#temp").html());
		         $("#tbl1").html(temp(data));
		      }
		});
		}
		
		
</script>
</html>