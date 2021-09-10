package com.itwill.user.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;
import com.itwill.user.UserServiceImpl;

public class UserListController implements Controller {
	private UserService userService;
	public UserListController() throws Exception{
		userService=new UserServiceImpl();
	}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		String forwardPath="";
		
		try {
			ArrayList<User> userList=userService.findUserList();
			request.setAttribute("userList", userList);
			forwardPath="forward:/WEB-INF/views/user_list.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath="forward:/WEB-INF/views/user_error.jsp";
		}
		return forwardPath;
	}
	
}