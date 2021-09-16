package com.itwill.controller.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.dto.Guest;

@Controller
public class RequestMappingParameterController {
	@RequestMapping("/parameter_guest_write_form.do")
	public String parameter_guest_write_form() {
		
		return "forward:/WEB-INF/views/guest_write_form.jsp";
	}
	
	@RequestMapping(value="/parameter_guest_write_action.do", method = RequestMethod.POST)
	public String parameter_guest_write_action(@RequestParam("guest_name") String guest_name, 
			@RequestParam("guest_title") String guest_title, @RequestParam("guest_email") String guest_email,
			@RequestParam String guest_homepage, @RequestParam String guest_content) {
		
		Guest guest = new Guest(0, guest_name, null, guest_email, guest_homepage, guest_title, guest_content);
		System.out.println("### guest:"+guest);
		System.out.println("### @RequestParam ###");
		return "forward:/WEB-INF/views/guest_write_result.jsp";
	}
}
