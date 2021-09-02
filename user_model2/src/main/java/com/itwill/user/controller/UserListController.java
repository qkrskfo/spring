package com.itwill.user.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;

public class UserListController implements Controller{
	
	private UserService userService;
	
	public UserListController() throws Exception {
		userService = new UserService();
	}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		String forwardPath ="";
		
		/************* login check **********/
		String sUserId = (String)request.getSession().getAttribute("sUserId");
		if(sUserId==null) {
			forwardPath="redirect:user_main.do";
			return forwardPath;
		}
		/************************************/
		
		
		try {
			//UserService userService=new UserService();
			ArrayList<User> userList=userService.findUserList();
			request.setAttribute("userList", userList);
			forwardPath = "forward:/WEB-INF/views/user_list.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "forward:/WEB-INF/views/user_error.jsp";
		}
		
		//return "forward:/WEB-INF/views/user_list.jsp";
		return forwardPath;
	}
}
