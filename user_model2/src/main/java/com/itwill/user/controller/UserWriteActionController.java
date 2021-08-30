package com.itwill.user.controller;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;

public class UserWriteActionController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		String forwardPath ="";
		
		if(request.getMethod().equalsIgnoreCase("GET")){
			forwardPath="redirect:user_write_form.do";
		} else {
			try {
				request.setCharacterEncoding("UTF-8");
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
					forwardPath="forward:user_write_form.do?msg="+msg;
				}else if(result==1){
					//회원가입성공
					forwardPath="redirect:user_login_form.do";
				}
			} catch (Exception e) {
				e.printStackTrace();
				forwardPath="redirect:user_error.do";
			}
		}
		//return "forward:/WEB-INF/views/user_write_action.jsp";
		return forwardPath;
	}
	
	
}
