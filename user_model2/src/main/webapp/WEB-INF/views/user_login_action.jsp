<%@page import="java.net.URLEncoder"%>
<%@page import="com.itwill.user.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<%
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("user_login_form.do");
		return;
	}
	try{
		String userId=request.getParameter("userId");
		String password=request.getParameter("password");
		UserService userService=new UserService();
		int result=userService.login(userId,password);
		if(result==0){
			//아이디존재안함
			String msg1=URLEncoder.encode(userId+" 는 존재하지않는 아이디입니다.","UTF-8");
			response.sendRedirect("user_login_form.do?msg1="+msg1);
		}else if(result==1){
			//패쓰워드불일치
			String msg2=URLEncoder.encode("패쓰워드가 일치하지않습니다.","UTF-8");
			response.sendRedirect("user_login_form.do?msg2="+msg2);
		}else if(result==2){
			//패쓰워드일치(로그인성공)
			session.setAttribute("sUserId",userId);
			response.sendRedirect("user_main.do");
		}
		
	}catch(Exception e){
		e.printStackTrace();
		response.sendRedirect("user_error.do");
	}
%>