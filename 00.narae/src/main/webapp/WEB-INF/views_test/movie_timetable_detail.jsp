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
<h1>ddddd</h1>
	<ul>
		<c:forEach items="${mapList}" var="time">
				<li><img src="${time.posterImage}" width=150 height=150/></li>		
				<li>${time.rating} &nbsp;<b>${time.title}</b></li>
				<li>${time}</b></li>
					<ul>
							<li>제목:${time.screen.screenName}</li>
					</ul>			
				<hr/>
		</c:forEach>
	</ul>
<h1>d222222222222</h1>
 <form id="timeTablePage">
	<div class="btn-group-vertical btn-group-toggle" data-toggle="buttons">
		<c:forEach items="${mapList}" var="time">
				<label class="btn btn-outline-primary">
					<input type="radio" name="options" id="${time.timeCode}">
					<img src="${time.posterImage}" width=150 height=150/><br>		
					${time.rating} &nbsp;<b>${time.title}</b><br>
					${time.startTime}<br>
				</label>
				<ul>
					<c:forEach items="${dateTimeTable}" var="timetable">
						<li>${timetable.screenName}</li>
					</c:forEach>
				</ul>	
		</c:forEach>
	</div> 
 </form>

 <script type="text/javascript">
 	//$("#timeTablePage .btn.btn-outline-primary:first").addClass("active");
 	console.log(${mapList});
 	console.log(${timetable.screenName});
 </script>
</body>
</html>