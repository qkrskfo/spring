package com.itwill.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

public class GuestModifyFormController implements Controller {

	private GuestService guestService;
	
	public GuestModifyFormController() {

	}
	
	public void setGuestService(GuestService guestService) {
		this.guestService = guestService;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String forwardPath ="";
		String guest_noStr = request.getParameter("guest_no");
		
		try {
			Guest guest = guestService.selectByNo(Integer.parseInt(guest_noStr));
			if(guest==null) {
				forwardPath="redirect:guest_main.do";
			} else {
			request.setAttribute("guest", guest);
			forwardPath="forward:/WEB-INF/views/guest_modify_form.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath="forward:/WEB-INF/views/guest_error.jsp";
		}
		return new ModelAndView(forwardPath);
	}

}
