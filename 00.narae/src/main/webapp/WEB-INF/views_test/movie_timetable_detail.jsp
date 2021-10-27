<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
</head>
<body>
<!-- 
	<ul>
		<c:forEach items="${timeList}" var="time">
			<li><img src="${time.movie.posterImage}" width=150 height=150/></li>		
			<li>${time.movie.rating} &nbsp;<b>${time.movie.title}</b></li>
			<li>${time.screen.screenName}</li>		
			<li>${time.startTime}</li>
			<hr/>
		</c:forEach>
	</ul>
 -->
 <form id="timeTablePage">
	<div class="btn-group-vertical btn-group-toggle" data-toggle="buttons">
		<c:forEach items="${timeList}" var="time">
			<label class="btn btn-outline-primary">
				<input type="radio" name="options" id="${time.timeCode}">
				<img src="${time.movie.posterImage}" width=150 height=150/><br>		
				${time.movie.rating} &nbsp;<b>${time.movie.title}</b><br>
				${time.screen.screenName}<br>		
				${time.startTime}<br>
			</label>
		</c:forEach>
	</div> 
 </form>
 
 <script type="text/javascript">
 	$("#timeTablePage .btn.btn-outline-primary:first").addClass("active");
 </script>
</body>
</html>