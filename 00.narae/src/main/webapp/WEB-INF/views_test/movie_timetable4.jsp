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

	<!-- Bootstrap -->
    <link href="./bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />
    <!-- Animate.css -->
    <link href="./animate.css/animate.css" rel="stylesheet" type="text/css" />
    <!-- Font Awesome iconic font -->
    <link href="./fontawesome/css/fontawesome-all.css" rel="stylesheet" type="text/css" />
    <!-- Magnific Popup -->
    <link href="./magnific-popup/magnific-popup.css" rel="stylesheet" type="text/css" />
    <!-- Slick carousel -->
    <link href="./slick/slick.css" rel="stylesheet" type="text/css" />
    <!-- Fonts -->
    <link href='https://fonts.googleapis.com/css?family=Oswald:300,400,500,700' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700' rel='stylesheet' type='text/css'>
    <!-- Theme styles -->
    <link href="./css/dot-icons.css" rel="stylesheet" type="text/css">
    <link href="./css/theme.css" rel="stylesheet" type="text/css">


<link rel="stylesheet" type="text/css" href="css/narae.css" />
</head>
<script type="text/javascript">

</script>

<body>
 
<div class="movie-cal">
    <div class="hd">
      <div class="day-cnt swiper-container-horizontal">
        <div class="swiper-wrapper btn-group-toggle" id="DTRYX-SCINEMA-PLAYDATE" data-toggle="buttons">
	        <div class="swiper-slide month swiper-slide-active" style="margin-right: 10px;">
	        	<!-- <div class="wrap">11월</div>  -->
	        	<div class="wrap"><s:eval expression="new java.text.SimpleDateFormat('MM').format(dateList[0])"></s:eval>월</div>
	        </div>


        	
        	<c:forEach items="${dateList}" var="date">
	        	<div class="swiper-slide day" style="margin-right: 10px;">
	        		<a class="wrap date_result" href="#none" date="${date}">
	        			<div class="week">화</div>
	        			<div class="n"><fmt:formatDate value="${date }" pattern="dd" /></div>
	        		</a>
	        	</div>
        	</c:forEach>
        	
        	<div id="DTRYX-SCINAMA-NABI">
	      		<a href="#none" class="prev swiper-button-disabled"><span>이전</span></a>
				<a href="#none" class="next swiper-button-disabled"><span>다음</span></a> 
			</div>
        	
        </div> <!-- swiper wrap -->
		
      </div>
    </div>

    <div class="loc-tab" id="DTRYX-SCINEMA-REGION">
    </div>
</div>

<br> 
<br> 
<br> 
<br> 
  <!-- ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ -->
 
 
 	<div id="header">
		<h2>
			<s:eval expression="new java.text.SimpleDateFormat('MM').format(dateList[0])"></s:eval>월
		</h2>
	</div>
	
	<div class="btn-group btn-group-toggle" data-toggle='buttons'>
		<c:forEach items="${dateList}" var="date">
			<label class="btn btn-outline-primary">
				<input class="date_result" type="radio" name="options" date="${date }">
				<fmt:formatDate value="${date }" pattern="MM월 dd일" />
			</label>
		</c:forEach>

	</div>
	
	<div id="movieTimeTableRest">
	
	</div>
	
	<div id="pickedTicket">
	
	</div>
 
 
 
 
 
 
 
 
 
 
<script>
	let isFirst = true;
	window.setTimeout(() => {
		if(isFirst) {
			//$(".swiper-wrapper .day:first").addClass("active");
			//$(".day a:first").addClass("swiper-slide-active");
			$(".day a:first").trigger("click");
			isFirst = false;
			return;
		}
	});
	



	$(".date_result").click(function(e) {
		$.ajax({
			url: "timetable_detail_rest",
			method: "get",
			data: "movieDate="+$(e.target).attr("date"),
			
			success: function(data) {
				let html='';
					$.each(data, function(i, movie) {
						if(movie.dateTimeTable.length>0) {
							html+=`<hr> 
									<div class="btn-group-vertical btn-group-toggle" data-toggle="buttons">
									<img src="\${movie.posterImage}" width=200 height=200>
									<h3>\${movie.title}(\${movie.rating})</h3>
									`;
							$.each(movie.dateTimeTable, function(i, time) {
								html += `<div class="btn-group btn-group-toggle">
											<label class="btn btn-outline-primary">
											<input type="radio" name="options" timeCode="\${time.timeCode}">
											<p class="pickedMovie">\${time.screen.screenName}&nbsp;\${time.startTime}&nbsp;잔여석: \${96 - time.bookedCount}석</p>
											</label>
											</div>`;
							});		
							html+=`</div>`;	
						}	//if문
					});
					$("#movieTimeTableRest").html(html);
			}
		});
		e.preventDefault();
	});


	$('#movieTimeTableRest').on('click', 'input', function(e){
		window.location.href = "booking?timeCode=" + $(e.target).attr('timeCode');
	});


</script>
</body>
</html>