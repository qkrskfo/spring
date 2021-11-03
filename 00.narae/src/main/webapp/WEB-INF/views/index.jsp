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
        <section class="section-text-white position-relative">
            <div class="d-background" data-image-src="http://via.placeholder.com/1920x1080" data-parallax="scroll"></div>
            <div class="d-background bg-theme-blacked"></div>
            <div class="mt-auto container position-relative">
                <div class="top-block-head text-uppercase">
                    <h2 class="display-4">Now
                        <span class="text-theme">in cinema</span>
                    </h2>
                </div>
                <div class="top-block-footer">
                    <div class="slick-spaced slick-carousel" data-slick-view="navigation responsive-4">
                        <div class="slick-slides">
                            <!-- slide content start -->
                        <c:forEach items="${movieList }" var="movie">
                            <div class="slick-slide">
                                <article class="poster-entity" data-role="hover-wrap" movieNo="${movie.movieNo }">
                                    <div class="embed-responsive embed-responsive-poster">
                                        <img class="embed-responsive-item" src="${movie.posterImage }" alt="" />
                                    </div>
                                    <div class="d-background bg-theme-lighted collapse animated faster" data-show-class="fadeIn show" data-hide-class="fadeOut show"></div>
                                    <div class="movie-poster d-over bg-highlight-bottom" style="cursor: pointer;">
                                        <h4 class="entity-title">
                                            <a class="content-link" href="movie-info?movieNo=${movie.movieNo }">${movie.title }</a>
                                        </h4>
                                        <div class="entity-category">
                                        	
                                            <a class="content-link" href="#">${movie.genre }</a>
                                        <!-- 
                                            <a class="content-link" href="movies-blocks.html">comedy</a>
                                         -->
                                        </div>
                                        <div class="entity-info">
                                            <div class="info-lines">
                                                <div class="info info-short">
                                                    <span class="text-theme info-icon"><i class="fas fa-star"></i></span>
                                                    <span class="info-text avg">평점</span>
                                                    <span class="info-rest">/ 5</span>
                                                </div>
                                                <div class="info info-short">
                                                    <span class="text-theme info-icon"><i class="fas fa-clock"></i></span>
                                                    <span class="info-text">${movie.runningtime }</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </article>
                            </div>
                        </c:forEach>
                            <!-- slide content end -->

                        </div>
                        <div class="slick-arrows">
                            <div class="slick-arrow-prev">
                                <span class="th-dots th-arrow-left th-dots-animated">
                                    <span></span>
                                    <span></span>
                                    <span></span>
                                </span>
                            </div>
                            <div class="slick-arrow-next">
                                <span class="th-dots th-arrow-right th-dots-animated">
                                    <span></span>
                                    <span></span>
                                    <span></span>
                                </span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        
        <section class="section-long">
            <div class="container">
                <div class="section-head">
                    <h2 class="section-title text-uppercase">Now in play</h2>
                    <p class="section-text">Dates: <fmt:formatDate value="${firstDate }" pattern="MM월 dd일"/> - <fmt:formatDate value="${lastDate }" pattern="MM월 dd일"/></p>
                </div>
                
                <!-- movie-line-entity start -->
                <c:forEach items="${movieList }" var="movie">
                <article class="movie-line-entity playing" movieNo="${movie.movieNo }">
                    <div class="movie-poster entity-poster" data-role="hover-wrap" style="cursor: pointer;">
                        <div class="embed-responsive embed-responsive-poster">
                            <img class="embed-responsive-item" src="${movie.posterImage }" alt="" />
                        </div>
                        <div class="d-over bg-theme-lighted collapse animated faster" data-show-class="fadeIn show" data-hide-class="fadeOut show">
                        </div>
                    </div>
                    <div class="entity-content">
                        <h4 class="entity-title">
                            <a class="content-link" href="movie-info?movieNo=${movie.movieNo }">${movie.title }</a>
                        </h4>
                        <div class="entity-category">
                        	${movie.genre }
                        </div>
                        <div class="entity-info">
                            <div class="info-lines">
                                <div class="info info-short">
                                    <span class="text-theme info-icon"><i class="fas fa-star"></i></span>
                                    <span class="info-text avg">평점</span>
                                    <span class="info-rest">/ 5</span>
                                </div>
                                <div class="info info-short">
                                    <span class="text-theme info-icon"><i class="fas fa-clock"></i></span>
                                    <span class="info-text">${movie.runningtime }</span>
                                </div>
                            </div>
                        </div>
                        <p class="text-short entity-text">
                       	${movie.summary }
                        </p>
                    </div>
                    <div class="entity-extra">
                        <div class="text-uppercase entity-extra-title">Showtime</div>
                        <div class="entity-showtime">
                            <div class="showtime-wrap">
                                <div class="showtime-item">
                                    <span class="disabled btn-time btn" aria-disabled="true">11 : 30</span>
                                </div>
                                <div class="showtime-item">
                                    <a class="btn-time btn" aria-disabled="false" href="#">13 : 25</a>
                                </div>
                                <div class="showtime-item">
                                    <a class="btn-time btn" aria-disabled="false" href="#">16 : 07</a>
                                </div>
                                <div class="showtime-item">
                                    <a class="btn-time btn" aria-disabled="false" href="#">19 : 45</a>
                                </div>
                                <div class="showtime-item">
                                    <a class="btn-time btn" aria-disabled="false" href="#">21 : 30</a>
                                </div>
                                <div class="showtime-item">
                                    <a class="btn-time btn" aria-disabled="false" href="#">23 : 10</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </article>
                </c:forEach>
                <!-- movie-line-entity end -->
            </div>
        </section>

        
        <section class="section-solid-long section-text-white position-relative">
           	<div class="d-background" data-image-src="https://filmchatting.files.wordpress.com/2017/05/cinema-22.jpg" data-parallax="scroll"></div>
            <div class="d-background bg-gradient-black"></div>
            <div class="container position-relative">
                <div class="section-head">
                    <h2 class="section-title text-uppercase">Scheduled Movies</h2>
                </div>
                <div class="slick-spaced slick-carousel" data-slick-view="navigation single">
                    <div class="slick-slides">
                    	<c:forEach items="${scheduledMovieList}" var="list">
                        <div class="slick-slide">
                            <article class="movie-line-entity" movieNo="${list.movieNo}">
                                <div class="entity-preview">
                                    <div class="embed-responsive embed-responsive-16by9">
                                        <img class="embed-responsive-item" src="${list.posterImage}" alt="" />
                                    </div>
                                    <div class="d-over">
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
                                        <a class="content-link" href="scheduled-movie-info?movieNo=${list.movieNo}">${list.title}</a>
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
                            </article>
                        </div>
                        </c:forEach>
                    </div>
                    
                    
                    <div class="slick-arrows">
                        <div class="slick-arrow-prev">
                            <span class="th-dots th-arrow-left th-dots-animated">
                                <span></span>
                                <span></span>
                                <span></span>
                            </span>
                        </div>
                        <div class="slick-arrow-next">
                            <span class="th-dots th-arrow-right th-dots-animated">
                                <span></span>
                                <span></span>
                                <span></span>
                            </span>
                        </div>
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
        <!-- custom script -->
        <script>
        		 
     		let calcAvg = function (entity) {
         		$(entity).each(function(i, element) {
 					$.ajax({
 						url: "rest_avg",
 						data: "movieNo=" + $(element).attr("movieNo"),
 						success: function(result) {
 							$(entity +"[movieNo="+ $(element).attr("movieNo") +"] .info.info-short .info-text.avg").text(result);
 						}
 					});
 				});
     		}
     		
     		calcAvg("article.poster-entity");
     		calcAvg("article.movie-line-entity.playing");
     		
     		$(".movie-poster").click(function(e) {
				location.href="movie-info?movieNo=" + $(e.target).parents("article").attr("movieNo");
			});


        </script>
    </body>
</html>