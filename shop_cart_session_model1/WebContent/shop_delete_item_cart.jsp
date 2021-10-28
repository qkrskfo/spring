<%@page import="com.itwill.shop.cart.Cart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String p_no = request.getParameter("p_no");
	if (p_no == null || p_no.equals("")) {
		response.sendRedirect("shop_product_list.jsp");
		return;
	}
	//장바구니에서 원하는 품목을 삭제시킨 후 view_cart.jsp 로 sendRedirect 시킨다..
	Cart cart = (Cart) session.getAttribute("cart");
	if (cart == null) {
		cart = new Cart();
		session.setAttribute("cart", cart);
	}
	cart.deleteCartItem(Integer.parseInt(p_no));
	response.sendRedirect("shop_view_cart.jsp");
%>
