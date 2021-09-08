package com.itwill.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;
import com.itwill.summer.Controller;

public class GuestWriteActionController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
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
				GuestService guestService = new GuestService();
				int insertRowCount = guestService.insertGuest(guest);
				int pk = guest.getGuest_no();
				//forwardPath="redirect:guest_list.do";
				forwardPath="redirect:guest_view.do?guest_no="+pk;
			} catch (Exception e) {
				e.printStackTrace();
				forwardPath="redirect:guest_error.do";
			}
		}
		return forwardPath;
	}

}
