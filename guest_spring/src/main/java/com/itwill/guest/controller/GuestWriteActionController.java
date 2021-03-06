package com.itwill.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

public class GuestWriteActionController implements Controller {

	private GuestService guestService;
	
	public GuestWriteActionController() {
		
	}
	
	public void setGuestService(GuestService guestService) {
		this.guestService = guestService;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String forwardPath = "";
		//int pk = 0;
		if (request.getMethod().equalsIgnoreCase("GET")) {
			forwardPath="redirect:guest_main.do";
		} else {
			try {
				String guest_name = request.getParameter("guest_name");
				String guest_email = request.getParameter("guest_email");
				String guest_homepage = request.getParameter("guest_homepage");
				String guest_title = request.getParameter("guest_title");
				String guest_content = request.getParameter("guest_content");
				Guest guest = new Guest(0, guest_name, null, guest_email, guest_homepage, guest_title, guest_content);
				int insertRowCount = guestService.insertGuest(guest);
				
				/***********CASE1****************/
				forwardPath="redirect:guest_list.do";
				
				/************CASE2[pk 반환]********
				pk = guest.getGuest_no();        //이거 왜 안되징 ㅠ.ㅠ
				System.out.println("########## pk가 잘 들어오나요? -->> "+pk);
				forwardPath="redirect:guest_views.do?guest_no="+pk; 
				******************************/
			} catch (Exception e) {
				e.printStackTrace();
				forwardPath="redirect:guest_error.do";
			}
		}
		return new ModelAndView(forwardPath);
	}

}
