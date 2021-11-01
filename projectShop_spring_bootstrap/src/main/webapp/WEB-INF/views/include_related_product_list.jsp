<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!--  -->
<h3 class="text-center padding-top-2x mt-2 padding-bottom-1x">You
	May Also Like</h3>
<!-- Carousel-->
<div class="owl-carousel"
	data-owl-carousel="{ &quot;nav&quot;: false, &quot;dots&quot;: true, &quot;margin&quot;: 30, &quot;responsive&quot;: {&quot;0&quot;:{&quot;items&quot;:1},&quot;576&quot;:{&quot;items&quot;:2},&quot;768&quot;:{&quot;items&quot;:3},&quot;991&quot;:{&quot;items&quot;:4},&quot;1200&quot;:{&quot;items&quot;:4}} }">

	<c:forEach items="${productList}" var="product">
		<!-- Product start-->
		<div class="grid-item">
			<div class="product-card">
				<div class="product-badge text-danger"></div>
				<a class="product-thumb" href="shop-single?p_no=${product.p_no}"><img
					src="img/shop/products/${product.p_image}" alt="Product"></a>
				<h3 class="product-title">
					<a href="shop-single?p_no=${product.p_no}">${product.p_name}</a>
				</h3>
				<h4 class="product-price">
					&#8361;
					<s:eval
						expression="new java.text.DecimalFormat('#,###').format(product.p_price)" />
				</h4>
				<div class="product-buttons">
					<button class="btn btn-outline-secondary btn-sm btn-wishlist"
						data-toggle="tooltip" title="Whishlist">
						<i class="icon-heart"></i>
					</button>
					<button class="btn btn-outline-primary btn-sm add-cart-btn"
						data-toast data-toast-type="success" data-toast-position="center"
						data-toast-icon="icon-circle-check"
						data-toast-title="${product.p_name}"
						data-toast-message="successfuly added to cart!">Add to
						Cart</button>
				</div>
			</div>
		</div>
		<!-- Product end-->
	</c:forEach>
</div>
<!--  -->