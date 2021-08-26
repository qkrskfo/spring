<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String error_msg=(String)request.getAttribute("error_msg");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>member_error.jsp</h1><hr>
error_msg : <%=error_msg %><br>
<a href='member_main.do'>멤버메인</a>
</body>
</html>