package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;
import com.itwill.user.UserServiceImpl;

public class UserModifyFormMyInfoController implements Controller {
	private UserService userService;

	public UserModifyFormMyInfoController() throws Exception {
		userService = new UserServiceImpl();
	}
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
		String sUserId = (String) request.getSession().getAttribute("sUserId");
		try {
			User loginUser = userService.findUser(sUserId);
			request.setAttribute("loginUser", loginUser);
			forwardPath = "forward:/WEB-INF/views/user_modify_form_myinfo.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath="forward:/WEB-INF/views/user_error.jsp";
		}

		return forwardPath;
	}

}
