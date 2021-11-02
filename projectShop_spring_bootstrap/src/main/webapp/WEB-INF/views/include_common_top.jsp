<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!-- Off-Canvas Wrapper-->
<!-- Off-Canvas Mobile Menu-->
<div class="offcanvas-container" id="mobile-menu">
	<a class="account-link" href="account-orders">
		<div class="user-ava">
			<img src="img/account/user-ava-md.jpg" alt="Daniel Adams">
		</div>
		<div class="user-info">
			<h6 class="user-name">Daniel Adams</h6>
			<span class="text-sm text-white opacity-60">290 Reward points</span>
		</div>
	</a>
	<nav class="offcanvas-menu">
		<ul class="menu">
			<li class="has-children active"><span><a
					href="index"><span>Home</span></a><span
					class="sub-menu-toggle"></span></span>
				<ul class="offcanvas-submenu">
					<li class="active"><a href="index">Featured Products
							Slider</a></li>
					<li><a href="home-featured-categories.html">Featured
							Categories</a></li>
					<li><a href="home-collection-showcase.html">Products
							Collection Showcase</a></li>
					
				</ul></li>
			<li class="has-children"><span><a href="shop-grid-ns"><span>Shop</span></a><span
					class="sub-menu-toggle"></span></span>
				<ul class="offcanvas-submenu">
					<li><a href="shop-categories">Shop Categories</a></li>
					<li><a href="shop-single">Single Product</a></li>
					<li><a href="cart">Cart</a></li>
					<li><a href="checkout">Checkout</a></li>
				</ul></li>
			
			<li class="has-children"><span><a
					href="account-orders"><span>Account</span></a><span
					class="sub-menu-toggle"></span></span>
				<ul class="offcanvas-submenu">
					<li><a href="account-login">Login / Register</a></li>
					<li><a href="account-password-recovery">Password
							Recovery</a></li>
					<li><a href="account-orders">Orders List</a></li>
					<li><a href="account-wishlist">Wishlist</a></li>
					<li><a href="account-profile">Profile Page</a></li>
					<li><a href="account-address">Contact / Shipping
							Address</a></li>
					
				</ul></li>
			
			<li class="has-children"><span><a href="#"><span>Pages</span></a><span
					class="sub-menu-toggle"></span></span>
				<ul class="offcanvas-submenu">
					<li><a href="about.html">About Us</a></li>
					<li><a href="mobile-app.html">Unishop Mobile App</a></li>
					<li><a href="services.html">Services</a></li>
					<li><a href="contacts.html">Contacts</a></li>
					<li><a href="faq.html">Help / FAQ</a></li>
					<li><a href="order-tracking.html">Order Tracking</a></li>
					<li><a href="search-results.html">Search Results</a></li>
					<li><a href="404.html">404</a></li>
					<li><a href="coming-soon.html">Coming Soon</a></li>
				</ul>
			</li>
	
		</ul>
	</nav>

</div>
<!-- Topbar-->
<div class="topbar">
	<div class="topbar-column">
		<a class="hidden-md-down" href="mailto:support@unishop.com"><i
			class="icon-mail"></i>&nbsp; support@unishop.com</a><a
			class="hidden-md-down" href="tel:00331697720"><i
			class="icon-bell"></i>&nbsp; 00 33 169 7720</a><a
			class="social-button sb-facebook shape-none sb-dark" href="#"
			target="_blank"><i class="socicon-facebook"></i></a><a
			class="social-button sb-twitter shape-none sb-dark" href="#"
			target="_blank"><i class="socicon-twitter"></i></a><a
			class="social-button sb-instagram shape-none sb-dark" href="#"
			target="_blank"><i class="socicon-instagram"></i></a><a
			class="social-button sb-pinterest shape-none sb-dark" href="#"
			target="_blank"><i class="socicon-pinterest"></i></a>
	</div>
	<div class="topbar-column">
		<a class="hidden-md-down" href="#"><i class="icon-download"></i>&nbsp;
			Get mobile app</a>
		<div class="lang-currency-switcher-wrap">
			<div class="lang-currency-switcher dropdown-toggle">
				<span class="language"><img alt="Korea"
					src="img/flags/KR.png"></span><span class="currency">&#8361;
					WON</span>
			</div>
			<div class="dropdown-menu">
				<div class="currency-select">
					<select class="form-control form-control-rounded form-control-sm">
						<option value="usd">￦ WON</option>
						<option value="usd">$ USD</option>
						<option value="usd">€ EUR</option>
						<option value="usd">£ UKP</option>
						<option value="usd">¥ JPY</option>
					</select>
				</div>
				<a class="dropdown-item" href="#"> <img src="img/flags/KR.png"
					alt="대한민국">대한민국
				</a> <a class="dropdown-item" href="#"> <img src="img/flags/DE.png"
					alt="Deutsch">Deutsch
				</a><a class="dropdown-item" href="#"> <img src="img/flags/IT.png"
					alt="Italiano">Italiano
				</a>
			</div>
		</div>
	</div>
