package com.itwill.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;
import com.itwill.summer.Controller;

public class GuestViewController implements Controller {
	
	public String handleRequest(HttpServletRequest request,HttpServletResponse response) {
		String forwardPath="";
		try {
			request.setCharacterEncoding("UTF-8");
			String guest_noStr=request.getParameter("guest_no");
			GuestService guestService=new GuestService();
			Guest guest=guestService.selectByNo(Integer.parseInt(guest_noStr));
			if(guest==null) {
				request.setAttribute("GUEST_NOT_FOUND_MSG", "존재하지 않는게시물입니다.");
				forwardPath="forward:/WEB-INF/view/guest_view_not_found.jsp";
			}else {
				request.setAttribute("guest",guest);
				forwardPath="forward:/WEB-INF/view/guest_view.jsp";
			}
		}catch (Exception e) {
			e.printStackTrace();
			forwardPath="redirect:guest_error.do";
		}
		return forwardPath;
	}

	
}
