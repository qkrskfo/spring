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
	<form id="form-payment"></form>
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
            <div class="checkout-steps"><a class="active" href="checkout-review.html">4. Review</a><a class="completed" href="checkout-payment.html"><span class="step-indicator icon-circle-check"></span><span class="angle"></span>3. Payment</a><a class="completed" href="checkout-shipping.html"><span class="step-indicator icon-circle-check"></span><span class="angle"></span>2. Shipping</a><a class="completed" href="checkout-address.html"><span class="step-indicator icon-circle-check"></span><span class="angle"></span>1. Address</a></div>
            <h4>Review Your Order</h4>
            <hr class="padding-bottom-1x">
            <div class="table-responsive shopping-cart">
              <table class="table">
                <thead>
                  <tr>
                    <th>Product Name</th>
                    <th class="text-center">Subtotal</th>
                    <th></th>
                  </tr>
                </thead>
                <tbody>
                
                <c:forEach items="${cartItemList}" var="cartItem">
                <!--CartItem start  -->
                  <tr>
                    <td>
                      <div class="product-item">
                      	<a class="product-thumb" href="shop-single?p_no=${cartItem.product.p_no}">
                      		<img src="img/shop/cart/${cartItem.product.p_image}" alt="Product">
                      	</a>
                        <div class="product-info">
                          <h4 class="product-title"><a href="shop-single?p_no=${cartItem.product.p_no}">${cartItem.product.p_name}<small>x ${cartItem.cart_qty}</small></a></h4><span><em>Size:</em> small</span><span><em>Unit Price:</em> ${cartItem.product.p_price}</span>
                        </div>
                      </div>
                    </td>
                    <td class="text-center text-lg text-medium">&#8361; <s:eval expression="new java.text.DecimalFormat('#,###.0').format(cartItem.product.p_price*cartItem.cart_qty)" /></td>
                    <td class="text-center"><a class="btn btn-outline-primary btn-sm" href="cart">Edit</a></td>
                  </tr>
               <!-- CartItem end -->
               </c:forEach>
                </tbody>
              </table>
            </div>
            <div class="shopping-cart-footer">
              <div class="column"></div>
              <div class="column text-lg">Subtotal: <span class="text-medium">&#8361; <s:eval expression="new java.text.DecimalFormat('#,###.0').format(cartTotPrice)" /></span></div>
            </div>
            <div class="row padding-top-1x mt-3">
              <div class="col-sm-6">
                <h5>Shipping to:</h5>
                <ul class="list-unstyled">
                  <li><span class="text-muted">Client:</span>${order.address.checkout_ln} ${order.address.checkout_fn}</li>
                  <li><span class="text-muted">Address:</span>${order.address.checkout_country} ${order.address.checkout_city} ${order.address.checkout_address1} ${order.address.checkout_address2}</li>
                  <li><span class="text-muted">Phone:</span>${order.address.checkout_phone}</li>
                </ul>
              </div>
              <div class="col-sm-6">
                <h5>Payment method:</h5>
                <ul class="list-unstyled">
                  <li><span class="text-muted">Credit Card:</span>${order.card.number}</li>
                </ul>
              </div>
            </div>
            <div class="checkout-footer margin-top-1x">
              <div class="column hidden-xs-down"><a class="btn btn-outline-secondary" href="checkout-payment.html"><i class="icon-arrow-left"></i>&nbsp;Back</a></div>
              <div class="column"><a class="btn-review-checkout btn btn-primary" href="checkout-complete.html">Complete Order</a></div>
            </div>
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
	    $('.btn-review-checkout').on('click',function(e){
			$('#form-payment').attr('action','checkout-complete');
			$('#form-payment').attr('method','post');
			$('#form-payment').submit();
			e.preventDefault();
		});
    </script>
  </body>
</html>