package com.itwill.guest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;
import com.itwill.guest.GuestServiceImpl;


public class GuestListController implements Controller {
	private GuestService guestService;
	
	public void setGuestService(GuestService guestService) {
		this.guestService = guestService;
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String forwardPath="";
		try {
			List<Guest> guestList = guestService.selectAll();
			request.setAttribute("guestList", guestList);
			forwardPath="forward:/WEB-INF/views/guest_list.jsp";
		}catch (Exception e) {
			e.printStackTrace();
			forwardPath="forward:/WEB-INF/views/guest_error.jsp";
		}
		return new ModelAndView(forwardPath);
	}

}
