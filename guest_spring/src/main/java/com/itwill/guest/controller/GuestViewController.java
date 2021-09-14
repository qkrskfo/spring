package com.itwill.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

public class GuestViewController implements Controller {
	private GuestService guestService;
	
	public void setGuestService(GuestService guestService) {
		this.guestService = guestService;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String forwardPath="";
		String guest_noStr = request.getParameter("guest_no");
		if(guest_noStr==null || guest_noStr.equals("")) {
			forwardPath ="redirect:guest_main.do";
			return new ModelAndView(forwardPath);
		}
		
		try {
			Guest guest = guestService.selectByNo(Integer.parseInt(guest_noStr));
			if(guest==null) {
				forwardPath="redirect:guest_main.do";
			} else {
				request.setAttribute("guest", guest);
				forwardPath = "forward:/WEB-INF/views/guest_view.jsp";
			}
			
		} catch (Exception e) {
			forwardPath="foward:/WEB-INF/views/guest_error.jsp";
		}
		return new ModelAndView(forwardPath);
	}

}
