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
    <!-- Interactive Credit Card-->
    <link rel="stylesheet" media="screen" href="css/card.min.css">
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
          	<form id="form-payment">
            <div class="checkout-steps"><a href="checkout-review.html">4. Review</a><a class="active" href="checkout-payment.html"><span class="angle"></span>3. Payment</a><a class="completed" href="checkout-shipping.html"><span class="step-indicator icon-circle-check"></span><span class="angle"></span>2. Shipping</a><a class="completed" href="checkout-address.html"><span class="step-indicator icon-circle-check"></span><span class="angle"></span>1. Address</a></div>
            <h4>Choose Payment Method</h4>
            <hr class="padding-bottom-1x">
            <div class="accordion" id="accordion" role="tablist">
              <div class="card">
                <div class="card-header" role="tab">
                  <h6><a href="#card" data-toggle="collapse"><i class="icon-columns"></i>Pay with Credit Card</a></h6>
                </div>
                <div class="collapse show" id="card" data-parent="#accordion" role="tabpanel">
                  <div class="card-body">
                    <p>We accept following credit cards:&nbsp;<img class="d-inline-block align-middle" src="img/credit-cards.png" style="width: 120px;" alt="Cerdit Cards"></p>
                    <div class="card-wrapper"></div>
                    <form id="form-payment" class="interactive-credit-card row">
                      <div class="form-group col-sm-6">
                        <input class="form-control" type="text" name="number" placeholder="Card Number" required value="2345 6789 0123 4567">
                      </div>
                      <div class="form-group col-sm-6">
                        <input class="form-control" type="text" name="name" placeholder="Full Name" required value="KIM KYUNGHO">
                      </div>
                      <div class="form-group col-sm-3">
                        <input class="form-control" type="text" name="expiry" placeholder="MM/YY" required value="12/23">
                      </div>
                      <div class="form-group col-sm-3">
                        <input class="form-control" type="text" name="cvc" placeholder="CVC" required value="675">
                      </div>
                      <div class="col-sm-6">
                        <button class="btn btn-outline-primary btn-block margin-top-none" type="submit">Submit</button>
                      </div>
                    </form>
                  </div>
                </div>
              </div>
              <div class="card">
                <div class="card-header" role="tab">
                  <h6><a class="collapsed" href="#paypal" data-toggle="collapse"><i class="socicon-paypal"></i>Pay with PayPal</a></h6>
                </div>
                <div class="collapse" id="paypal" data-parent="#accordion" role="tabpanel">
                  <div class="card-body">
                    <p>PayPal - the safer, easier way to pay</p>
                    <form class="row" method="post">
                      <div class="col-sm-6">
                        <div class="form-group">
                          <input class="form-control" type="email" placeholder="E-mail" required>
                        </div>
                      </div>
                      <div class="col-sm-6">
                        <div class="form-group">
                          <input class="form-control" type="password" placeholder="Password" required>
                        </div>
                      </div>
                      <div class="col-12">
                        <div class="d-flex flex-wrap justify-content-between align-items-center"><a class="navi-link" href="#">Forgot password?</a>
                          <button class="btn btn-outline-primary margin-top-none" type="submit">Log In</button>
                        </div>
                      </div>
                    </form>
                  </div>
                </div>
              </div>
              <div class="card">
                <div class="card-header" role="tab">
                  <h6><a class="collapsed" href="#points" data-toggle="collapse"><i class="icon-medal"></i>Redeem Reward Points</a></h6>
                </div>
                <div class="collapse" id="points" data-parent="#accordion" role="tabpanel">
                  <div class="card-body">
                    <p>You currently have<span class="text-medium"> 290</span> Reward Points to spend.</p>
                    <div class="custom-control custom-checkbox d-block">
                      <input class="custom-control-input" type="checkbox" id="use_points">
                      <label class="custom-control-label" for="use_points">Use my Reward Points to pay for this order.</label>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="checkout-footer margin-top-1x">
              <div class="column"><a class="btn btn-outline-secondary" href="checkout-shipping.html"><i class="icon-arrow-left"></i><span class="hidden-xs-down">&nbsp;Back</span></a></div>
              <div class="column"><a class="btn-payment-checkout btn btn-primary" href="checkout-review.html"><span class="hidden-xs-down">Continue&nbsp;</span><i class="icon-arrow-right"></i></a></div>
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
      <!-- include_common_bottom.jsp start-->
	  <jsp:include page="include_common_bottom.jsp"/>
	  <!-- include_common_bottom.jsp end  -->
    <!-- JavaScript (jQuery) libraries, plugins and custom scripts-->
    <script src="js/vendor.min.js"></script>
    <script src="js/card.min.js"></script>
    <script src="js/scripts.min.js"></script>
    <script type="text/javascript">
	    $('.btn-payment-checkout').on('click',function(e){
			$('#form-payment').attr('action','checkout-review');
			$('#form-payment').attr('method','post');
			$('#form-payment').submit();
			e.preventDefault();
		});
    </script>
  </body>
</html>