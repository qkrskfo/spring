<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.itwill.shop.cart.Cart"%>
<%
	//장바구니에 있는 모든개를지우고  view_cart.jsp 로 redirection...
	Cart cart = (Cart) session.getAttribute("cart");
	if (cart == null) {
		cart = new Cart();
		session.setAttribute("cart", cart);
	}
	cart.deleteCart(session.getId());
	response.sendRedirect("shop_view_cart.jsp");
%>