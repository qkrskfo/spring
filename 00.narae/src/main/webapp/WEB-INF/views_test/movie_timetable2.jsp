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
					<input class="date_result" type="radio" name="options" date=<fmt:formatDate value="${date }" pattern="yyyy-MM-dd" />>
					<fmt:formatDate value="${date }" pattern="MM월 dd일" />
				</label>
			</c:forEach>
		</div>
		
		<div id="movieTimeTable">
		
		</div>
		
		<div id="movieTimeTableRest">
		
		</div>
		

 
<script>
	$(".date_result").click(function(e) {
		/*
		$.ajax({
			url: "timetable_detail",
			method: "post",
			data: "movieDate="+$(e.target).attr("date"),
			success:function(response) {
				$("#movieTimeTable").html(response);
			}
		}); */
		
		$.ajax({
			url: "timetable_detail_rest",
			method: "post",
			data: "movieDate="+$(e.target).attr("date"),
			success: function(data) {
				let groups = Object.create(null);
				
				data.forEach(item=> {
					if(!groups[item.movie.movieTitle]) {
						groups[item.movie.movieTitle] = [];
					}
					
					groups[item.movie.movieTitle].push({
						movieNo: item.movie.movieNo,
						timeCode: item.timeCode,
						screenName: item.screen.screenName,
						startTime: item.startTime,
					});
				});
				
				let result = Object.entries(groups).map(([k, v]) => ({[k]: v}));
				
				let html=`<hr>
				<h1> REST 그룹화 <h1>`;
					html+= `<div class="btn-group btn-group-toggle" data-toggle="buttons">`;
				result.forEach(function(el){
					html+=`<h3>`;
					html+=Object.keys(el);
					html+=`</h3>`;
					el[Object.keys(el)].forEach(function(el2){
						html +=`<label class="btn btn-outline-primary ">
						    <input type="radio" name="options" timeCode="`;
						html += el2.timeCode;
						html +=`">`;
						html += el2.movieNo;
						html += `&nbsp;`;
						html += el2.screenName;
						html += el2.startTime;
						html += `</label>`;
					});
				});
					html+=`</div>`;
				$("#movieTimeTableRest").html(html);	
			}
		});
	});
</script>
</body>
</html>