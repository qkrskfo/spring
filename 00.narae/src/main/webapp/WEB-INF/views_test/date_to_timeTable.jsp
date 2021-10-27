<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>date_timeTable</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
</head>
<body>
<h1>영화, 날짜 선택 후 타임테이블</h1>
<!-- 
<c:forEach items="${timeTable}" var="time">
	<button class="time" timeCode="${time.timeCode }">
		상영관: ${time.screen.screenName }<br>
		시작시간: ${time.startTime }<br>
		종료시간: ${time.endTime }
	</button>
	<hr>
</c:forEach>
 -->
<form id="timeTableList">
<div class="btn-group btn-group-toggle" data-toggle="buttons">
	<c:forEach items="${timeTable}" var="time">
	  <label class="btn btn-outline-primary ">
	    <input type="radio" name="options" id="${time.timeCode }">
   		상영관: ${time.screen.screenName }<br>
		시작시간: ${time.startTime }<br>
		종료시간: ${time.endTime }
	  </label>
	</c:forEach>
</div>
</form>

<script type="text/javascript">
/*
	$(".time").click(function(e) {
		location.href = "" + $(e.target).attr("timeCode");
	});
*/
$("#timeTableList .btn.btn-outline-primary:first").addClass("active");
</script>
</body>
</html>