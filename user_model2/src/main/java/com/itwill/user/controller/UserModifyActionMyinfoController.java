package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwill.summer.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;

public class UserModifyActionMyinfoController implements Controller{

	private UserService userService;
	
	public UserModifyActionMyinfoController() throws Exception{
		userService = new UserService();
	}
		
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		String forwardPath = "";
		
		String sUserId=(String)request.getSession().getAttribute("sUserId");
		
		if(request.getMethod().equalsIgnoreCase("GET")){
			forwardPath="redirect:user_write_form.do";
			return forwardPath;
		}
		
		try{
			//request.setCharacterEncoding("UTF-8");
			String password=request.getParameter("password");
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			//UserService userService=new UserService();
			
			userService.update(new User(sUserId,password,name,email));
			forwardPath="redirect:user_view_myinfo.do";
			
		}catch(Exception e){
			
			e.printStackTrace();
			forwardPath="redirect:user_error.do";
		}
		
		//return forwardPath = "forward:/WEB-INF/views/user_modify_action_myinfo.jsp";
		return forwardPath;
		
	}
}
