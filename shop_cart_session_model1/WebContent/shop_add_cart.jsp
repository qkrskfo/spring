
<%@page import="com.itwill.shop.cart.Cart"%>
<%@page import="com.itwill.shop.product.Product"%>
<%@page import="com.itwill.shop.product.ProductService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	if (request.getMethod().equalsIgnoreCase("GET")) {
		response.sendRedirect("shop_product_list.jsp");
		return;
	}
	//장바구니에 개를담고 view_cart.jsp 로 redirection...
	String p_no = request.getParameter("p_no");
	String cart_qty = request.getParameter("cart_qty");
	if (p_no == null || cart_qty == null) {
		response.sendRedirect("shop_product_list.jsp");
		return;
	}
	ProductService productService = new ProductService();
	Product product = productService.getProduct(Integer.parseInt(p_no));
	
	Cart cart= (Cart) session.getAttribute("cart");
	if (cart == null) {
		cart = new Cart();
		session.setAttribute("cart", cart);
	}
	cart.add(session.getId(),Integer.parseInt(p_no), product, Integer.parseInt(cart_qty));
	response.sendRedirect("shop_view_cart.jsp");
%>
