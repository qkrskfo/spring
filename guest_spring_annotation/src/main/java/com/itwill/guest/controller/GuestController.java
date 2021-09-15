package com.itwill.guest.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

@Controller
public class GuestController {
	
	/*
	<< 요청url (command) >>
	/guest_main.do=com.itwill.guest.controller.GuestMainController
	/guest_write_form.do=com.itwill.guest.controller.GuestWriteFormController
	/guest_write_action.do=com.itwill.guest.controller.GuestWriteActionController
	/guest_list.do=com.itwill.guest.controller.GuestListController
	/guest_view.do=com.itwill.guest.controller.GuestViewController
	/guest_modify_form.do=com.itwill.guest.controller.GuestModifyFormController
	/guest_modify_action.do=com.itwill.guest.controller.GuestModifyActionController
	/guest_remove_action.do=com.itwill.guest.controller.GuestRemoveActionController
	/guest_error.do=com.itwill.guest.controller.GuestErrorController
	*/

	private GuestService guestService;
	
	@Autowired
	public void setGuestService(GuestService guestService) {
		this.guestService = guestService;
	}

	//이름은 내 마음대로 하면 되는거야
	@RequestMapping("/guest_main.do")
	public String guest_main() {
		return "forward:/WEB-INF/views/guest_main.jsp";
	}
	
	@RequestMapping("/guest_list.do")
	public String guest_list(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
		try {
			ArrayList<Guest> guestList = guestService.selectAll();
			request.setAttribute("guestList", guestList);
			forwardPath = "forward:/WEB-INF/views/guest_list.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "forward:/WEB-INF/views/guest_error.jsp";
		}
		return forwardPath;
	}
}
