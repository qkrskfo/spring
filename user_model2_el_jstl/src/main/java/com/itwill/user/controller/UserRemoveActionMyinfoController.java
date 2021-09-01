package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwill.summer.Controller;
import com.itwill.user.UserService;

public class UserRemoveActionMyinfoController implements Controller{
	
	private UserService userService;
	public UserRemoveActionMyinfoController() throws Exception {
		userService = new UserService();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		String forwardPath = "forward:/WEB-INF/views/user_remove_action_myinfo.jsp";
		
		if(request.getMethod().equalsIgnoreCase("GET")){
			forwardPath = "redirect:user_main.do";
			return forwardPath;
		}
		
		HttpSession session = request.getSession();
		String sUserId = (String)session.getAttribute("sUserId");
		
		try{
			userService.remove(sUserId);
			/****case1**********/
			session.invalidate();
			forwardPath = "redirect:user_main.do";
			/**********************/
			/****case2**********
			response.sendRedirect("user_logout_action.jsp");
			******************/
		}catch(Exception e){
			e.printStackTrace();
			forwardPath = "forward:/WEB-INF/views/user_error.jsp";
		}
		
		return forwardPath;
		
	}
}
