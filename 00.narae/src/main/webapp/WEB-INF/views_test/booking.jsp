<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
        integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

    <style>
        .col-sm {
            border: 1px solid black;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-sm">
                영화 목록
            </div>
            <div class="col-sm">
                날짜 목록
            </div>
            <div class="col-sm">
                시간 목록
            </div>
            <div class="col-sm">
                영화 정보
            </div>
        </div>
        <div class="row">
            <div class="col-sm movie-list">
            	<div id="movie-list" class="btn-group-vertical btn-group-toggle" data-toggle="buttons">
               	 
               	</div>
            </div>
            <div class="col-sm date-list">
             	<div id="date-list" class="btn-group-vertical btn-group-toggle" data-toggle="buttons">
               	 
               	</div>
            </div>
            <div class="col-sm time-list">
               	<div id="time-list" class="btn-group-vertical btn-group-toggle" data-toggle="buttons">
               	 
               	</div>
            </div>
            <div class="col-sm movie-info">
            	<div id="movie-info">
            	
            	</div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm">
            </div>
            <div class="col-sm">
            </div>
            <div class="col-sm">
            </div>
            <div class="col-sm">
                <button id="select-seats" type="button" class="btn btn-primary">좌석 선택</button>
            </div>
        </div>        

    </div>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
        crossorigin="anonymous"></script>
    <script>
		let isFirst = true;
        window.setTimeout(() => {
            $.ajax({
                url: "rest_movie_list",
                success: function (data) {
                	let html = "";
                	$.each(data, function(i, el) {
	                    html += `
	                    	  <label class="btn btn-outline-primary movie">
		                        <input type="radio" name="movies" movieNo="\${el.movieNo}">\${el.title}
		                      </label>
	                    `;
                	});
                    if(isFirst) {
	                    $("#movie-list").html(html);
	                    let movieNo;
	                    if ("${time.timeCode}" !== "") {
	                		movieNo = "${time.movie.movieNo}";
							
						}
		            	
	                	if(!movieNo) {
							$(".btn.movie input:first").trigger("click");
							return;
	                	}
	                	$(".btn.movie input[movieNo="+movieNo+"]").trigger("click");

                    }
                }

            });
        });
        
		$("#movie-list").on("click", ".btn.movie input", function(e) {
			$("#time-list").html("");
			let movieNo = $(e.target).attr("movieNo");
			$.ajax({
				url: "rest_movie_detail",
				data: "movieNo=" + movieNo,
				success: function(data) {
					let date = new Date(data.openDate); 
					let fulldate = date.getFullYear() + "년 " + (date.getMonth()+1) + "월 " + date.getDate()+ "일";
					let html = "";
					html += `
						<li>제목: \${data.title}</li>
						<li>등급: \${data.rating}</li>
						<li><img src="\${data.posterImage}" alt="포스터" width="200px" height="300px"></li>
						<li>개봉일: \${fulldate}</li>
						<li>장르: \${data.genre}</li>
						<li>상영시간: \${data.runningtime}</li>
					`;
					$("#movie-info").html(html);		
					
				}
				
			});
			
			$.ajax({
				url: "rest_movie_date_list",
				data: "movieNo=" + movieNo,
				success: function(data) {
					let html = "";
					$.each(data, function(i, el) {
						let date = new Date(el)
						let formatted = (date.getMonth()+1) + "월 " + date.getDate() + "일";
						let fulldate = date.getFullYear() + "-" + (date.getMonth()+1) + "-" + date.getDate();
						html += `
	                    	  <label class="btn btn-outline-primary date">
		                        <input type="radio" name="dates" movieNo="\${movieNo}" date="\${fulldate}">\${formatted}
		                      </label>
						`;
					});
					$("#date-list").html(html);
					
					if(isFirst) {
	                    let recvDate;
	                    let recvFullDate;
	                    let movieNo2;
	                    if ("${time.timeCode}" !== "") {
	                		movieNo2 = "${time.movie.movieNo}";
	                		recvDate = 	"<fmt:formatDate value='${time.movieDate}' pattern='yyyy-MM-dd'/>";
							
						}
		            	
	                	if(!recvDate) {
							$(".btn.date input:first").trigger("click");
							return;
	                	}
	                	$(".btn.date input[movieNo="+movieNo2+"][date="+recvDate+"]").trigger("click");
					}
					
				}
				
			});
		});
		

		$("#date-list").on("click", ".btn.date input", function(e) {
			$.ajax({
				url: "rest_movie_date_time_list",
				data: "movieNo=" + $(e.target).attr("movieNo") + "&" + "movieDate=" + $(e.target).attr("date"),
				success: function(data) {
					$("#time-list").html("");
					let groups = Object.create(null);
					
					data.forEach(item => {
					    if (!groups[item.screen.screenName]) {
					        groups[item.screen.screenName] = [];
					    }
					
					    groups[item.screen.screenName].push({
					    	timeCode: item.timeCode,
					    	startTime: item.startTime,
					    	endTime: item.endTime,
					    });

					});
					let result = Object.entries(groups).map(([k, v]) => ({[k]: v}));
					let html = "";
					result.forEach(function(el) {
						html += `<h5>\${Object.keys(el)}</h5>`;
						el[Object.keys(el)].forEach(function(el2) {
							html +=`
								<label class="btn btn-outline-primary time">
								    <input type="radio" name="options" timeCode="\${el2.timeCode}">
									시작: \${el2.startTime}<br>
								    종료: \${el2.endTime}
							    </label>
							    `;
						});
					});
					
				
					$("#time-list").html(html);
					

					if (isFirst) {
	                    let timeCode;
	                    if ("${time.timeCode}" !== "") {
	                    	timeCode = "${time.timeCode}";
							
						}
		            	
	                	if(!timeCode) {
							return;
	                	}
	                	$(".btn.time input[timeCode="+timeCode+"]").trigger("click");
					}
                	isFirst = false;
			
				}
			
			});
		});
	
        $("#select-seats").click(function(e) {
			let timeCode = $(".btn.time.active input").attr("timeCode");
			if (!timeCode) {
				alert("상영시간을 선택해주세요");
				return;
			}
			location.href="booking_seat?timeCode=" + timeCode;
		});
        
    </script>
</body>
</html>