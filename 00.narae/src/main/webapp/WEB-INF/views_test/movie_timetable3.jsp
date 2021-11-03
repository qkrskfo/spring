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
		
 
 <!-- ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ -->
 
<div class="movie-cal">
    <div class="hd">
      <div class="day-cnt swiper-container-horizontal">
        <div class="swiper-wrapper" id="DTRYX-SCINEMA-PLAYDATE">
	        <div class="swiper-slide month swiper-slide-active" style="margin-right: 10px;">
	        	<div class="wrap">11월</div>
	        </div>
        	<div class="swiper-slide day active swiper-slide-next" style="margin-right: 10px;">
        		<a class="wrap" href="#none" data-yyyy-mm-dd="2021-11-01" onclick="onClickPlayDate('2021-11-01')">
        			<div class="week">월</div>
        			<div class="n">01</div>
        		</a>
        	</div>
        	<div class="swiper-slide day" style="margin-right: 10px;">
        		<a class="wrap" href="#none" data-yyyy-mm-dd="2021-11-02" onclick="onClickPlayDate('2021-11-02')">
        			<div class="week">화</div>
        			<div class="n">02</div>
        		</a>
        	</div>
        	<div class="swiper-slide day" style="margin-right: 10px;">
        		<a class="wrap" href="#none" data-yyyy-mm-dd="2021-11-03" onclick="onClickPlayDate('2021-11-03')">
        			<div class="week">수</div>
        			<div class="n">03</div>
        		</a>
        	</div>
        	<div class="swiper-slide day" style="margin-right: 10px;">
        		<a class="wrap" href="#none" data-yyyy-mm-dd="2021-11-04" onclick="onClickPlayDate('2021-11-04')">
        			<div class="week">목</div>
        			<div class="n">04</div>
        		</a>
        	</div>
        	<div class="swiper-slide day" style="margin-right: 10px;">
        		<a class="wrap" href="#none" data-yyyy-mm-dd="2021-11-05" onclick="onClickPlayDate('2021-11-05')">
        			<div class="week">금</div>
        			<div class="n">05</div>
        		</a>
        	</div>
        	<div class="swiper-slide day" style="margin-right: 10px;">
        		<a class="wrap" href="#none" data-yyyy-mm-dd="2021-11-06" onclick="onClickPlayDate('2021-11-06')">
        			<div class="sat">토</div>
        			<div class="nsat">06</div>
        		</a>
        	</div>
        	<div class="swiper-slide day" style="margin-right: 10px;">
        		<a class="wrap" href="#none" data-yyyy-mm-dd="2021-11-07" onclick="onClickPlayDate('2021-11-07')">
        			<div class="sun">일</div>
        			<div class="nsun">07</div>
        		</a>
        	</div>
        </div>
        
		<div id="DTRYX-SCINAMA-NABI">
      		<a href="#none" class="prev swiper-button-disabled"><span>이전</span></a>
			<a href="#none" class="next swiper-button-disabled"><span>다음</span></a> 
		</div>
		
      </div>
    </div>

    <div class="loc-tab" id="DTRYX-SCINEMA-REGION">
    </div>
</div>
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
<script>
	let isFirst = true;
	window.setTimeout(() => {
		if(isFirst) {
			$(".btn input:first").trigger("click");
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