package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.Controller;

public class UserModifyFormMyinfoController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "forward:/WEB-INF/views/user_modify_form_myinfo.jsp";
		return forwardPath;
	}
}
