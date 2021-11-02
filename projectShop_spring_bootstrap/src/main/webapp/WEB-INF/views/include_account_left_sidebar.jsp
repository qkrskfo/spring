<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<aside class="user-info-wrapper">
	<div class="user-cover"
		style="background-image: url(img/account/user-cover-img.jpg);">
		<div class="info-label" data-toggle="tooltip"
			title="You currently have 290 Reward Points to spend">
			<i class="icon-medal"></i>290 points
		</div>
	</div>
	<div class="user-info">
		<div class="user-avatar">
			<a class="edit-avatar" href="#"></a><img
				src="img/account/${loginUser.userId}.png" alt="User">
		</div>
		<div class="user-data">
			<h4>${loginUser.name}</h4>
			<span>Joined <s:eval
					expression="new java.util.Date().toLocaleString()" /></span>
		</div>
	</div>
</aside>
<nav class="list-group">	<a class="list-group-item with-badge" href="account-orders">
		<i class="icon-bag"></i>Orders
		<span class="badge badge-primary badge-pill">${orderList.size()}</span>
	</a> 
	<a class="list-group-item" href="account-profile">
		<i class="icon-head"></i>Profile
	</a>
	<a class="list-group-item" href="account-address"><i class="icon-map"></i>Addresses
	</a> 
	<a class="list-group-item with-badge" href="account-wishlist">
		<i class="icon-heart"></i>Wishlist<span class="badge badge-primary badge-pill">3</span>
	</a>
</nav>
