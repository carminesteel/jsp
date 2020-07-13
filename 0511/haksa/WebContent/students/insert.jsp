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
			<div id="divHeader"><h2>학 생 등 록</h2></div>
			<form name="frm">
				<table>
					<tr>
						<td class="title" width=100>학생번호</td>
						<td width=300><input type=text name="scode" maxlength=8 value="91414033" size=5></td>
						<td class="title" width=100>학생이름</td>
						<td width=300><input type=text name="sname" maxlength=8 value="홍길동" size=5></td>
					</tr>
					<tr>
						<td class="title" width=100>학생학과</td>
						<td width=300>
							<select name="dept">
								<option>전산</option>
								<option>전자</option>
								<option selected>건축</option>
							</select>
						</td>
						<td class="title" width=100>생년월일</td>
						<td width=300>
							<input type=text name="yy" maxlength=4 size=2 placeholder="yyyy">년
							<input type=text name="mm" maxlength=2 size=2 placeholder="mm">월
							<input type=text name="dd" maxlength=2 size=2 placeholder="dd">일
						</td>
					</tr>
					<tr>
						<td class="title" width=100>학년</td>
						<td width=300>
							<input type=radio name="year" maxlength=1 value="1" size=2 checked>1학년
							<input type=radio name="year" maxlength=1 value="2" size=2>2학년
							<input type=radio name="year" maxlength=1 value="3" size=2>3학년
							<input type=radio name="year" maxlength=1 value="4" size=2>4학년
						</td>
						<td class="title" width=100>지도교수</td>
						<td width=300>
							<input type="text" name="pcode" size=4 readonly placeholder="교수번호">
							<input type="text" name="pname" size=5 readonly placeholder="교수이름">
						</td>
					</tr>
				</table>
				<div id="pagination">
					<input type="button" value="저장" id=btnInsert>
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
	$("#btnInsert").on("click", function(){
		if(!confirm("저장하시겠습니까?")) return;
		var scode=$(frm.scode).val();
		var sname=$(frm.sname).val();
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
