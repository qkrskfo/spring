package com.itwill.user.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;

public class UserViewController implements Controller {

	private UserService userService;
	public UserViewController() throws Exception {
		userService = new UserService();
	}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		String forwardPath = "";
		
		/************* login check **********/
		String sUserId = (String)request.getSession().getAttribute("sUserId");
		if(sUserId==null) {
			forwardPath="redirect:user_main.do";
			return forwardPath;
		}
		/************************************/
		
		String userId = request.getParameter("userId");
		if(userId==null||userId.equals("")){
			forwardPath = "redirect:user_main.do";
			return forwardPath;
		}
		try {
			//UserService userService=new UserService();
			User user = userService.findUser(userId);
			
			if(user!=null){
				request.setAttribute("user", user);
			}
			forwardPath = "forward:/WEB-INF/views/user_view.jsp";
			
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "forward:/WEB-INF/views/user_error.jsp";
		}
		//return "forward:/WEB-INF/views/user_view.jsp";
		return forwardPath;
	}
}
