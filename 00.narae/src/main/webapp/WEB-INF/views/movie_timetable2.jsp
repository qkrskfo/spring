<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <title>Little Cinema</title>
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <!-- Bootstrap -->
        <link href="./bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />
        <!-- Animate.css -->
        <link href="./animate.css/animate.css" rel="stylesheet" type="text/css" />
        <!-- Font Awesome iconic font -->
        <link href="./fontawesome/css/fontawesome-all.css" rel="stylesheet" type="text/css" />
        <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
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
		<style>
		.timeBox {
			  display: table-cell;
			  vertical-align: middle;
			  padding:10px 10px 0 0;
			}

		</style>
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
                    <h1 class="section-title">Timetable</h1>
                    <div class="page-breadcrumbs">
                        <a class="content-link" href="#">Home</a>
                        <span class="text-theme mx-2"><i class="fas fa-chevron-right"></i></span>
                        <a class="content-link" href="movies-blocks.html">Movies</a>
                    </div>
                </div>
            </div>
        </section>
        <div class="container">
            <div class="sidebar-container">
                <div class="content">
					<section class="section-long">

                        <!-- timetable section -->
                        <div class="section-line">
                            <div class="section-head">
                                <h2 class="section-title text-uppercase">Timetable</h2>
                            </div>
                            
                            <div class="comment-entity">
                                <div class="entity-inner">
                                    <div class="entity-content">
                                        
                                        <div class="text-uppercase entity-extra-title">Date</div>
				                        <div class="entity-showtime">
				                            <div class="showtime-wrap">
				                            	<c:forEach items="${dateList}" var="date">
					                                <div class="showtime-item">
					                                    <a class="btn-time btn ScreeningDate" aria-disabled="false" href="#" date="${date}">
					                                    	<fmt:formatDate value="${date}" pattern="MM/dd(E)"/>
					                                    </a>
					                                </div>
												</c:forEach>
												<br><br>
				                            </div>
				                        </div>     
                                        
                                    </div>
                                    <div class="entity-extra">
                                    	<div class="text-uppercase entity-extra-title">Showtime</div>
				                        <div class="entity-showtime">
				                            <div class="timeBox" id="timeTableDiv">
				                                
				                            </div>
				                        </div>
                                    </div>
                                </div>
                                
                            </div>
                            
                        </div>
                         <!-- timetable section 끝 -->
                         
					</section>
                </div>
                <div class="sidebar section-long order-lg-last">
                    <section class="section-sidebar">
                        <div class="section-head">
                            <h2 class="section-title text-uppercase">Latest movies</h2>
                        </div>
                        <div class="movie-short-line-entity">
                            <a class="entity-preview" href="movie-info-sidebar-right.html">
                                <span class="embed-responsive embed-responsive-16by9">
                                    <img class="embed-responsive-item" src="http://via.placeholder.com/1920x1080" alt="" />
                                </span>
                            </a>
                            <div class="entity-content">
                                <h4 class="entity-title">
                                    <a class="content-link" href="movie-info-sidebar-right.html">Deadman skull</a>
                                </h4>
                                <p class="entity-subtext">11 nov 2018</p>
                            </div>
                        </div>
                        <div class="movie-short-line-entity">
                            <a class="entity-preview" href="movie-info-sidebar-right.html">
                                <span class="embed-responsive embed-responsive-16by9">
                                    <img class="embed-responsive-item" src="http://via.placeholder.com/1920x1080" alt="" />
                                </span>
                            </a>
                            <div class="entity-content">
                                <h4 class="entity-title">
                                    <a class="content-link" href="movie-info-sidebar-right.html">Dream forest</a>
                                </h4>
                                <p class="entity-subtext">29 oct 2018</p>
                            </div>
                        </div>
                        <div class="movie-short-line-entity">
                            <a class="entity-preview" href="movie-info-sidebar-right.html">
                                <span class="embed-responsive embed-responsive-16by9">
                                    <img class="embed-responsive-item" src="http://via.placeholder.com/1920x1080" alt="" />
                                </span>
                            </a>
                            <div class="entity-content">
                                <h4 class="entity-title">
                                    <a class="content-link" href="movie-info-sidebar-right.html">Fall</a>
                                </h4>
                                <p class="entity-subtext">29 oct 2018</p>
                            </div>
                        </div>
                    </section>
                    <section class="section-sidebar">
                        <div class="section-head">
                            <h2 class="section-title text-uppercase">Archive</h2>
                        </div>
                        <ul class="list-unstyled list-wider list-categories">
                            <li>
                                <a class="content-link text-uppercase" href="#">July 2018</a>
                            </li>
                            <li>
                                <a class="content-link text-uppercase" href="#">June 2018</a>
                            </li>
                            <li>
                                <a class="content-link text-uppercase" href="#">May 2018</a>
                            </li>
                            <li>
                                <a class="content-link text-uppercase" href="#">April 2018</a>
                            </li>
                        </ul>
                    </section>
                    <section class="section-sidebar">
                        <a class="d-block" href="#">
                            <img class="w-100" src="http://via.placeholder.com/350x197" alt="" />
                        </a>
                    </section>
                </div>
            </div>
        </div>
        <a class="scroll-top disabled" href="#"><i class="fas fa-angle-up" aria-hidden="true"></i></a>
        
        <!--footer start-->
		<jsp:include page="footer.jsp"></jsp:include>
        <!--footer end-->
        
        
        <script>
        $(function(){
        	$('.ScreeningDate').on('click', function(e) {
        		$(".ScreeningDate").css('background', '#aaa');
        		$(e.target).css('background', '#ff8a00');
        		$.ajax({
        			url: "timetable_detail_rest",
        			method: "GET",
        			data: "movieDate="+$(e.target).attr("date"),
        			
        			success: function(data) {
        				let html='';
        					$.each(data, function(i, movie) {
        						if(movie.dateTimeTable.length>0) {
        							html+=`<hr> 
        									<div class="showtime-item">
        										
	    	                                    	<img class="embed-responsive-item" src="\${movie.posterImage}" alt="" width=100 height=100/>
        											<p>\${movie.title}(\${movie.rating})</p>
        										
        									`;
        							$.each(movie.dateTimeTable, function(i, time) {
        								html += `
        									<div class="timeBox">
      												<a class="btn-time btn" aria-disabled="false" href="#" timeCode="\${time.timeCode}">
	       												\${time.screen.screenName}
	       		                               			<hr>
	       		                               			\${time.startTime} <br><br>
	       		                               			<p style="font-size:10px">잔여석 \${96 - time.bookedCount}석</p>
       												</a>	
	        								</div>			
        										`;
        							});		
        							html+=`</div>`;	
        						}	//if문
        					});
        					
        					
        					
        					
        				$('#timeTableDiv').html(html);
        			}
        		});
        		e.preventDefault();
        	});
        	
        	$('.ScreeningDate:first').trigger('click');
        });
        
        $('#timeTableDiv').on('click', 'a', function(e){
    		window.location.href = "booking?timeCode=" + $(e.target).attr('timeCode');
    	});

        </script>
        
        
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
        <!-- 구글맵 주석처리 <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAJ4Qy67ZAILavdLyYV2ZwlShd0VAqzRXA&callback=initMap"></script>  -->
        <script async defer src="https://ia.media-imdb.com/images/G/01/imdb/plugins/rating/js/rating.js"></script>
        
    </body>
</html>
