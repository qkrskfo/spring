package com.itwill.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;
import com.itwill.guest.GuestServiceImpl;

public class GuestWriteActionController implements Controller {
	private GuestService guestService;
	public GuestWriteActionController() {
		
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
				request.setCharacterEncoding("UTF-8");
				String guest_name = request.getParameter("guest_name");
				String guest_email = request.getParameter("guest_email");
				String guest_homepage = request.getParameter("guest_homepage");
				String guest_title = request.getParameter("guest_title");
				String guest_content = request.getParameter("guest_content");
				Guest guest = new Guest(0, guest_name, null, guest_email, guest_homepage, guest_title, guest_content);
				int insertRowCount = guestService.insertGuest(guest);
				/***********CASE1******************/
				forwardPath="redirect:guest_list.do";
				
				/************CASE2[pk 반환]********
				int pk = guest.getGuest_no();
				forwardPath="redirect:guest_view.do?guest_no="+pk;
				******************************/
			} catch (Exception e) {
				e.printStackTrace();
				forwardPath="redirect:guest_error.do";
			}
		}
		return new ModelAndView(forwardPath);
	}

}