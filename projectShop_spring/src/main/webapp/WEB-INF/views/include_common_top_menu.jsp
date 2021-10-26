<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript">
	$(function(){
		$.ajax({
			url:'cart_item_count',
			method:'POST',
			success:function(jsonObject){
				/*
				{"user_name":"김경호1","cart_item_count":3}
				*/
				$(".login_user_name").html(jsonObject.user_name);
				$(".cart_item_count").html(jsonObject.cart_item_count);
			}
		});
	});
</script>    
<div id="menu">
	<ul>
		<li id="logo"><a href="shop_main"></a></li>
		<c:if test="${empty sUserId}">
			<li id="mypage" title="나의페이지"><a href="user_login_form"></a></li>
			<li id="cart" title="장바구니"><span
				class="w3-badge-no-login w3-green-no-login w3-margin-right"><span class="cart_item_count"></span>
			</span><a href="user_login_form" title="장바구니"></a></li>
		</c:if>
		<c:if test="${!empty sUserId}">
			<li id="mypage" title="나의페이지" ><a href="user_view_myinfo"></a></li>
			<li id="cart" title="장바구니"><span class="w3-badge w3-green w3-margin-right"><span class="cart_item_count">0</span></span><a href="cart_view_select_update_qyt_image"></a></li>
		</c:if>
	</ul>
</div>
