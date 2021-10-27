<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>좌석예약</title>
</head>
<script type="text/javascript">
	/*
	 var seats = []; 
	 for (var i=1; i<97; i++) { 
	 seats[i] = false; 
	 } 
	 function reserve(sValue) { 
	 var msg = " "; 
	 var seatCode = document.getElementByName("seatCode").value; 
	 seatNo = Number(seatNo) - 1; 
	 if(sValue) { 
	 if(seats[seatNo]) { 
	 msg = seatNo+1 + "번 좌석은 이미 예매되었습니다."; 
	 } else { 
	 seats[seatNo] = true; 
	 showSeatColor(sValue, seatNo+1); 
	 } 
	 } else { 
	 if(!seats[seatNo]) { 
	 msg = seatNo+1 + "빈좌석입니다"; 
	 } else { 
	 seats[seatNo] = false; 
	 showSeatColor(sValue, seatNo+1); 
	 } 
	 } 
	 }

	// html 이 다 로딩된 후 실행
	$(document).ready(function() {
		// 체크박스들이 변경됬을때
		$(":checkbox").change(function() {
			var cnt = $("#person").val();

			// 셀렉트박스의 값과 체크박스중 체크된 갯수가 같을때 다른 체크박스들을 disable 처리
			if (cnt == $(":checkbox:checked").length) {
				$(":checkbox:not(:checked)").attr("disabled", "disabled");
			}
			// 체크된 갯수가 다르면 활성화 시킴
			else {
				$(":checkbox").removeAttr("disabled");
			}
		});

		// 셀렉트박스에서 다른 인원수를 선택하면 초기화 시킴
		$("#person").change(function() {
			$(":checkbox").removeAttr("checked");
			$(":checkbox").removeAttr("disabled");
		});
	});
	
	 */
</script>
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
		<option value="5">9명</option>
		<option value="5">10명</option>

	</select>

	<table border="1">
		<tr>
			<td><label><input type="checkbox" />1</label></td>
			<td><label><input type="checkbox" />2</label></td>
			<td><label><input type="checkbox" />3</label></td>
			<td><label><input type="checkbox" />4</label></td>
			<td><label><input type="checkbox" />5</label></td>
		</tr>
		<tr>
			<td><label><input type="checkbox" />6</label></td>
			<td><label><input type="checkbox" />7</label></td>
			<td><label><input type="checkbox" />8</label></td>
			<td><label><input type="checkbox" />9</label></td>
			<td><label><input type="checkbox" />10</label></td>
		</tr>
	</table>
	<a>10명이상 단체예매는 문의바람으로?</a>
	</br>
	<h3>좌석선택</h3>
	<c:forEach items="${bookedSeatList }" var="bookedSeat">
		<input type="checkbox" name="bookedseat" checked="checked"
			disabled="disabled">${seat.seat } <br/>${seat.ticket }<br/>
		<a>이미 티켓팅된 좌석</a><br/>
	</c:forEach>
	</br>
	<li>빈좌석중 bookedSeatList 해서 나오게 how?..</li>
	<input type="button" value="예매" onclick="">
	
</body>
</html>