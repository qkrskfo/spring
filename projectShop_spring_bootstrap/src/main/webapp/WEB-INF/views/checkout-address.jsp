<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.lang.Math" %>    
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>	
<%@taglib prefix="s"  uri="http://www.springframework.org/tags"%>	
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Checkout
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
            <h1>Checkout</h1>
          </div>
          <div class="column">
            <ul class="breadcrumbs">
              <li><a href="index.html">Home</a>
              </li>
              <li class="separator">&nbsp;</li>
              <li>Checkout</li>
            </ul>
          </div>
        </div>
      </div>
      <!-- Page Content-->
      <div class="container padding-bottom-3x mb-2">
        <div class="row">
          <!-- Checkout Adress-->
         
          <div class="col-xl-9 col-lg-8">
          <form id="form-address">
            <div class="checkout-steps"><a href="checkout-review.html">4. Review</a><a href="checkout-payment.html"><span class="angle"></span>3. Payment</a><a href="checkout-shipping.html"><span class="angle"></span>2. Shipping</a><a class="active" href="checkout-address.html"><span class="angle"></span>1. Address</a></div>
            <h4>Billing Address</h4>
            <hr class="padding-bottom-1x">
            <div class="row">
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="checkout-fn">First Name</label>
                  <input class="form-control" type="text" id="checkout-fn" name="checkout_fn" value="${loginUser.name.substring(1)}">
                </div>
              </div>
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="checkout-ln">Last Name</label>
                  <input class="form-control" type="text" id="checkout-ln" name="checkout_ln" value="${loginUser.name.substring(0,1)}">
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="checkout-email">E-mail Address</label>
                  <input class="form-control" type="email" id="checkout-email" name="checkout_email" value="${loginUser.email}">
                </div>
              </div>
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="checkout-phone">Phone Number</label>
                  <input class="form-control" type="text" id="checkout-phone"  name="checkout_phone" value="234-5678">
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="checkout-company">Company</label>
                  <input class="form-control" type="text" id="checkout-company"  name="checkout_company" value="ITWILL">
                </div>
              </div>
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="checkout-country">Country</label>
                  <select class="form-control" id="checkout-country" name="checkout_country">
                    <option>Choose country</option>
                    <option selected="selected">Korea</option>
                    <option>Australia</option>
                    <option>Canada</option>
                    <option>France</option>
                    <option>Germany</option>
                    <option>Switzerland</option>
                    <option>USA</option>
                  </select>
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="checkout-city">City</label>
                  <select class="form-control" id="checkout-city" name="checkout_city">
                    <option>Choose city</option>
                    <option selected="selected">Seoul</option>
                    <option>Amsterdam</option>
                    <option>Berlin</option>
                    <option>Geneve</option>
                    <option>New York</option>
                    <option>Paris</option>
                  </select>
                </div>
              </div>
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="checkout-zip">ZIP Code</label>
                  <input class="form-control" type="text" id="checkout-zip" name="checkout_zip" value="123">
                </div>
              </div>
            </div>
            <div class="row padding-bottom-1x">
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="checkout-address1">Address 1</label>
                  <input class="form-control" type="text" id="checkout-address1" name="checkout_address1" value="관악">
                </div>
              </div>
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="checkout-address2">Address 2</label>
                  <input class="form-control" type="text" id="checkout-address2" name="checkout_address2" value="푸르지오 아파트">
                </div>
              </div>
            </div>
            <h4>Shipping Address</h4>
            <hr class="padding-bottom-1x">
            <div class="form-group">
              <div class="custom-control custom-checkbox">
                <input class="custom-control-input" type="checkbox" id="same_address" checked>
                <label class="custom-control-label" for="same_address">Same as billing address</label>
              </div>
            </div>
            <div class="checkout-footer">
              <div class="column"><a class="btn btn-outline-secondary" href="cart.html"><i class="icon-arrow-left"></i><span class="hidden-xs-down">&nbsp;Back To Cart</span></a></div>
              <div class="column"><a class="btn-address-checkout btn btn-primary" href="checkout-shipping.html"><span class="hidden-xs-down">Continue&nbsp;</span><i class="icon-arrow-right"></i></a></div>
            </div>
            </form>
          </div>
         
          
          <!-- Sidebar          -->
          <div class="col-xl-3 col-lg-4">
           <!--include_checkout_left_sidebar.jsp start  -->
           <jsp:include page="include_checkout_left_sidebar.jsp"/>
           <!--include_checkout_left_sidebar.jsp end    -->
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
    <script type="text/javascript">
		$('.btn-address-checkout').on('click',function(e){
			
			$('#form-address').attr('action','checkout-shipping');
			$('#form-address').attr('method','post');
			$('#form-address').submit();
			
			e.preventDefault();
		});

    </script>
  </body>
</html>