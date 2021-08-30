<%@page import="com.itwill.user.User"%>
<%@page import="com.itwill.user.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="login_check.jspf" %>   
<%
	/*
		0.login 여부체크
		1.GET방식이면 user_main.jsp redirection
		2.요청객체인코딩설정
		3.파라메타받기
		4.UserService.update 메쏘드호출
		5.성공:user_view_myinfo.jsp redirection
		  실패:user_error.jsp 
	*/
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("user_main.jsp");
		return;
	}
	try{
		//request.setCharacterEncoding("UTF-8");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		UserService userService=new UserService();
		userService.update(new User(sUserId,password,name,email));
		response.sendRedirect("user_view_myinfo.jsp");
	}catch(Exception e){
		e.printStackTrace();
		response.sendRedirect("user_error.jsp");
	}
%>