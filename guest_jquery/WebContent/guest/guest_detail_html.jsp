<%@page import="com.itwill.guest.GuestDaoImpl"%>
<%@page import="com.itwill.guest.Guest"%>
<%@page import="com.itwill.guest.GuestDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/plain; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--@include file="loginCheck.jspf" --%>	
<%
    String guest_no = request.getParameter("guest_no");
	if(guest_no==null||guest_no.equals(""))guest_no="1";
	String method=request.getMethod();
	System.out.println("*********jQuery Ajax요청정보*********");
	System.out.println("0.jQuery Ajax요청URL    :" + request.getRequestURI());
	System.out.println("1.jQuery Ajax요청방식    :"+method);
	System.out.println("2.jQuery Ajax요청파라메타:"+guest_no);
	System.out.println("*************************************");	
	GuestDao dao = new GuestDaoImpl();
	Guest guest = dao.selectByNo(Integer.parseInt(guest_no.trim()));
%>

	<div class="guest_date">
		날짜:<%=guest.getGuest_date()%>
	</div>
	<div class="guest_name">
		이름:<%=guest.getGuest_name()%>
	</div>
	<div class="guest_email">
		이메일:<%=guest.getGuest_email()%>
	</div>
	<div class="guest_homepage">
		홈페이지:<%=guest.getGuest_homepage()%>
	</div>
	<div class="guest_content">
		내용:<%=guest.getGuest_content()%>
	</div>
	<div class='guest_delete'>
		<input type="button" value="삭제" guest_no="<%=guest.getGuest_no()%>">
		<input type="button" value="수정" guest_no="<%=guest.getGuest_no()%>">
	</div>


	
	

	
	
	
	
	
	
	
	
	
	
	