<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${sMemberId}님의 예매 내역</h1>
	<!--  ${ticket} -->
	<ul>
		<li>예약번호: ${ticket.ticketNo}</li>
		<li>상영일: <fmt:formatDate value="${ticket.time.movieDate}" pattern="yyyy-MM-dd" /></li>
		<li>관람영화: ${ticket.time.movie.title}</li>
		<li>상영관: ${ticket.time.screen.screenNo}관</li>
		<li>시작 시간: ${ticket.time.startTime}</li>
		<li>끝나는 시간: ${ticket.time.endTime}</li>
		<li>상영시간: ${ticket.time.movie.runningtime}</li>
		<c:forEach items="${ticket.bookedSeatList}" var="bookedSeat">
			<li>좌석: ${bookedSeat.seat.seatCode}</li>
		</c:forEach>
		<li>주문일: <fmt:formatDate value="${ticket.orderDate}" pattern="yyyy-MM-dd" /></li>
		<li>금액: ${ticket.payCost}원</li>
		<c:if test = "${ 0 eq ticket.ticketStatus}">
			<li>
			예약 상태: 예약 취소
			</li>
		</c:if>
		<c:if test = "${ 1 eq ticket.ticketStatus}">
			<li>
			예약 상태: 예약 완료
			</li>
		</c:if>
		<%-- 예약 상태: ${ticket.ticketStatus eq 0 ? '예약 취소' : '예약 완료'} --%>
	</ul>
</body>
</html>