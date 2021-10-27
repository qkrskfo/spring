<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<ul>
<c:forEach items="${timeTable }" var="time">
	<li>상영관: ${time.screen.screenName }</li>		
	<li>시작시간: ${time.startTime }</li>		
</c:forEach>
</ul>
</body>
</html>