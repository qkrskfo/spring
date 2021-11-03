<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>좌석선택</title>
</head>
<body>
	<span>인원수 선택 : </span>
	<select id="person">
		<option value="1">1명</option>
		<option value="2">2명</option>
		<option value="3">3명</option>
		<option value="4">4명</option>
		<option value="5">5명</option>
		<option value="5">6명</option>
		<option value="5">7명</option>
		<option value="5">8명</option>
	</select>
	</br> 인원선택은 최대 8명까지 가능합니다. (단체예약문의)
	</br>
	
	<h3>좌석선택</h3>
	<form action="pay_action" method="post">

		<c:forEach items="${bookedSeatList }" var="bookedSeat">
			<input type="checkbox" name="bookedseat" checked="checked" disabled="disabled">
				이미 예약된 좌석 : ${bookedSeat.seat.seatCode} </br>
		</c:forEach>

		<c:forEach items="${seatCodeList }" var="emptySeatCode">
			<input type="checkbox" name="seat" value=${emptySeatCode.seat.seatCode }>
				빈좌석 : ${emptySeatCode.seat.seatCode }
			</br>
		</c:forEach>
		<h1>타임코드: ${timeCode}</h1>
		<input type="hidden" name="timeCode" value=${timeCode}>
		<input type="submit" value="예매하기">
		
	</form>
</body>
</html>