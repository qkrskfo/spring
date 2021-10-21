<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>	
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
	function login_message() {
		alert('로그인하세요');
		location.href = 'user_login_form';
	}
</script>
<p>
	<strong>메 뉴</strong>
</p>
<ul>
		<c:choose>	
		<c:when test="${empty(sUserId)}">
		    <li><a href="user_login_form">로그인</a></li>
			<li><a href="user_write_form">회원가입</a></li>
			<li><a href="user_write_form_ajax">회원가입[jQuery Ajax]</a></li>
			<li><a href=""></a></li>
			<li><a href="javascript:login_message();">장바구니</a></li>
		</c:when>
		<c:otherwise>
			<li><a href="user_view_myinfo">${sUserId}님</a></li>
			<li><a href="user_logout_action">로그아웃</a></li>
			<li><a href=""></a></li>
			<li><a href="cart_view">장바구니[전체주문](3)</a></li>
			<li><a href="cart_view_select">장바구니[선택주문](3)</a></li>
			<li><a href="cart_view_select_update_qty">장바구니[수량변경](3)</a></li>
			<li><a href="cart_view_select_update_qyt_image">장바구니[전체선택](3)</a></li>
			<li><a href=""></a></li>
			<li><a href="order_list">주문목록</a></li>
		 </c:otherwise>
		</c:choose>
	
		<li><a href="product_list">상품리스트</a></li>
		<li><a href=""></a></li>
		<li><a href="board_list">게시판리스트</a></li>
		<li><a href="board_write">게시판쓰기</a></li>
		
</ul>