<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700&family=Open+Sans:wght@300&display=swap" rel="stylesheet">
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
                    <h1 class="section-title">Scheduled Movie list</h1>
                    <div class="page-breadcrumbs">
                        <a class="content-link" href="#">Home</a>
                        <span class="text-theme mx-2"><i class="fas fa-chevron-right"></i></span>
                        <span>Movies</span>
                    </div>
                </div>
            </div>
        </section>
        <section class="section-long">
            <div class="container">
            
            	<c:forEach items="${scheduledMovieList}" var="list">
                <article class="movie-line-entity">
                    <div class="entity-poster" data-role="hover-wrap">
                        <div class="embed-responsive embed-responsive-poster">
                            <img class="embed-responsive-item" src="${list.posterImage}" alt="" />
                        </div>
                        <div class="d-over bg-theme-lighted collapse animated faster" data-show-class="fadeIn show" data-hide-class="fadeOut show">
                        <!-- 
                            <div class="entity-play">
                                <a class="action-icon-theme action-icon-bordered rounded-circle" href="https://www.youtube.com/watch?v=d96cjJhvlMA" data-magnific-popup="iframe">
                                    <span class="icon-content"><i class="fas fa-play"></i></span>
                                </a>
                            </div>
                        -->
                        </div>
                    </div>
                    <div class="entity-content">
                        <h4 class="entity-title">
                            <a class="content-link" href="movie-info-sidebar-right.html">${list.title}</a>
                        </h4>
                        <div class="entity-category">
                            <a class="content-link" href="">${list.genre}</a>
                        </div>
                        <div class="entity-info">
                            <div class="info-lines">
                                <div class="info info-short">
                                    <span class="text-theme info-icon"><i class="fas fa-calendar-alt"></i></span>
                                    <span class="info-text"><fmt:formatDate value="${list.openDate}" pattern="yyyy-MM-dd"/></span>
                                </div>
                                <div class="info info-short">
                                    <span class="text-theme info-icon"><i class="fas fa-clock"></i></span>
                                    <span class="info-text">${list.runningtime}</span>
                                </div>
                            </div>
                        </div>
                        <p class="text-short entity-text">${list.summary}</p>
                    </div>
                    <div class="entity-extra">
                        <div class="text-uppercase entity-extra-title">Comming soon</div>
                        <div></div>
                    </div>
                </article>
                </c:forEach>
                
                <div class="section-bottom">
                    <div class="paginator">
                        <a class="paginator-item" href="#"><i class="fas fa-chevron-left"></i></a>
                        <span class="active paginator-item">1</span>
                        <a class="paginator-item" href="#"><i class="fas fa-chevron-right"></i></a>
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