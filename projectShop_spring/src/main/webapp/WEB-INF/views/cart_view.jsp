<%@page import="com.itwill.shop.cart.CartServiceImpl"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.itwill.shop.cart.CartItem"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.itwill.shop.cart.CartService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>쇼핑몰 관리</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet href="css/styles.css" type="text/css">
<link rel=stylesheet href="css/shop.css" type="text/css">
<style type="text/css" media="screen">
</style>
<script type="text/javascript">
	function cart_delete(){
		document.cart_view_form.method='POST';
		document.cart_view_form.action='cart_delete_action';
		document.cart_view_form.submit();
	}
	function cart_view_form_order_submit(){
		document.cart_view_form.method='POST';
		document.cart_view_form.buyType.value='cart';
		document.cart_view_form.action='order_create_form';
		document.cart_view_form.submit();
	}
</script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0
	marginwidth=0 marginheight=0>
	<form name="cart_view_form" style="margin:0">
		<input type="hidden" name="buyType">
	</form>
	<!-- container start-->
	
	<div id="container">
		<!-- header start -->
		<div id="header">
			<!-- include_common_top.jsp start-->
			<jsp:include page="include_common_top.jsp"/>
			<!-- include_common_top.jsp end-->
		</div>
		<!-- header end -->
		<!-- navigation start-->
		<div id="navigation">
			<!-- include_common_left.jsp start-->
			<jsp:include page="include_common_left.jsp"/>
			<!-- include_common_left.jsp end-->
		</div>
		<!-- navigation end-->
		<!-- wrapper start -->
		<div id="wrapper">
			<!-- content start -->

			<!-- include_content.jsp start-->
			<div id="content">
				<table border=0 cellpadding=0 cellspacing=0>
					<tr>
						<td><br />
							<table style="padding-left: 10px" border=0 cellpadding=0
								cellspacing=0>
								<tr>
									<td height="22">&nbsp;&nbsp;<b>쇼핑몰 - 장바구니 보기</b></td>
								</tr>
							</table> 
							<!--form-->
							<!-- 
							<form name="f" method="post">
							 -->
							<div id='f'>
							<table  align=center  width=80% border="0" cellpadding="0" cellspacing="1"  bgcolor="BBBBBB">
									<tr>
										<td width=60 height=25  align="center" bgcolor="E6ECDE" class=t1><font
											 >선택</font></td>
										<td width=40 height=25 align="center" bgcolor="E6ECDE" class=t1><font
											 >이미지</font></td>
										<td width=210 height=25 align="center" bgcolor="E6ECDE" class=t1><font
											 >강아지 이름</font></td>
										<td width=112 height=25 align="center" bgcolor="E6ECDE" class=t1><font
											 >수 량</font></td>
										<td width=146 height=25 align="center" bgcolor="E6ECDE" class=t1><font
											 >가 격</font></td>
										<td width=50 height=25 align="center" bgcolor="E6ECDE" class=t1><font
											 >비 고</font></td>
									</tr>
									
									<!-- cart item start -->
									<c:set var="tot_price"  value="0"/>
									<c:set var="tot_price"  value="${tot_price+0}"/>
									<c:forEach items="${cartItemList}" var="cartItem" >
										<c:set var="tot_price"  value="${tot_price + cartItem.product.p_price * cartItem.cart_qty}"/>
										<tr>
											<td width=60 height=26 align=center bgcolor="ffffff" class=t1></td>
											<td width=40 height=26 align=center bgcolor="ffffff" class=t1><img src='image/${cartItem.product.p_image}' width="34" height="28"/></td>
											<td width=210 height=26 align=center bgcolor="ffffff" class=t1><a href='product_detail?p_no=${cartItem.product.p_no}'>${cartItem.product.p_name}</a></td>
											<td width=112 height=26 align=center bgcolor="ffffff" class=t1>${cartItem.cart_qty}</td>
											<td width=146 height=26 align=center bgcolor="ffffff" class=t1>
												<s:eval expression="new java.text.DecimalFormat('#,##0').format(cartItem.product.p_price*cartItem.cart_qty)"/>
											</td>
											<td width=50 height=26 align=center bgcolor="ffffff" class=t1>
												<form action="cart_delete_item_action" method="post">
													<input type="hidden" name="cart_no" value="${cartItem.cart_no}">
													<input type="submit" value="삭제">
												</form>
											</td>
										</tr>
									</c:forEach>
									
									<!-- cart item end -->
									<tr>
										<td width=640 colspan=6 height=26 class=t1 bgcolor="ffffff">
											<p align=right>
												<br/>
												<span id="tot_order_price" style="color: red">총주문금액 : 
												<s:eval expression="new java.text.DecimalFormat('#,##0').format(tot_price)"/>원</span>
											</p>
										</td>
									</tr>
								</table>
							</div>
							<!-- 
							</form> 
							 -->
							<br />
							<table style="padding-left: 10px" border="0" cellpadding="0" cellspacing="1" width="590">
								<tr>
									<td align=center>&nbsp;&nbsp;
									
									<a href="product_list" class=m1>계속 구경하기</a>&nbsp;&nbsp;
									<c:if test="${cartItemList.size()>=1}">
										<a href="javascript:cart_view_form_order_submit();" class=m1>총 <span style="font-weight: bold;" id="cart_item_select_count">${cartItemList.size()}</span>개 주문하기[주문폼]</a>
										<a href="javascript:cart_delete();" class=m1>장바구니 비우기</a>&nbsp;&nbsp;
									</c:if>
									</td>
								</tr>
							</table></td>
					</tr>
				</table>
			</div>
			<!-- include_content.jsp end-->
			<!-- content end -->
		</div>
		<!--wrapper end-->
		<div id="footer">
			<!-- include_common_bottom.jsp start-->
			<jsp:include page="include_common_bottom.jsp"/>
			<!-- include_common_bottom.jsp end-->
		</div>
	</div>
	<!--container end-->
</body>
</html>