</div>
<!-- Navbar-->
<!-- Remove "navbar-sticky" class to make navigation bar scrollable with the page.-->
<header class="navbar navbar-sticky">
	<!-- Search-->
	<form class="site-search" method="get">
		<input type="text" name="site_search" placeholder="Type to search...">
		<div class="search-tools">
			<span class="clear-search">Clear</span><span class="close-search"><i
				class="icon-cross"></i></span>
		</div>
	</form>
	<div class="site-branding">
		<div class="inner">
			<!-- Off-Canvas Toggle (#shop-categories)
			<a class="offcanvas-toggle cats-toggle" href="#shop-categories"
				data-toggle="offcanvas"></a>
			-->
			<!-- Off-Canvas Toggle (#mobile-menu)-->
			<a class="offcanvas-toggle menu-toggle" href="#mobile-menu"
				data-toggle="offcanvas"></a>
			<!-- Site Logo-->
			<a class="site-logo" href="index.html"><img
				src="img/logo/logo.png" alt="Unishop"></a>
		</div>
	</div>
	<!-- Main Navigation-->
	<nav class="site-menu">
		<ul>
			<li class="has-megamenu active"><a href="index"><span>Home</span></a></li>
			<li><a href="shop-grid-ns"><span>Shop</span></a></li>
			<c:if test="${!empty sUserId}">
				<li><a href="account-orders"><span>Account</span></a>
					<ul class="sub-menu">
						<li><a href="account-logout">Logout</a></li>
						<li><a href="account-orders">Orders List</a></li>
						<li><a href="account-wishlist">Wishlist</a></li>
						<li><a href="account-profile">Profile Page</a></li>
						<li><a href="account-address">Contact / Shipping
								Address</a></li>
					</ul></li>
			</c:if>
			<c:if test="${empty sUserId}">
				<li><a href="account-login"><span>Account</span></a>
					<ul class="sub-menu">
						<li><a href="account-login">Login / Register</a></li>
					</ul></li>
			</c:if>
			<li><a href="#"><span>Pages</span></a>
				<ul class="sub-menu">
					<li><a href="about.html">About Us</a></li>
					<li><a href="contacts.html">Contacts</a></li>
					<li><a href="faq.html">Help / FAQ</a></li>
					<li><a href="order-tracking.html">Order Tracking</a></li>
					<li><a href="search-results.html">Search Results</a></li>
					<li><a href="coming-soon.html">Coming Soon</a></li>
				</ul></li>

		</ul>
	</nav>
	<!-- Toolbar-->
	<div class="toolbar">
		<div class="inner">
			<div class="tools">
				<div class="search">
					<i class="icon-search"></i>
				</div>

				<div class="account">
					<c:if test="${empty(sUserId)}">
						<a href="account-login"></a>
						<i class="icon-head"></i>
					</c:if>
					<c:if test="${!empty(sUserId)}">
						<a href="account-orders"></a>
						<i class="icon-head"></i>
						<ul class="toolbar-dropdown">
							<li class="sub-menu-user">
								<div class="user-ava">
									<img src="img/account/${loginUser.userId}.png"
										alt="${loginUser.name}">
								</div>
								<div class="user-info">
									<h6 class="user-name">${loginUser.name}</h6>
									<span class="text-xs text-muted">290 Reward points</span>
								</div>
							</li>
							<li><a href="account-profile">My Profile</a></li>
							<li><a href="account-orders">Orders List</a></li>
							<li><a href="account-wishlist">Wishlist</a></li>
							<li class="sub-menu-separator"></li>
							<li><a href="account-logout"> <i class="icon-unlock"></i>Logout
							</a></li>
						</ul>
					</c:if>
				</div>

				<c:set var="tot_price" value="0" />
				<c:set var="tot_price" value="${tot_price+0}" />	
				<div class="cart">
					<c:if test="${empty(sUserId)}">
						<a href="account-login"></a>
						<i class="icon-bag"></i>
					</c:if>
					<c:if test="${!empty(sUserId)}">
						<a href="cart"></a>
						<i class="icon-bag"></i>
						<span class="count">${cartItemList.size()}</span>
						<span class="subtotal">&#8361;<s:eval
								expression="new java.text.DecimalFormat('#,##0').format(cartTotPrice)" /></span>
						<div class="toolbar-dropdown">
							
							<c:forEach items="${cartItemList}" var="cartItem">
								<c:set var="tot_price"
									value="${tot_price + cartItem.product.p_price * cartItem.cart_qty}" />
								<div class="dropdown-product-item">
									<span class="dropdown-product-remove"><i
										class="icon-cross"></i></span><a class="dropdown-product-thumb"
										href="shop-single.html"><img
										src="img/cart-dropdown/${cartItem.product.p_image}"
										alt="Product"></a>
									<div class="dropdown-product-info">
										<a class="dropdown-product-title"
											href="shop-single?p_no=${cartItem.product.p_no}">${cartItem.product.p_name}</a><span
											class="dropdown-product-details"> ${cartItem.cart_qty}
											x &#8361;<s:eval
												expression="new java.text.DecimalFormat('#,###').format(cartItem.product.p_price)" />
										</span>
									</div>
								</div>
							</c:forEach>
							
							<div class="toolbar-dropdown-group">
								<div class="column">
									<span class="text-lg">Total:</span>
								</div>
								<div class="column text-right">
									<span class="text-lg text-medium">&#8361; <s:eval
											expression="new java.text.DecimalFormat('#,##0').format(tot_price)" />&nbsp;
									</span>
								</div>
							</div>
							<div class="toolbar-dropdown-group">
								<div class="column">
									<a class="btn btn-sm btn-block btn-secondary" href="cart">View
										Cart</a>
								</div>
								<div class="column">
									<a class="btn btn-sm btn-block btn-success"
										href="checkout-address.html">Checkout</a>
								</div>
							</div>
						</div>
				</div>
				</c:if>
			</div>
		</div>
	</div>
</header>