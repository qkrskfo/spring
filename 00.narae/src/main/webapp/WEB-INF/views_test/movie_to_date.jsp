<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>movie_to_date</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
</head>
<body>
<h1>영화 선택 후 날짜 목록</h1>
<%-- 
<c:forEach items="${timeList}" var="time">
	<button class="date" movieNo="${time.movie.movieNo}" date="${time.movieDate }">
		날짜: <fmt:formatDate value="${time.movieDate }" pattern="MM월 dd일" />
	</button>
	<hr>
</c:forEach> 
--%>
<!-- 
<c:forEach items="${dateList }" var="date">
	<button class="date" movieNo="${movieNo }" date=<fmt:formatDate value="${date }" pattern="yyyy-MM-dd" />>
		날짜: <fmt:formatDate value="${date }" pattern="MM월 dd일" />
	</button>
	<hr>
</c:forEach>
 -->
<div class="btn-group-vertical btn-group-toggle" data-toggle="buttons">
	<c:forEach items="${dateList }" var="date">
	  <label class="btn btn-outline-primary ">
	    <input class="date2" type="radio" name="options" movieNo="${movieNo }" date=<fmt:formatDate value="${date }" pattern="yyyy-MM-dd" />>
		<fmt:formatDate value="${date }" pattern="MM월 dd일" />
	  </label>
	</c:forEach>
</div>

<div id="timeTable">

</div>

<script>
/*
	$(".date").click(function(e) {
		location.href = "date_to_timeTable?movieNo=" + $(e.target).attr("movieNo") + "&movieDate=" + $(e.target).attr("date");
	});
*/
	$(".date2").click(function(e) {
		$.ajax({
			url: "date_to_timeTable",
			method: "post",
			data: "movieNo=" + $(e.target).attr("movieNo") + "&movieDate=" + $(e.target).attr("date"),
			success: function(response) {
				$("#timeTable").html(response);
			}
			
		});
	});
	
</script>
</body>
</html>