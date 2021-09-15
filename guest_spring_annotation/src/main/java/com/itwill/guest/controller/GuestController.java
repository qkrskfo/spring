package com.itwill.guest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	//이름은 내 마음대로 하면 되는거야
	@RequestMapping("/guest_main.do")
	public String guest_main() {
		return "forward:/WEB-INF/views/guest_main.jsp";
	}
	
}
