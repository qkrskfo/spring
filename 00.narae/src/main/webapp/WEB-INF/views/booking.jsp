<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <title>Little Cinema</title>
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
    <link
        href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700&family=Open+Sans:wght@300&display=swap"
        rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Oswald:300,400,500,700' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700' rel='stylesheet' type='text/css'>
    <!-- Theme styles -->
    <link href="./css/dot-icons.css" rel="stylesheet" type="text/css">
    <link href="./css/theme.css" rel="stylesheet" type="text/css">
    <link href="./css/booking.css" rel="stylesheet" type="text/css">

<body class="body">
        <header class="header header-horizontal header-view-pannel">
            <div class="container">
                <!-- navibar start -->
				<jsp:include page="nav.jsp"></jsp:include>
                <!-- navibar end -->
            </div>
        </header>

    <div class="container">
        <div class="booking">
	        <div class="row text-center row-title">
	            <div class="col-3">
	                <strong>영화</strong>
	            </div>
	            <div class="col-2">
	                <strong>날짜</strong>
	            </div>
	            <div class="col">
	                <strong>시간</strong>
	            </div>
	            <div class="col">
	                <strong>구매내역</strong>
	            </div>
	        </div>
	        <div class="row text-center">
	            <div class="col-3 movie-list">
	                <div id="movie-list" class="btn-group-vertical btn-group-toggle list-item" data-toggle="buttons">
	
	                </div>
	            </div>
	            <div class="col-2 date-list">
	                <div id="date-list" class="btn-group-vertical btn-group-toggle list-item" data-toggle="buttons">
	
	                </div>
	            </div>
	            <div class="col time-list">
	                <div id="time-list" class="btn-group-vertical btn-group-toggle list-item" data-toggle="buttons">
	
	                </div>
	            </div>
	            <div class="col movie-info">
	                <div id="movie-info" class="text-left">
	
	                </div>
	                <button id="select-seats" type="button" class="btn btn-theme btn-booking">좌석 선택</button>
	            </div>
	        </div>
        </div>
    </div> 
    <div>
    	<form id="booking-form">
    		<input type="hidden" name="timeCode">
    	</form>
    </div>       
    <a class="scroll-top disabled" href="#"><i class="fas fa-angle-up" aria-hidden="true"></i></a>
    <!--footer start-->
		<jsp:include page="footer.jsp"></jsp:include>
    <!--footer end-->

    <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
        crossorigin="anonymous"></script>
    <!-- Paralax.js -->
    <script src="./parallax.js/parallax.js"></script>
    <!-- Waypoints -->
    <script src="./waypoints/jquery.waypoints.min.js"></script>
    <!-- Slick carousel -->
    <script src="./slick/slick.min.js"></script>
    <!-- Magnific Popup -->
    <script src="./magnific-popup/jquery.magnific-popup.min.js"></script>
    <!-- Inits product scripts -->
    <script src="./js/script.js"></script>
    <script src="./js/booking.js"></script>
    <!-- custom script -->
    <script>
    /*
    	if("${sMemberId}" === ""){
    		alert("로그인이 필요합니다.");
    		location.href= "main";
    	}
    */
    $(function() {
	    let isFirst = true;
	 	    
	         $.ajax({
	             url: "rest_movie_list",
	             success: function (data) {
	                 let html = "";
	                 $.each(data, function (i, el) {
	                     html += `
	                               <label class="btn btn-outline-theme movie btn-booking text-left">
	                                 <input type="radio" name="movies" movieNo="\${el.movieNo}"><span class="blt blt-\${el.rating}">&nbsp; \${el.rating} &nbsp;</span>&nbsp; \${el.title}
	                               </label>
	                         `;
	                 });
	                 $("#movie-list").html(html);
	                 if (isFirst) {
	                     let movieNo;
	                     if ("${time.timeCode}" !== "") {
	                         movieNo = "${time.movie.movieNo}";
	
	                     }
	
	                     if (!movieNo) {
	                         $(".btn.movie input:first").trigger("click");
	                         return;
	                     }
	                     $(".btn.movie input[movieNo=" + movieNo + "]").trigger("click");
	
	                 }
	             }
	
	         });
	 	
	 	    $("#movie-list").on("click", ".btn.movie input", function (e) {
	 	        $("#time-list").html("");
	 	        let movieNo = $(e.target).attr("movieNo");
	 	        $.ajax({
	 	            url: "rest_movie_detail",
	 	            data: "movieNo=" + movieNo,
	 	            success: function (data) {
	 	                let date = new Date(data.openDate);
	 	                let fulldate = date.getFullYear() + "년 " + (date.getMonth() + 1) + "월 " + date.getDate() + "일";
	 	                let html = "";
	 	                html += `
	 	              			<div class="movie-info-title text-center"><strong>\${data.title}</strong></div>
	 	                        <div class="text-center"><img src="\${data.posterImage}" alt="포스터" width="200px" height="300px"></div>
	 	                        <hr>
	 	                        <div><strong>등급</strong> \${data.rating}</div>
	 	                        <div><strong>개봉일</strong> \${fulldate}</div>
	 	                        <div><strong>장르</strong> \${data.genre}</div>
	 	                        <div><strong>상영일</strong> <span id="info-date"></span></div>
	 	                        <div><strong>상영시간</strong> <span id="info-start"></span>&nbsp;<span id="info-end"></span></div>
	 	                        <hr>
	 	                    `;
	 	                $("#movie-info").html(html);
	 	
	 	            }
	 	
	 	        });
	 	
	 	        $.ajax({
	 	            url: "rest_movie_date_list",
	 	            data: "movieNo=" + movieNo,
	 	            success: function (data) {
	 	                let html = "";
	 	                let weekday=["일", "월", "화", "수", "목", "금", "토"];
	 	                $.each(data, function (i, el) {
	 	                    let date = new Date(el)
	 	                    let formatted = (date.getMonth() + 1) + "/" + date.getDate() + "("+ weekday[date.getDay()] +")"; 
	 	                    let fulldate = date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate();
	 	                    html += `
	 	                              <label class="btn btn-outline-theme date btn-booking">
	 	                                <input type="radio" name="dates" movieNo="\${movieNo}" date="\${fulldate}">\${formatted}
	 	                              </label>
	 	                        `;
	 	                });
	 	                $("#date-list").html(html);
	 	
	 	                if (isFirst) {
	 	                    let recvDate;
	 	                    let recvFullDate;
	 	                    let movieNo2;
	 	                    if ("${time.timeCode}" !== "") {
	 	                        movieNo2 = "${time.movie.movieNo}";
	 	                        recvDate = "<fmt:formatDate value='${time.movieDate}' pattern='yyyy-MM-dd'/>";
	 	
	 	                    }
	 	
	 	                    if (!recvDate) {
	 	                        $(".btn.date input:first").trigger("click");
	 	                        return;
	 	                    }
	 	                    $(".btn.date input[movieNo=" + movieNo2 + "][date=" + recvDate + "]").trigger("click");
	
	 	                }
	 	
	 	            }
	 	
	 	        });
	 	    });
	 	
	 	
	 	    $("#date-list").on("click", ".btn.date input", function (e) {
	 	    	$("#info-date").text("");
	 	    	$("#info-start").text("");
	 	    	$("#info-end").text("");
	 	    	
	 	        $.ajax({
	 	            url: "rest_movie_date_time_list",
	 	            data: "movieNo=" + $(e.target).attr("movieNo") + "&" + "movieDate=" + $(e.target).attr("date"),
	 	            success: function (data) {
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
	 	                let result = Object.entries(groups).map(([k, v]) => ({ [k]: v }));
	 	                let html = "";
	 	                result.forEach(function (el) {
	 	                    html += `<strong>\${Object.keys(el)}</strong>`;
	 	                    el[Object.keys(el)].forEach(function (el2) {
	 	                        html += `
	 	                                <label class="btn btn-outline-theme time btn-booking">
	 	                                    <input type="radio" name="options" timeCode="\${el2.timeCode}">
	 	                                    시작: <span class="time-start">\${el2.startTime}</span><br>
	 	                                    종료: <span class="time-end">\${el2.endTime}</span>
	 	                                </label>
	 	                                `;
	 	                    });
	 	                    html += `<br>`;
	 	                });
	 	
	 	
	 	                $("#time-list").html(html);
	 	
	 	
	 	                if (isFirst) {
	 	                    let timeCode;
	 	                    if ("${time.timeCode}" !== "") {
	 	                        timeCode = "${time.timeCode}";
	 	
	 	                    }
	 	
	 	                    if (!timeCode) {
	 	                        return;
	 	                    }
	 	                    $(".btn.time input[timeCode=" + timeCode + "]").trigger("click");
	 	                }
	 	                isFirst = false;
	 	
	 	            }
	 	
	 	        });
	 	    });
	 	    
	 	    $("#time-list").on("click", ".btn.time input", function (e) {
	 	    	let dateArray = $(".btn.date.active input").attr("date").split("-");
	 	    	$("#info-date").text(dateArray[0] + "년 " + dateArray[1] + "월 " + dateArray[2] + "일");
	 	    	$("#info-start").text($(e.target).parent().children(".time-start").text());
	 	    	$("#info-end").text("~ "+$(e.target).parent().children(".time-end").text());
	 	    });
	 	
	 	    $("#select-seats").click(function (e) {
	 	        let timeCode = $(".btn.time.active input").attr("timeCode");
	 	        if (!timeCode) {
	 	            alert("상영시간을 선택해주세요");
	 	            return;
	 	        }
	 	        // location.href = "booking_seat?timeCode=" + timeCode;
	 	        
	 	        document.querySelector("#booking-form").action = "booking_seat";
	 	        document.querySelector("#booking-form").method = "post";
	 	        $("#booking-form input[name=timeCode]").val(timeCode);
	 	        document.querySelector("#booking-form").submit();
	 	        
	 	    });
    });
    </script>
</body>

</html>