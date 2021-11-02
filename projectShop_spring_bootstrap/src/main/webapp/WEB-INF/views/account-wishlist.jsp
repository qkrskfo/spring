<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.lang.Math" %>    
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>	
<%@taglib prefix="s"  uri="http://www.springframework.org/tags"%>	
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <title>My Wishlist
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
            <h1>My Wishlist</h1>
          </div>
          <div class="column">
            <ul class="breadcrumbs">
              <li><a href="index.html">Home</a>
              </li>
              <li class="separator">&nbsp;</li>
              <li><a href="account-orders.html">Account</a>
              </li>
              <li class="separator">&nbsp;</li>
              <li>My Wishlist</li>
            </ul>
          </div>
        </div>
      </div>
      <!-- Page Content-->
      <div class="container padding-bottom-3x mb-2">
        <div class="row">
          <div class="col-lg-4">
              <!-- include_account_left_sidebar.jsp  start-->
	          <jsp:include page="include_account_left_sidebar.jsp"/> 
	          <!-- include_account_left_sidebar.jsp  end  -->
          </div>
          <div class="col-lg-8">
            <div class="padding-top-2x mt-2 hidden-lg-up"></div>
            <!-- Wishlist Table-->
            <div class="table-responsive wishlist-table margin-bottom-none">
              <table class="table">
                <thead>
                  <tr>
                    <th>Product Name</th>
                    <th class="text-center"><a class="btn btn-sm btn-outline-danger" href="#">Clear Wishlist</a></th>
                  </tr>
                </thead>
                <tbody>
                 
                  <!-- wishlist start -->
                  <c:forEach items="${productList}" var="product" begin="0" end="2">
                  <tr>
                    <td>
                      <div class="product-item"><a class="product-thumb" href="shop-single?p_no={product.p_no}"><img src="img/shop/cart/${product.p_image}" alt="Product"></a>
                        <div class="product-info">
                          <h4 class="product-title"><a href="shop-single?p_no={product.p_no}">${product.p_name}</a></h4>
                          <div class="text-lg text-medium text-muted">&#8361; <s:eval expression="new java.text.DecimalFormat('#,###.0').format(product.p_price)"/></div>
                          <div>Availability:
                            <div class="d-inline text-success">In Stock</div>
                          </div>
                        </div>
                      </div>
                    </td>
                    <td class="text-center"><a class="remove-from-cart" href="#" data-toggle="tooltip" title="Remove item"><i class="icon-cross"></i></a></td>
                  </tr>
                 </c:forEach>
                <!-- wishlist end -->
                </tbody>
              </table>
            </div>
            <hr class="mb-4">
            <div class="custom-control custom-checkbox">
              <input class="custom-control-input" type="checkbox" id="inform_me" checked>
              <label class="custom-control-label" for="inform_me">Inform me when item from my wishlist is available</label>
            </div>
          </div>
        </div>
      </div>
<!-- Site Footer-->

<!-- include_common_bottom.jsp start-->
<jsp:include page="include_common_bottom.jsp"/>
<!-- include_common_bottom.jsp end  -->

<!-- JavaScript (jQuery) libraries, plugins and custom scripts-->
    <script src="js/vendor.min.js"></script>
    <script src="js/scripts.min.js"></script>
    <script src="js/custom.account.js"></script>
    <script type="text/javascript">
    	account_left_sidebar_select('${requestScope['javax.servlet.forward.request_uri'].substring(pageContext.request.contextPath.length()+1)}');
    </script>
  </body>
</html>