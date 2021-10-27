<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${sMemberId}님의 예매 내역</h1>
	<c:forEach var="ticket" items="${memberTicketList}" varStatus="status">
		<div>
			${ticket}
		</div>
		<c:if test="${status.last}">
			<h2>총 예매 수: ${status.count}</h2>
		</c:if>
	</c:forEach>
</body>
</html>