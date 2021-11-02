<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.lang.Math" %>    
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>	
<%@taglib prefix="s"  uri="http://www.springframework.org/tags"%>	
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <title>My Profile
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
            <h1>My Profile</h1>
          </div>
          <div class="column">
            <ul class="breadcrumbs">
              <li><a href="index.html">Home</a>
              </li>
              <li class="separator">&nbsp;</li>
              <li><a href="account-orders.html">Account</a>
              </li>
              <li class="separator">&nbsp;</li>
              <li>My Profile</li>
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
            <form id="form-account-update" class="row">
              <div class="col-md-6">
                <div class="form-group">
                  <label for="account-fn">First Name</label>
                  <input class="form-control" type="text" id="account-fn" name="account_fn" value="${loginUser.name.substring(1)}"  required>
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-group">
                  <label for="account-ln">Last Name</label>
                  <input class="form-control" type="text" id="account-ln"  name="account_ln" value="${loginUser.name.substring(0,1)}" required>
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-group">
                  <label for="account-email">E-mail Address</label>
                  <input class="form-control" type="email" id="account-email" name="account_email" value="${loginUser.email}" >
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-group">
                  <label for="account-phone">Phone Number</label>
                  <input class="form-control" type="text" id="account-phone" name="account_phone" value="+7(805) 348 95 72" required>
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-group">
                  <label for="account-pass">New Password</label>
                  <input class="form-control" type="password" id="account-pass"  name="account_pass" value="${loginUser.password}">
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-group">
                  <label for="account-confirm-pass">Confirm Password</label>
                  <input class="form-control" type="password" id="account-confirm-pass" name="account_confirm_pass"  value="${loginUser.password}">
                </div>
              </div>
              <div class="col-12">
                <hr class="mt-2 mb-3">
                <div class="d-flex flex-wrap justify-content-between align-items-center">
                  <div class="custom-control custom-checkbox d-block">
                    <input class="custom-control-input" type="checkbox" id="subscribe_me" checked>
                    <label class="custom-control-label" for="subscribe_me">Subscribe me to Newsletter</label>
                  </div>
                  <button class="btn-account-profile-update btn btn-primary margin-right-none" type="button" data-toast data-toast-position="topRight" data-toast-type="success" data-toast-icon="icon-circle-check" data-toast-title="Success!" data-toast-message="Your profile updated successfuly.">Update Profile</button>
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
    <script src="js/custom.cart.js""></script>
    <script src="js/custom.account.js"></script>

    <script type="text/javascript">
    	account_left_sidebar_select('${requestScope['javax.servlet.forward.request_uri'].substring(pageContext.request.contextPath.length()+1)}');
    	
    	$('.btn-account-profile-update').on('click',function(e){
    		var params = $('#form-account-update').serialize();
    		user_profile_modify_action_rest(params);
    	});
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    </script>
  </body>
</html>