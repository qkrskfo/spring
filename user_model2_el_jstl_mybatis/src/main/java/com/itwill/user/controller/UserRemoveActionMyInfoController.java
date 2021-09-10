package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.Controller;
import com.itwill.user.UserService;
import com.itwill.user.UserServiceImpl;

public class UserRemoveActionMyInfoController implements Controller {
	private UserService userService;

	public UserRemoveActionMyInfoController() throws Exception {
		userService = new UserServiceImpl();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
		String sUserId=(String)request.getSession().getAttribute("sUserId");
		if (request.getMethod().equalsIgnoreCase("GET")) {
			forwardPath = "redirect:user_main.do";
			return forwardPath;
		}
		try {
			userService.remove(sUserId);
			/**** case1 **********/
			request.getSession().invalidate();
			forwardPath="redirect:user_main.do";
			/**********************/
			/****case2********* 
			 response.sendRedirect("user_logout_action.jsp");
			 ******************/
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath="redirect:user_error.do";
		}
		return forwardPath;
	}
}
