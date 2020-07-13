<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<form action="login" method="post" name="frm">
		<table border=1 width=300>		
			<tr>
				<td colspan=2><h2>로그인</h2></td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pass"></td>
			</tr>
			<tr>
				<td colspan=2><input type="submit" value ="로그인"></td>
			</tr>
		</table>
	</form>
</body>
<script>
	$(frm).submit(function(e){
		e.preventDefault();
		var id=$(frm.id).val();
		var pass=$(frm.pass).val();
		$.ajax({ 
			type:"post",
			url:"/login",
			data:{"id":id,"pass":pass},
			dataType:"json",
			success:function(data){
				if(data.id==null){
					alert("아이디/비번 불일치")
					$(frm.id).focus();
				}else{
					alert(data.name+"입장");
					location.href="/stu/list";
				} 
			}
		})
	})
</script>
</html>