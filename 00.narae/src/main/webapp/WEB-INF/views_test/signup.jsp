<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
</head>
<body>
<h1>Signup</h1><hr/>
<form action="signup_action"method="post">
	id<input type="text" name="id" value=""><br>
	password<input type="text"name="password" value=""><br>
	name<input type="text" name="name" value=""><br>
	phone<input type="text" name="phone" value=""><br>
	birth_date<input type="text" name="birth_date" value=""><br>
	<input type="submit" value="가입">
</form>
</body>
</html>