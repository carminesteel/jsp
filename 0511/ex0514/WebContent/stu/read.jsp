<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script> 
	<meta charset="UTF-8">
	<title>학생정보</title>
</head>
<body>
	<h1>[학생정보]</h1>
	<form action="update" method="post" name="frm">
	<table border=1 width=700>
		<tr>
			<td>학생번호</td>
			<td><input type="text" name="scode" maxlength=8 value="${vo.scode}" readonly></td>
		</tr>
		<tr>
			<td>학생이름</td>
			<td><input type="text" name="sname" value="${vo.sname}"></td>
		</tr>
		<tr>
			<td>학생학과</td>
			<td>
				<select name="dept">
					<option <c:out value="${vo.dept.equals('전산')?'selected':''}"/>>전산</option>
					<option <c:out value="${vo.dept.equals('전자')?'selected':''}"/>>전자</option>
					<option <c:out value="${vo.dept.equals('건축')?'selected':''}"/>>건축</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>학년</td>
			<td>
				<input type="radio" <c:out value="${vo.year==(1)?'checked':''}"/>>1학년
				<input type="radio" <c:out value="${vo.year==(2)?'checked':''}"/>>2학년
				<input type="radio" <c:out value="${vo.year==(3)?'checked':''}"/>>3학년
				<input type="radio" <c:out value="${vo.year==(4)?'checked':''}"/>>4학년
			</td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td><input type="text" name="birthday" value="${vo.birthday}"></td>
		</tr>
		<tr>
			<td>지도교수:</td>
			<td>
				<select name="advisor">
					<c:forEach items="${plist}" var="v">
						<option value="${v.pcode}" <c:out value="${vo.advisor==v.pcode?'selected':''}"/>>${v.pname}</option>
					</c:forEach>
				</select>
			</td>
		</tr>
	</table>
	<input type = "submit" value="수정">
	<input type = "button" value="삭제" id="btnDel">
	<input type = "reset" value="취소">
	<input type = "button" value="목록" onClick="location.href='list'">
	</form>
	
	<!-- 수강신청  -->
	<div id = enroll>
		<h1>[수강신청]</h1>
		<div id = apply>
			강좌명:
			<select id = "lcode">
			<c:forEach items="${clist}" var="cvo">
				<option value="${cvo.lcode}">${cvo.lcode}-${cvo.lname}-${cvo.room}</option>
			</c:forEach>
			</select>
			<input type="button" value = "신청" id=btnApply>
		</div>
		<table id = tbl></table>
		<script id="temp" type="text/x-handlebars-template">
			{{#each .}}
				<tr class=row>
					<td class=lcode>{{lcode}}</td>
					<td>{{lname}}</td>
					<td>{{edate}}</td>
					<td>{{grade}}</td>
					<td><button>수강취소</button></td>
				</tr>
			{{/each}}
		</script>
	</div>
</body>

<script>
	var scode="${vo.scode}";
	
	//수강취소
	$("#tbl").on("click",".row button", function(){		
		var row=$(this).parent().parent();
		var lcode=row.find(".lcode").html();
		if(!(confirm(lcode+"을(를) 수강을 취소하시겠습니까?"))) return;
		alert(scode+lcode);
		$.ajax({
			type:"post",
			url:"/enroll/delete",
			data:{"scode":scode,"lcode":lcode},
			success:function(){				
				alert("수강취소완료.");
				getList();
			}
		})
	});
	//수강신청
	$("#btnApply").on("click", function(){
		var lcode=$("#lcode").val();
		alert(scode+lcode);
		$.ajax({
			type:"post",
			url:"/enroll/insert",
			data:{"scode":scode,"lcode":lcode},
			dataType:"json",
			success:function(data){
				if(data.cnt==1){
					alert("이미 수강신청되었습니다.");
				}else{
					getList();
				}
			}
		})
	});
	
	getList();
	
	function getList(){
	   $.ajax({
		      type:"get",
		      url:"/stu/enroll",
		      data:{"scode":scode},
		      dataType:"json",
		      success:function(data){
		         var temp=Handlebars.compile($("#temp").html());
		         $("#tbl").html(temp(data));
		      }
		   });
	}

	$(frm).submit(function(e){
		e.preventDefault();
		if(!confirm("저장하시겠습니까?")) return;
			frm.submit();
		}
	);

	$("#btnDel").on("click", function(){
		if(!confirm("삭제하시겠습니까")) return;
		frm.action="delete";
		frm.method="post";
		frm.submit();
	})
</script>
</html>