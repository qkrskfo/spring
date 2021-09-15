package com.itwill.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.itwill.guest.GuestService;
import com.itwill.guest.GuestServiceImpl;

public class GuestRemoveActionController implements Controller {
	private GuestService guestService;
	public GuestRemoveActionController() {
		
	}
	
	public void setGuestService(GuestService guestService) {
		this.guestService = guestService;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath="";
		if (request.getMethod().equalsIgnoreCase("GET")) {
			forwardPath="redirect:guest_main.do";
		}else {
			try {
				String guest_noStr = request.getParameter("guest_no");
				guestService.deleteGuest(Integer.parseInt(guest_noStr));
				forwardPath="redirect:guest_list.do";
			} catch (Exception e) {
				e.printStackTrace();
				forwardPath="redirect:guest_error.do";
			}
		}
		return new ModelAndView(forwardPath);
	}

}
