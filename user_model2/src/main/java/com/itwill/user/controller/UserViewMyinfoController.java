package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwill.summer.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;

public class UserViewMyinfoController implements Controller {
	
	private UserService userService;
	
	public UserViewMyinfoController() throws Exception {
		userService = new UserService();
	}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		String forwardPath = "";
		
		HttpSession session = request.getSession();
		String sUserId=(String)session.getAttribute("sUserId");
			
		if(sUserId==null || sUserId.equals("")){
			forwardPath = "redirect:user_main.do";
			return forwardPath;
		}	
			
		try {	
			User loginUser = userService.findUser(sUserId);
			
			if(sUserId!=null){
				request.setAttribute("user", loginUser);
			}
			forwardPath = "forward:/WEB-INF/views/user_view_myinfo.jsp";
			
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "forward:/WEB-INF/views/user_error.jsp";
		}	
		//return "forward:/WEB-INF/views/user_view_myinfo.jsp";
		return forwardPath;
	}
}
