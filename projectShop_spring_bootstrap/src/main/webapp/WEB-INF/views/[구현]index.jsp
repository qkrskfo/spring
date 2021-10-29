<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.lang.Math" %>    
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>	
<%@taglib prefix="s"  uri="http://www.springframework.org/tags"%>	       
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Unishop | Universal E-Commerce Template</title>
<!-- SEO Meta Tags-->
<meta name="description"
	content="Unishop - Universal E-Commerce Template">
<meta name="keywords"
	content="shop, e-commerce, modern, flat style, responsive, online store, business, mobile, blog, bootstrap 4, html5, css3, jquery, js, gallery, slider, touch, creative, clean">
<meta name="author" content="Rokaux">
<!-- Mobile Specific Meta Tag-->
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<!-- Favicon and Apple Icons-->
<link rel="icon" type="image/x-icon" href="favicon.ico">
<link rel="icon" type="image/png" href="favicon.png">
<link rel="apple-touch-icon" href="touch-icon-iphone.png">
<link rel="apple-touch-icon" sizes="152x152" href="touch-icon-ipad.png">
<link rel="apple-touch-icon" sizes="180x180"
	href="touch-icon-iphone-retina.png">
<link rel="apple-touch-icon" sizes="167x167"
	href="touch-icon-ipad-retina.png">
<!-- Vendor Styles including: Bootstrap, Font Icons, Plugins, etc.-->
<link rel="stylesheet" media="screen" href="css/vendor.min.css">
<!-- Main Template Styles-->
<link id="mainStyles" rel="stylesheet" media="screen"
	href="css/styles.min.css">
