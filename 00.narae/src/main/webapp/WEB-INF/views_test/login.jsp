<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function login() {
		if (f.id.value == "") {
			alert("아이디를 입력하세요.");
			f.id.focus();
			return false;
		}

		if (f.password.value == "") {
			alert("비밀번호를 입력하세요.");
			f.password.focus();
			return false;
		}

		f.action = "login_action";
		f.submit();
	}
</script>
</head>
<body>

<h1>로그인</h1><br>

<form name="f" method = "post">
	<p>아이디: <input type="text" name="id" value="${fmember.id}"></p>
	<p>비밀번호: <input type="password" name="password" value="${fmember.password}"></p>
	<input type="button" value="로그인" onclick="login();">
</form>

</body>
</html>
