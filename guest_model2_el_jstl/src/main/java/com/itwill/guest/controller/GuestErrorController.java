package com.itwill.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.Controller;

public class GuestErrorController implements Controller {
	
	public String handleRequest (HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
		forwardPath = "/WEB-INF/view/guest_error.jsp";
		return forwardPath;
	}

}