package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwill.summer.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;

public class UserModifyFormMyinfoController implements Controller{

	private UserService userService;
	
	public UserModifyFormMyinfoController() throws Exception {
		userService = new UserService();
	}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
		
		String sUserId=(String)request.getSession().getAttribute("sUserId");
			
			
		try {	
			User loginUser = userService.findUser(sUserId);
			
			if(sUserId!=null){
				request.setAttribute("user", loginUser);
			}
			forwardPath = "forward:/WEB-INF/views/user_modify_form_myinfo.jsp";
			
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "forward:/WEB-INF/views/user_error.jsp";
		}	
		
		
		//return forwardPath = "forward:/WEB-INF/views/user_modify_form_myinfo.jsp";
		return forwardPath;
	}
}
