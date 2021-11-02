<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.lang.Math" %>    
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>	
<%@taglib prefix="s"  uri="http://www.springframework.org/tags"%>	
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <title>Contact / Shipping Address
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
            <h1>Contact / Shipping Address</h1>
          </div>
          <div class="column">
            <ul class="breadcrumbs">
              <li><a href="index.html">Home</a>
              </li>
              <li class="separator">&nbsp;</li>
              <li><a href="account-orders.html">Account</a>
              </li>
              <li class="separator">&nbsp;</li>
              <li>Contact Address</li>
            </ul>
          </div>
        </div>
      </div>
      <!-- Page Content-->
      <div class="container padding-bottom-3x mb-1">
        <div class="row">
          <div class="col-lg-4">
           	<!-- include_account_left_sidebar.jsp  start-->
       		<jsp:include page="include_account_left_sidebar.jsp"/> 
       		<!-- include_account_left_sidebar.jsp  end  -->
          </div>
          <div class="col-lg-8">
            <div class="padding-top-2x mt-2 hidden-lg-up"></div>
            <h4>Contact Address</h4>
            <hr class="padding-bottom-1x">
            <form class="row">
              <div class="col-md-6">
                <div class="form-group">
                  <label for="account-company">Company</label>
                  <input class="form-control" type="text" id="account-company" value="ITWILL">
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-group">
                  <label for="account-country">Country</label>
                  <select class="form-control" id="account-country">
                    <option>Choose country</option>
                    <option selected>Korea</option>
                    <option>Australia</option>
                    <option>Canada</option>
                    <option>France</option>
                    <option>Germany</option>
                    <option>Switzerland</option>
                    <option >United States</option>
                  </select>
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-group">
                  <label for="account-city">City</label>
                  <select class="form-control" id="account-city">
                    <option>Choose city</option>
                    <option selected>Seoul</option>
                    <option>Amsterdam</option>
                    <option>Berlin</option>
                    <option>Geneve</option>
                    <option>New York</option>
                    <option>Paris</option>
                  </select>
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-group">
                  <label for="account-zip">ZIP Code</label>
                  <input class="form-control" type="text" id="account-zip" value="345-890" required>
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-group">
                  <label for="account-address1">Address 1</label>
                  <input class="form-control" type="text" id="account-address1" required value="관악구">
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-group">
                  <label for="account-address2">Address 2</label>
                  <input class="form-control" type="text" id="account-address2" value="관악 푸르지오">
                </div>
              </div>
              <div class="col-12 padding-top-1x">
                <h4>Shipping Address</h4>
                <hr class="padding-bottom-1x">
                <div class="custom-control custom-checkbox d-block">
                  <input class="custom-control-input" type="checkbox" id="same_address" checked>
                  <label class="custom-control-label" for="same_address">Same as Contact Address</label>
                </div>
                <hr class="margin-top-1x margin-bottom-1x">
                <div class="text-right">
                  <button class="btn btn-primary margin-bottom-none" type="button" data-toast data-toast-position="topRight" data-toast-type="success" data-toast-icon="icon-circle-check" data-toast-title="Success!" data-toast-message="Your address updated successfuly.">Update Address</button>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>

<!-- Site Footer-->

<!-- include_common_top.jsp start-->
<jsp:include page="include_common_bottom.jsp"/>
<!-- include_common_top.jsp end  -->

<!-- JavaScript (jQuery) libraries, plugins and custom scripts-->
    <script src="js/vendor.min.js"></script>
    <script src="js/scripts.min.js"></script>
    <script src="js/custom.account.js"></script>
    <script type="text/javascript">
    	account_left_sidebar_select('${requestScope['javax.servlet.forward.request_uri'].substring(pageContext.request.contextPath.length()+1)}');
    </script>
  </body>
</html>