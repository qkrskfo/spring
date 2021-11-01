<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>	
<%@taglib prefix="s"  uri="http://www.springframework.org/tags"%>	    
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <title>Shop Grid No Sidebar
    </title>
    <!-- SEO Meta Tags-->
    <meta name="description" content="Unishop - Universal E-Commerce Template">
    <meta name="keywords" content="shop, e-commerce, modern, flat style, responsive, online store, business, mobile, blog, bootstrap 4, html5, css3, jquery, js, gallery, slider, touch, creative, clean">
    <meta name="author" content="Rokaux">
    <!-- Mobile Specific Meta Tag-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <!-- Favicon and Apple Icons-->
    <link rel="icon" type="image/x-icon" href="favicon.ico">
    <link rel="icon" type="image/png" href="favicon.png">
    <link rel="apple-touch-icon" href="touch-icon-iphone.png">
    <link rel="apple-touch-icon" sizes="152x152" href="touch-icon-ipad.png">
    <link rel="apple-touch-icon" sizes="180x180" href="touch-icon-iphone-retina.png">
    <link rel="apple-touch-icon" sizes="167x167" href="touch-icon-ipad-retina.png">
    <!-- Vendor Styles including: Bootstrap, Font Icons, Plugins, etc.-->
    <link rel="stylesheet" media="screen" href="css/vendor.min.css">
    <!-- Main Template Styles-->
    <link id="mainStyles" rel="stylesheet" media="screen" href="css/styles.min.css">
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
      <!-- Page Title-->
      <div class="page-title">
        <div class="container">
          <div class="column">
            <h1>Shop Grid No Sidebar</h1>
          </div>
          <div class="column">
            <ul class="breadcrumbs">
              <li><a href="index.html">Home</a>
              </li>
              <li class="separator">&nbsp;</li>
              <li>Shop Grid No Sidebar</li>
            </ul>
          </div>
        </div>
      </div>
      <!-- Page Content-->
      <div class="container padding-bottom-3x mb-1">
        <!-- Shop Toolbar-->
        <div class="shop-toolbar padding-bottom-1x mb-2">
          <div class="column">
            <div class="shop-sorting">
              <label for="sorting">Sort by:</label>
              <select class="form-control" id="sorting">
                <option>Popularity</option>
                <option>Low - High Price</option>
                <option>High - Low Price</option>
                <option>Avarage Rating</option>
                <option>A - Z Order</option>
                <option>Z - A Order</option>
              </select><span class="text-muted">Showing:&nbsp;</span><span>1 - 12 items</span>
            </div>
          </div>
          <div class="column">
            <div class="shop-view"><a class="grid-view active" href="shop-grid-ns.html"><span></span><span></span><span></span></a><a class="list-view" href="shop-list-ns.html"><span></span><span></span><span></span></a></div>
          </div>
        </div>
        <!-- Products Grid-->
        <div class="isotope-grid cols-4 mb-2">
          <div class="gutter-sizer"></div>
          <div class="grid-sizer"></div>
        
          <c:forEach items="${productList}" var="product" varStatus="status">
          <!-- Product start-->
          <div class="grid-item">
            <div class="product-card">
              <div class="product-badge text-danger"></div><a class="product-thumb" href="shop-single?p_no=${product.p_no}"><img src="img/shop/products/${product.p_image}" alt="Product"></a>
              <h3 class="product-title"><a href="shop-single?p_no=${product.p_no}">${product.p_name}</a></h3>
              <h4 class="product-price">
               &#8361;<s:eval expression="new java.text.DecimalFormat('#,##0').format(product.p_price)"/>
              </h4>
              <div class="product-buttons">
                <button class="btn btn-outline-secondary btn-sm btn-wishlist" data-toggle="tooltip" title="Whishlist"><i class="icon-heart"></i></button>
                <button p-no="${product.p_no}" class="btn btn-outline-primary btn-sm btn-add-cart" data-toast data-toast-type="success" data-toast-position="topCenter" data-toast-icon="icon-circle-check" data-toast-title="${product.p_name}" data-toast-message="successfuly added to cart!">Add to Cart</button>
              </div>
            </div>
          </div>
       	  <!-- Product end-->
          </c:forEach>	 
        </div>
        <!-- Pagination-->
        <nav class="pagination">
          <div class="column">
            <ul class="pages">
              <li class="active"><a href="#">1</a></li>
              <li><a href="#">2</a></li>
              <li><a href="#">3</a></li>
              <li><a href="#">4</a></li>
              <li>...</li>
              <li><a href="#">12</a></li>
            </ul>
          </div>
          <div class="column text-right hidden-xs-down"><a class="btn btn-outline-secondary btn-sm" href="#">Next&nbsp;<i class="icon-arrow-right"></i></a></div>
        </nav>
      </div>
    <!-- Site Footer-->
    <!-- include_common_top.jsp start-->
	<jsp:include page="include_common_bottom.jsp"/>
	<!-- include_common_top.jsp end  --> 
    <!-- JavaScript (jQuery) libraries, plugins and custom scripts-->
 
    <script src="js/vendor.min.js"></script>
    <script src="js/scripts.min.js"></script>
    
    <script src="js/custom.cart.js"></script>
    <script type="text/javascript">
    $(function(){
    	/******** .btn-add-cart 이벤트처리************/
    	$('.btn-add-cart').on('click',function(e){
    		if('${sUserId}'===''){
        		alert('로그인하세요!');
        		location.href='account-login';
        		e.stopPropagation();
        	}else{
        		var params={
    						'p_no':$(e.target).attr('p-no'),
    						'cart_qty':1
    				  		};
        		cart_add_action(params);
        	}
		});
    	/***********************************************/
    	
		
		
	});
  </script>  
  </body>
</html>