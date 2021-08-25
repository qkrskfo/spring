<%@page import="com.itwill.guest.GuestService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
/*
0. GET방식이면 guest_main.jsp redirection
1. guest_no 파라메타바끼
2. GuestService.deleteGuest()메쏘드호출
3. 성공 -->guest_list.jsp redirection
   실패-->guest_error.jsp redirection
*/
if (request.getMethod().equalsIgnoreCase("GET")) {
	response.sendRedirect("guest_main.jsp");
	return;
}
try {
	String guest_noStr = request.getParameter("guest_no");
	GuestService guestService = new GuestService();
	guestService.deleteGuest(Integer.parseInt(guest_noStr));
	response.sendRedirect("guest_list.jsp");
} catch (Exception e) {
	e.printStackTrace();
	/****** redirect [case1] ********/
	response.sendRedirect("guest_error.do");
}
%>