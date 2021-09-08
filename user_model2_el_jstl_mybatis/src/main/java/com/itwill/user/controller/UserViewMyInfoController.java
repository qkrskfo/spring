package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;

public class UserViewMyInfoController implements Controller {
	private UserService userService;
	public UserViewMyInfoController() throws Exception{
		userService=new UserService();
	}
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath="";
		try {
			String sUserId = (String)request.getSession().getAttribute("sUserId");
			User loginUser=userService.findUser(sUserId);
			request.setAttribute("loginUser", loginUser);
			forwardPath="forward:/WEB-INF/views/user_view_myinfo.jsp";
		}catch (Exception e) {
			e.printStackTrace();
			forwardPath="forward:/WEB-INF/views/user_error.jsp";
		}
		return forwardPath;
	}
	
}
