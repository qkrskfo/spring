package com.itwill.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.Controller;

public class GuestMaincontroller implements Controller {
	public String handleRequest() {
		
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath="";
		forwardPath="forward:/WEB-INF/view/guest_main.jsp";
		return forwardPath;
	}
	
	
}
