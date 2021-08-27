<%@page import="com.itwill.user.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="login_check.jspf" %>    
<%
	/*
		0.login 여부체크
		1.GET방식이면 user_main.jsp redirection
		2.sUserId를 사용해서 UserService.remove(sUserId) 메쏘드호출
		3.성공: user_logout_action.jsp redirection --> user_main.jsp
		  실패: user_error.jsp 
		  	 
	*/
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("user_main.jsp");
		return;
	}
	try{
		UserService userService=new UserService();
		userService.remove(sUserId);
		/****case1**********/
		session.invalidate();
		response.sendRedirect("user_main.jsp");
		/**********************/
		/****case2**********
		response.sendRedirect("user_logout_action.jsp");
		******************/
	}catch(Exception e){
		e.printStackTrace();
		response.sendRedirect("user_error.jsp");
	}
%>