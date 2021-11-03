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
	<body class="body">
        <header class="header header-horizontal header-view-pannel">
            <div class="container">
                <!-- navibar start -->
				<jsp:include page="nav.jsp"></jsp:include>
                <!-- navibar end -->
            </div>
        </header>
	<body class="snippet-body">
 <div class="container mt-5 mb-5">
    <div class="row d-flex justify-content-center">
        <div class="col-md-8">
            <div class="card">
                <div class="upper p-4">
                    <div class="d-flex justify-content-between">
                        <!--  <div> <span class="text-primary font-weight-bold">예약번호 ${ticket.ticketNo}</span>-->
                        <div> <span style="color:#ff8a00; font-weight:bold" >예매번호 ${ticket.ticketNo}</span>
                          <div><span style="color:grey">예매 영화  ${ticket.time.movie.title}</span></div>
                          <div><span style="color:grey">관람 일시  <fmt:formatDate value="${ticket.time.movieDate}" pattern="yyyy-MM-dd" /></span></div>
                        </div>
                    </div>
                    <hr>
                    <div class="delivery">
                        <div class="d-flex justify-content-between">
                            <div class="d-flex flex-row align-items-center"> <i class="fa fa-check-circle-o"></i> <span class="ml-2">상영관 </span> </div> <span class="font-weight-bold">${ticket.time.screen.screenNo}관</span>
                        </div>
                    </div>
                    <div class="transaction mt-2">
                        <div class="d-flex justify-content-between">
                            <div class="d-flex flex-row align-items-center"> <i class="fa fa-check-circle-o"></i> <span class="ml-2">시작 시간</span> </div> <span class="font-weight-bold"> ${ticket.time.startTime}</span>
                        </div>
                    </div>
                    <div class="transaction mt-2">
                        <div class="d-flex justify-content-between">
                            <div class="d-flex flex-row align-items-center"> <i class="fa fa-check-circle-o"></i> <span class="ml-2">종료 시간</span> </div> <span class="font-weight-bold">${ticket.time.endTime}</span>
                        </div>
                    </div>
                    <hr>
                    <div class="transaction mt-2">
                        <div class="d-flex justify-content-between">
                            <div class="d-flex flex-row align-items-center"> <i class="fa fa-check-circle-o"></i> <span class="ml-2">좌석</span> </div> <span class="font-weight-bold">
                            <c:forEach items="${ticket.bookedSeatList}" var="bookedSeat">${bookedSeat.seat.seatCode}</c:forEach></span>
                        </div>
                    </div>
                    <div class="transaction mt-2">
                        <div class="d-flex justify-content-between">
                            <div class="d-flex flex-row align-items-center"> <i class="fa fa-check-circle-o"></i> <span class="ml-2">예매 일시</span> </div> <span class="font-weight-bold"><fmt:formatDate value="${ticket.orderDate}" pattern="yyyy-MM-dd HH:mm:ss" /></span>
                        </div>
                    </div>
                    <div class="transaction mt-2">
                        <div class="d-flex justify-content-between">
                            <div class="d-flex flex-row align-items-center"> <i class="fa fa-check-circle-o"></i> <span class="ml-2">예약 상태</span> </div> <span class="font-weight-bold">${ticket.ticketStatus eq 0 ? '예약 취소' : '예약 완료'} </span>
                        </div>
                    </div>
                </div>  
                <!-- lower p-4 py-5 text-white d-flex justify-content-between" style="background-color:orange;" -->
                <div class="lower p-4 py-5 text-white d-flex justify-content-between" style="background-color:#ff8a00;" >
                    <div class="d-flex flex-column"> <span>총 결제 금액</span></div>
                    <h3>${ticket.payCost}원</h3>
                </div>
            </div>
        </div>
    </div>
    </div>
 <script type='text/javascript' src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js'></script>
 <script type='text/javascript'></script>
	 <!--footer start-->
		<jsp:include page="footer.jsp"></jsp:include>
    <!--footer end-->
</body>
</html>