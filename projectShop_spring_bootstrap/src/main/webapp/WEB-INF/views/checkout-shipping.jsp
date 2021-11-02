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
          	<form id="form-shipping">
            <div class="checkout-steps"><a href="checkout-review.html">4. Review</a><a href="checkout-payment.html"><span class="angle"></span>3. Payment</a><a class="active" href="checkout-shipping.html"><span class="angle"></span>2. Shipping</a><a class="completed" href="checkout-address.html"><span class="angle"></span><span class="step-indicator icon-circle-check"></span>1. Address</a></div>
            <h4>Choose Shipping Method</h4>
            <hr class="padding-bottom-1x">
            <div class="table-responsive">
              <table class="table table-hover">
                <thead class="thead-default">
                  <tr>
                    <th></th>
                    <th>Shipping method</th>
                    <th>Delivery time</th>
                    <th>Handling fee</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td class="align-middle">
                      <div class="custom-control custom-radio mb-0">
                        <input class="custom-control-input" type="radio" id="courier" name="shipping_method" value="courier" checked>
                        <label class="custom-control-label" for="courier"></label>
                      </div>
                    </td>
                    <td class="align-middle"><span class="text-medium">Courier</span><br><span class="text-muted text-sm">All Addresses(default zone), United States & Canada</span></td>
                    <td class="align-middle">2 - 4 days</td>
                    <td class="align-middle">$22.50</td>
                  </tr>
                  <tr>
                    <td class="align-middle">
                      <div class="custom-control custom-radio mb-0">
                        <input class="custom-control-input" type="radio" id="local" name="shipping_method" value="local">
                        <label class="custom-control-label" for="local"></label>
                      </div>
                    </td>
                    <td class="align-middle"><span class="text-medium">Local Shipping</span><br><span class="text-muted text-sm">All Addresses(default zone), United States & Canada</span></td>
                    <td class="align-middle">up to one week</td>
                    <td class="align-middle">$10.00</td>
                  </tr>
                  <tr>
                    <td class="align-middle">
                      <div class="custom-control custom-radio mb-0">
                        <input class="custom-control-input" type="radio" id="flat" name="shipping_method" value="flat">
                        <label class="custom-control-label" for="flat"></label>
                      </div>
                    </td>
                    <td class="align-middle"><span class="text-medium">Flat Rate</span><br><span class="text-muted text-sm">All Addresses(default zone)</span></td>
                    <td class="align-middle">5 - 7 days</td>
                    <td class="align-middle">$33.85</td>
                  </tr>
                  <tr>
                    <td class="align-middle">
                      <div class="custom-control custom-radio mb-0">
                        <input class="custom-control-input" type="radio" id="ups" name="shipping_method" value="ups">
                        <label class="custom-control-label" for="ups"></label>
                      </div>
                    </td>
                    <td class="align-middle"><span class="text-medium">UPS Ground Shipping</span><br><span class="text-muted text-sm">All Addresses(default zone)</span></td>
                    <td class="align-middle">4 - 6 days</td>
                    <td class="align-middle">$18.00</td>
                  </tr>
                  <tr>
                    <td class="align-middle">
                      <div class="custom-control custom-radio mb-0">
                        <input class="custom-control-input" type="radio" id="pickup" name="shipping_method" value="pickup">
                        <label class="custom-control-label" for="pickup"></label>
                      </div>
                    </td>
                    <td class="align-middle"><span class="text-medium">Local Pickup from store</span><br><span class="text-muted text-sm">All Addresses(default zone)</span></td>
                    <td class="align-middle">&mdash;</td>
                    <td class="align-middle">$0.00</td>
                  </tr>
                  <tr>
                    <td class="align-middle">
                      <div class="custom-control custom-radio mb-0">
                        <input class="custom-control-input" type="radio" id="locker" name="shipping_method" value="locker">
                        <label class="custom-control-label" for="locker"></label>
                      </div>
                    </td>
                    <td class="align-middle"><span class="text-medium">Pick Up at Unishop Locker</span><br><span class="text-muted text-sm">All Addresses(default zone), United States & Canada</span></td>
                    <td class="align-middle">&mdash;</td>
                    <td class="align-middle">$9.99</td>
                  </tr>
                  <tr>
                    <td class="align-middle">
                      <div class="custom-control custom-radio mb-0">
                        <input class="custom-control-input" type="radio" id="global" name="shipping_method" value="global">
                        <label class="custom-control-label" for="global"></label>
                      </div>
                    </td>
                    <td class="align-middle"><span class="text-medium">Unishop Global Export</span><br><span class="text-muted text-sm">All Addresses(default zone), outside United States</span></td>
                    <td class="align-middle">3 - 4 days;</td>
                    <td class="align-middle">$25.00</td>
                  </tr>
                </tbody>
              </table>
            </div>
            <div class="checkout-footer margin-top-1x">
              <div class="column"><a class="btn btn-outline-secondary" href="checkout-address.html"><i class="icon-arrow-left"></i><span class="hidden-xs-down">&nbsp;Back</span></a></div>
              <div class="column"><a class="btn-shipping-checkout btn btn-primary" href="checkout-payment.html"><span class="hidden-xs-down">Continue&nbsp;</span><i class="icon-arrow-right"></i></a></div>
            </div>
          </form>  
          </div>
          <!-- Sidebar          -->
          <div class="col-xl-3 col-lg-4">
           <!--include_checkout_left_sidebar.jsp start  -->
           <jsp:include page="include_checkout_right_sidebar.jsp"/>
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
    <script src="js/scripts.min.js"></script>
    <script type="text/javascript">
	    $('.btn-shipping-checkout').on('click',function(e){
			$('#form-shipping').attr('action','checkout-payment');
			$('#form-shipping').attr('method','post');
			$('#form-shipping').submit();
			e.preventDefault();
		});
    </script>
  </body>
</html>