<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
</head>
<script type="text/javascript">

</script>
<body>
<!-- 
	<h2><s:eval expression="new java.text.SimpleDateFormat('MM').format(dateList[0])"></s:eval>월</h2>
	<ul>
		<c:forEach items="${dateList}" var="date">
			<li><a href="timetable_detail?movieDate=<s:eval expression="new java.text.SimpleDateFormat('yyyy-MM-dd').format(date)"></s:eval>"><s:eval expression="new java.text.SimpleDateFormat('yyyy-MM-dd').format(date)"></s:eval></a></li>
		</c:forEach>
	</ul>
 -->	
 <!-- 
	<div id=container>
		<div id="header">
			<h2><s:eval expression="new java.text.SimpleDateFormat('MM').format(dateList[0])"></s:eval>월</h2>
		</div>
		<div id="sidebar">
			<div id="menus">
				<c:forEach items="${dateList}" var="date2">
					<div class="menu" id="menu-<s:eval expression="new java.text.SimpleDateFormat('yyyy-MM-dd').format(date2)"></s:eval>">
						<h3>
							<a href="timetable_detail?movieDate=<s:eval expression="new java.text.SimpleDateFormat('yyyy-MM-dd').format(date2)"></s:eval>"><s:eval expression="new java.text.SimpleDateFormat('yyyy-MM-dd').format(date2)"></s:eval></a>
						</h3>
					</div>
				</c:forEach>
			</div>
		</div>
		<div id="content">
			<div id="time_list"></div>
		</div>
	</div>
 -->	
 
 

		<div id="header">
			<h2><s:eval expression="new java.text.SimpleDateFormat('MM').format(dateList[0])"></s:eval>월</h2>
		</div>
		<div class="btn-group btn-group-toggle" data-toggle='buttons'>
			<c:forEach items="${dateList}" var="date">
				<label class="btn btn-outline-primary">
					<input class="datepick" type="radio" name="options" date=<fmt:formatDate value="${date }" pattern="yyyy-MM-dd" />>
					<fmt:formatDate value="${date }" pattern="MM월 dd일" />
				</label>
			</c:forEach>
		</div>
		
		<div id="timetable2">
		
		</div>

 
<script>
	$(".datepick").click(function(e) {
		$.ajax({
			url: "timetable_detail",
			method: "get",
			data: "movieDate="+$(e.target).attr("date"),
			success:function(response) {
				$("#timetable2").html(response);
			}
		});
	});
</script>
</body>
</html>