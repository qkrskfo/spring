package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.Controller;

public class UserErrorController implements Controller{

	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath="forward:/WEB-INF/views/user_error.jsp";
		return forwardPath;
	}
}
