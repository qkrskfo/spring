<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	session.setAttribute("sUserId", "summer");
	session.setAttribute("level", 5);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSTL core if tag</h1>
	<hr>
	<c:if test="true">
		1. 반드시 실행<br>
	</c:if>
	<c:if test="false">
		2. 반드시 실행XXX<br>
	</c:if>
	<c:if test="${empty sUserId}">
		<a href='login_form.jsp'>로그인</a><br>
	</c:if>
	<c:if test="${!(empty sUserId)}">
		<a href='logout_action.jsp'>로그아웃</a><br>
	</c:if>
	<c:if test="${!empty level && level>=5}">
			${level}레벨이라니 부러워요 고수이시군요!<br>
	</c:if>
	
	
</body>
</html>