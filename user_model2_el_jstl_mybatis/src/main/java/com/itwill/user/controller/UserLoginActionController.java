package com.itwill.user.controller;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwill.summer.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;

public class UserLoginActionController implements Controller{
	private UserService userService;
	public UserLoginActionController() throws Exception{
		userService=new UserService();
	}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath="";
		if(request.getMethod().equalsIgnoreCase("GET")){
			forwardPath="redirect:user_login_form.do";
			return forwardPath;
		}
		try{
			String userId=request.getParameter("userId");
			String password=request.getParameter("password");
			int result=userService.login(userId,password);
			if(result==0){
				//아이디존재안함
				/********************case1[redirect]*****************
				String msg1=URLEncoder.encode(userId+" 는 존재하지않는 아이디입니다.","UTF-8");
				forwardPath="redirect:user_login_form.do?msg1="+msg1;
				**************************************************/
				
				/********************case2[forward]*****************/
				String msg1=userId+" 는 존재하지않는 아이디입니다.";
				User fuser=new User(userId,password,"","");
				request.setAttribute("msg1", msg1);
				request.setAttribute("fuser", fuser);
				forwardPath="forward:/WEB-INF/views/user_login_form.jsp";
				/*****************************************************/
				
			}else if(result==1){
				//패쓰워드불일치
				/********************case1[redirect]*****************
				String msg2=URLEncoder.encode("패쓰워드가 일치하지않습니다.","UTF-8");
				forwardPath="redirect:user_login_form.do?msg2="+msg2;
				****************************************************/
				
				/********************case2[forward]*****************/
				String msg2="패쓰워드가 일치하지않습니다.";
				User fuser=new User(userId,password,"","");
				request.setAttribute("msg2", msg2);
				request.setAttribute("fuser", fuser);
				forwardPath="forward:/WEB-INF/views/user_login_form.jsp";
				/*****************************************************/
			}else if(result==2){
				//패쓰워드일치(로그인성공)
				HttpSession session = request.getSession();
				session.setAttribute("sUserId",userId);
				forwardPath="redirect:user_main.do";
			}
			
		}catch(Exception e){
			e.printStackTrace();
			//forwardPath="redirect:user_error.do";
			forwardPath="forward:/WEB-INF/views/user_error.jsp";
		}
		return forwardPath;
	}
	
}
