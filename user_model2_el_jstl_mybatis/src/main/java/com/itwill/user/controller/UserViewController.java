package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;
import com.itwill.user.UserServiceImpl;

public class UserViewController implements Controller {
	private UserService userService;
	public UserViewController() throws Exception{
		userService=new UserServiceImpl();
	}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath="";
		
		String userId = request.getParameter("userId");
		if(userId==null||userId.equals("")){
			forwardPath="redirect:user_main.do";
			return forwardPath;
		}
		try {
			User user = userService.findUser(userId);
			if(user!=null){
				request.setAttribute("user", user);
			}	
			forwardPath="forward:/WEB-INF/views/user_view.jsp";
			
			
		}catch (Exception e) {
			e.printStackTrace();
			forwardPath="forward:/WEB-INF/views/user_error.jsp";
		}
		return forwardPath;
	}
	
}
