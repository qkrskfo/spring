
<%@page import="java.net.URLEncoder"%>
<%@page import="com.itwill.user.exception.ExistedUserException"%>
<%@page import="com.itwill.user.UserService"%>
<%@page import="com.itwill.user.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("user_write_form.jsp");
		return;
	}
	/**************1.반환값사용***********************/
	//request.setCharacterEncoding("UTF-8");
	String userId=request.getParameter("userId");
	String password=request.getParameter("password");
	String name=request.getParameter("name");
	String email=request.getParameter("email");
	User newUser=new User(userId,password,name,email);
	UserService userService=new UserService();
	int result=userService.create(newUser);
	if(result==-1){
		//아이디중복
		String msg=URLEncoder.encode(userId+" 는 이미존재하는 아이디입니다.", "UTF-8");
		response.sendRedirect("user_write_form.jsp?msg="+msg);
	}else if(result==1){
		//회원가입성공
		response.sendRedirect("user_login_form.jsp");
	}
	/*******************************************/

	/**********2.사용자정의예외객체사용********
	try{
		request.setCharacterEncoding("UTF-8");
		String userId=request.getParameter("userId");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		User newUser=new User(userId,password,name,email);
		UserService userService=new UserService();
		userService.create(newUser);
		response.sendRedirect("user_login_form.jsp");
	}catch(ExistedUserException e){
		e.printStackTrace();
		//아이디중복예외
		String msg=e.getMessage();
		response.sendRedirect("user_write_form.jsp?msg="
			+URLEncoder.encode(msg, "UTF-8"));
	}catch(Exception e){
		e.printStackTrace();
		response.sendRedirect("user_error.jsp");
	}
	********************************************/

%>















