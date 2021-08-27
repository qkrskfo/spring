package com.itwill.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.Controller;

public class GuestWriteController implements Controller {

	public String handleRequest (HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = null;
		forwardPath="forward:/WEB-INF/view/guest_write_form.jsp";
		return forwardPath;
	}
}