<!-- Modernizr-->
<script src="js/modernizr.min.js"></script>
</head>
<!-- Body-->
<body>
<!-- Off-Canvas Category Menu-->
<!-- include_common_top.jsp start  -->
<jsp:include page="include_common_top.jsp"/>
<!-- include_common_top.jsp end  -->
<!-- Off-Canvas Wrapper-->
    <div class="offcanvas-wrapper">
      <!-- Page Content-->
      <!-- Main Slider-->
      <section class="hero-slider" style="background-image: url(img/hero-slider/main-bg.jpg);">
        <div class="owl-carousel large-controls dots-inside" data-owl-carousel="{ &quot;nav&quot;: true, &quot;dots&quot;: true, &quot;loop&quot;: true, &quot;autoplay&quot;: true, &quot;autoplayTimeout&quot;: 7000 }">
          <c:forEach items="${productList}" var="product" varStatus="status">
          <div class="item">
            <div class="container padding-top-3x">
              <div class="row justify-content-center align-items-center">
                <div class="col-lg-5 col-md-6 padding-bottom-2x text-md-left text-center">
                  <div class="from-bottom"><img class="d-inline-block w-200 mb-4" src="img/hero-slider/${product.p_image}" alt="Converse">
                    <div class="h2 text-body text-normal mb-2 pt-1">${product.p_name}</div>
                    <div class="h2 text-body text-normal mb-4 pb-1">for only <span class="text-bold"> &#8361;<s:eval expression="new java.text.DecimalFormat('#,##0').format(product.p_price)"/></span></div>
                  </div><a class="btn btn-primary scale-up delay-1" href="shop-single?p_no=${product.p_no}">Shop Now</a>
                </div>
                <div class="col-md-6 padding-bottom-2x mb-3"><img class="d-block mx-auto" src="img/hero-slider/${product.p_image}" alt="Chuck Taylor All Star II"></div>
              </div>
            </div>
          </div>
  		</c:forEach>	
        </div>
      </section>
      <!-- Top Categories-->
      <section class="container padding-top-3x">
        <h3 class="text-center mb-30">Top Categories</h3>
        <div class="row">
        <c:forEach items="${productList}" var="product" varStatus="status" step="3">
           <!--category start  -->
          <div class="col-md-4 col-sm-6">
            <div class="card mb-30"><a class="card-img-tiles" href="shop-grid-ns">
                <div class="inner">
                  <div class="main-img"><img src="img/shop/categories/${product.p_image}" alt="Category"></div>
                  <div class="thumblist"><img src="img/shop/categories/${product.p_image}" alt="Category"><img src="img/shop/categories/${product.p_image}" alt="Category"></div>
                </div></a>
              <div class="card-body text-center">
                <h4 class="card-title">중형견</h4>
                <p class="text-muted">Starting from &#8361;<s:eval expression="new java.text.DecimalFormat('#,###').format(product.p_price)"/></p><a class="btn btn-outline-primary btn-sm" href="shop-grid-ns">View Products</a>
              </div>
            </div>
           </div>
           <!--category end -->
         </c:forEach>
        </div>
        <div class="text-center"><a class="btn btn-outline-secondary margin-top-none" href="shop-categories.html">All Categories</a></div>
      </section>
      <!-- Promo #1-->
      <section class="container-fluid padding-top-3x">
        <div class="row justify-content-center">
          <div class="col-xl-5 col-lg-6 mb-30">
            <div class="rounded bg-faded position-relative padding-top-3x padding-bottom-3x"><span class="product-badge text-danger" style="top: 24px; left: 24px;">Limited Offer</span>
              <div class="text-center">
                <h3 class="h2 text-normal mb-1">New</h3>
                <h2 class="display-2 text-bold mb-2">${productList[0].p_name}</h2>
                <h4 class="h3 text-normal mb-4">collection at discounted price!</h4>
                <div class="countdown mb-3" data-date-time="12/30/2019 12:00:00">
                  <div class="item">
                    <div class="days">00</div><span class="days_ref">Days</span>
                  </div>
                  <div class="item">
                    <div class="hours">00</div><span class="hours_ref">Hours</span>
                  </div>
                  <div class="item">
                    <div class="minutes">00</div><span class="minutes_ref">Mins</span>
                  </div>
                  <div class="item">
                    <div class="seconds">00</div><span class="seconds_ref">Secs</span>
                  </div>
                </div><br><a class="btn btn-primary margin-bottom-none" href="shop_single?p_no=${productList[0].p_no}">View Offers</a>
              </div>
            </div>
          </div>
          <div class="col-xl-5 col-lg-6 mb-30" style="min-height: 270px;">
            <div class="img-cover rounded" style="background-image: url(img/banners/${productList[0].p_image});"></div>
          </div>
        </div>
      </section>
    
      <!-- Promo #2-->
      <section class="container-fluid">
        <div class="row justify-content-center">
          <div class="col-xl-10 col-lg-12">
            <div class="fw-section rounded padding-top-4x padding-bottom-4x" style="background-image: url(img/banners/${productList[0].p_image});"><span class="overlay rounded" style="opacity: .35;"></span>
              <div class="text-center">
                <h3 class="display-4 text-normal text-white text-shadow mb-1">Old Collection</h3>
                <h2 class="display-2 text-bold text-white text-shadow">HUGE SALE!</h2>
                <h4 class="d-inline-block h2 text-normal text-white text-shadow border-default border-left-0 border-right-0 mb-4">at our stores</h4><br><a class="btn btn-primary margin-bottom-none" href="contacts.html">Locate Stores</a>
              </div>
            </div>
          </div>
        </div>
      </section>
      <!-- Featured Products Carousel-->
      <section class="container padding-top-3x padding-bottom-3x">
        <h3 class="text-center mb-30">Featured Products</h3>
        <div class="owl-carousel" data-owl-carousel="{ &quot;nav&quot;: false, &quot;dots&quot;: true, &quot;margin&quot;: 30, &quot;responsive&quot;: {&quot;0&quot;:{&quot;items&quot;:1},&quot;576&quot;:{&quot;items&quot;:2},&quot;768&quot;:{&quot;items&quot;:3},&quot;991&quot;:{&quot;items&quot;:4},&quot;1200&quot;:{&quot;items&quot;:4}} }">
 		
 		<c:forEach items="${productList}" var="product">	
          <!-- Product start-->
          <div class="grid-item">
            <div class="product-card">
                <div class="rating-stars"><i class="icon-star filled"></i><i class="icon-star filled"></i><i class="icon-star filled"></i><i class="icon-star filled"></i><i class="icon-star"></i>
                </div><a class="product-thumb" href="shop-single?p_no=${product.p_no}"><img src="img/shop/products/${product.p_image}" alt="Product"></a>
              <h3 class="product-title"><a href="shop-single?p_no=${product.p_no}">${product.p_name}</a></h3>
              <h4 class="product-price">&#8361;<s:eval expression="new java.text.DecimalFormat('#,###').format(product.p_price)"/></h4>
              <div class="product-buttons">
                <button class="btn btn-outline-secondary btn-sm btn-wishlist" data-toggle="tooltip" title="Whishlist"><i class="icon-heart"></i></button>
                <button class="btn btn-outline-primary btn-sm btn-add-cart" p-no=${product.p_no} data-toast data-toast-type="success" data-toast-position="topCenter" data-toast-icon="icon-circle-check" data-toast-title="Product" data-toast-message="successfuly added to cart!">Add to Cart</button>
              </div>
            </div>
          </div>
        <!-- Product end-->
        </c:forEach> 
        

          
        </div>
      </section>
      <!-- Product Widgets-->
      <section class="container padding-bottom-2x">
        <div class="row">
          <div class="col-md-4 col-sm-6">
            <div class="widget widget-featured-products">
              <h3 class="widget-title">Top Sellers</h3>
             <c:forEach items="${productList}" var="product" begin="0" end="2">	  
              <!-- Entry start-->
              <div class="entry">
                <div class="entry-thumb"><a href="shop-single?p_no=${product.p_no}"><img src="img/shop/widget/${product.p_image}" alt="Product"></a></div>
                <div class="entry-content">
                  <h4 class="entry-title"><a href="shop-single?p_no=${product.p_no}">${product.p_name}</a></h4><span class="entry-meta">&#8361;<s:eval expression="new java.text.DecimalFormat('#,###').format(product.p_price)"/></span>
                </div>
              </div>
              <!-- Entry end -->   
               </c:forEach>
            </div>
          </div>
          <div class="col-md-4 col-sm-6">
            <div class="widget widget-featured-products">
              <h3 class="widget-title">New Arrivals</h3>
               <!-- Entry-->
               <c:forEach items="${productList}" var="product"  begin="3" end="5">	  
               <!-- Entry start-->
             <div class="entry">
                <div class="entry-thumb"><a href="shop-single?p_no=${product.p_no}"><img src="img/shop/widget/${product.p_image}" alt="Product"></a></div>
                <div class="entry-content">
                  <h4 class="entry-title"><a href="shop-single?p_no=${product.p_no}">${product.p_name}</a></h4><span class="entry-meta">&#8361;<s:eval expression="new java.text.DecimalFormat('#,###').format(product.p_price)"/></span>
                </div>
              </div>
               <!-- Entry end -->   
               </c:forEach>
              
            </div>
          </div>
          <div class="col-md-4 col-sm-6">
            <div class="widget widget-featured-products">
              <h3 class="widget-title">Best Rated</h3>
              <!-- Entry-->
               <c:forEach items="${productList}" var="product" begin="6">	  
               <!-- Entry start-->
             <div class="entry">
                <div class="entry-thumb"><a href="shop-single?p_no=${product.p_no}"><img src="img/shop/widget/${product.p_image}" alt="Product"></a></div>
                <div class="entry-content">
                  <h4 class="entry-title"><a href="shop-single?p_no=${product.p_no}">${product.p_name}</a></h4><span class="entry-meta">&#8361;<s:eval expression="new java.text.DecimalFormat('#,###').format(product.p_price)"/></span>
                </div>
              </div>
               <!-- Entry end -->   
               </c:forEach>
      
              
            </div>
          </div>
        </div>
      </section>
      <!-- Popular Brands-->
      <section class="bg-faded padding-top-3x padding-bottom-3x">
        <div class="container">
          <h3 class="text-center mb-30 pb-2">Popular Dogs</h3>
          <div class="owl-carousel" data-owl-carousel="{ &quot;nav&quot;: false, &quot;dots&quot;: false, &quot;loop&quot;: true, &quot;autoplay&quot;: true, &quot;autoplayTimeout&quot;: 4000, &quot;responsive&quot;: {&quot;0&quot;:{&quot;items&quot;:2}, &quot;470&quot;:{&quot;items&quot;:3},&quot;630&quot;:{&quot;items&quot;:4},&quot;991&quot;:{&quot;items&quot;:5},&quot;1200&quot;:{&quot;items&quot;:6}} }">
          <c:forEach items="${productList}" var="product">
          <img class="d-block w-110 opacity-75 m-auto" src="img/brands/${product.p_image}" alt="${product.p_name}">
          </c:forEach>
          </div>
        </div>
      </section>
      <!-- Services-->
      <section class="container padding-top-3x padding-bottom-2x">
        <div class="row">
          <div class="col-md-3 col-sm-6 text-center mb-30"><img class="d-block w-90 img-thumbnail rounded-circle mx-auto mb-3" src="img/services/01.png" alt="Shipping">
            <h6>Free Worldwide Shipping</h6>
            <p class="text-muted margin-bottom-none">Free shipping for all orders over $100</p>
          </div>
          <div class="col-md-3 col-sm-6 text-center mb-30"><img class="d-block w-90 img-thumbnail rounded-circle mx-auto mb-3" src="img/services/02.png" alt="Money Back">
            <h6>Money Back Guarantee</h6>
            <p class="text-muted margin-bottom-none">We return money within 30 days</p>
          </div>
          <div class="col-md-3 col-sm-6 text-center mb-30"><img class="d-block w-90 img-thumbnail rounded-circle mx-auto mb-3" src="img/services/03.png" alt="Support">
            <h6>24/7 Customer Support</h6>
            <p class="text-muted margin-bottom-none">Friendly 24/7 customer support</p>
          </div>
          <div class="col-md-3 col-sm-6 text-center mb-30"><img class="d-block w-90 img-thumbnail rounded-circle mx-auto mb-3" src="img/services/04.png" alt="Payment">
            <h6>Secure Online Payment</h6>
            <p class="text-muted margin-bottom-none">We posess SSL / Secure Certificate</p>
          </div>
        </div>
      </section>
<!-- Site Footer-->
<!-- include_common_top.jsp start-->
<jsp:include page="include_common_bottom.jsp"/>
<!-- include_common_top.jsp end  -->
<!-- JavaScript (jQuery) libraries, plugins and custom scripts-->
    <script src="js/vendor.min.js"></script>
    <script src="js/scripts.min.js"></script>
    <script type="text/javascript">
    $(function(){
    	/*******************add cart***************************/
    	$('.btn-add-cart').on('click',function(e){
    		if('${sUserId}'===''){
    			alert('로그인하세요!');
    			location.href='account-login';
    			e.stopPropagation();
    		}else{
    			var cart_qty=1;
    			var p_no    =$(e.target).attr('p-no');
    			
    			var params={
    						'p_no':p_no,
    						'cart_qty':cart_qty
    					   };
    			$.ajax({
    				url:'cart_add_action_rest',
    				method:'POST',
    				data:params,
    				dataType:'text',
    				success:function(resultText){
    					if(resultText.trim()==='true'){
    						location.reload();
    					}else{
    						alert('add cart error!!');
    					}
    				}
    			});
    		}
    		
    	});
    	/**********************************************/
    });
    
    </script>  
  </body>
</html>     