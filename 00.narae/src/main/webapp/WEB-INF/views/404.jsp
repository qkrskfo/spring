<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <title>Memico - Cinema Bootstrap HTML5 Template</title>
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
    </head>
    <body class="body">
        <header class="header header-horizontal header-view-pannel">
            <div class="container">
                <!-- navibar start -->
				<jsp:include page="nav.jsp"></jsp:include>
                <!-- navibar end -->
            </div>
        </header>
        <section class="after-head d-flex section-text-white position-relative">
            <div class="d-background" data-image-src="http://via.placeholder.com/1920x1080" data-parallax="scroll"></div>
            <div class="d-background bg-black-80"></div>
            <div class="top-block top-inner container">
                <div class="top-block-content">
                    <h1 class="section-title">Page not found</h1>
                    <div class="page-breadcrumbs">
                        <a class="content-link" href="main">Home</a>
                        <span class="text-theme mx-2"><i class="fas fa-chevron-right"></i></span>
                        <span>Error</span>
                    </div>
                </div>
            </div>
        </section>
        <section class="section-long">
            <div class="container">
                <div class="status-entity">
                    <div class="entity-icon">4<span class="text-theme">0</span>4</div>
                    <h4 class="entity-title">Sorry!</h4>
                    <p class="entity-text">페이지가 존재하지 않거나, 사용할 수 없는 페이지입니다.<br>
                    입력하신 주소가 정확한지 다시 한 번 확인해주세요.</p>
                    <div class="entity-actions">
                        <a class="btn btn-theme" href="main">메인으로</a>
                    </div>
                </div>
            </div>
        </section>
        <a class="scroll-top disabled" href="#"><i class="fas fa-angle-up" aria-hidden="true"></i></a>
        
        <!--footer start-->
		<jsp:include page="footer.jsp"></jsp:include>
        <!--footer end-->
        
        <!-- jQuery library -->
        <script src="./js/jquery-3.3.1.js"></script>
        <!-- Bootstrap -->
        <script src="./bootstrap/js/bootstrap.js"></script>
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
        <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAJ4Qy67ZAILavdLyYV2ZwlShd0VAqzRXA&callback=initMap"></script>
        <script async defer src="https://ia.media-imdb.com/images/G/01/imdb/plugins/rating/js/rating.js"></script>
    </body>
</html>