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
	public String model_attribute_guest_write_action() {
		
		return "forward:/WEB-INF/views/guest_write_result.jsp";
	}
	
	
	
	
	@RequestMapping(value="/parameter_guest_write_action.do",method=RequestMethod.POST)
	public String parameter_guest_write_action( @RequestParam("guest_name") String name,
												@RequestParam("guest_title") String guest_title,
												@RequestParam("guest_email") String guest_email,
												@RequestParam String guest_homepage,
												@RequestParam String guest_content) {
		/*
		 << @RequestParam >>
			String guest_name = request.getParameter("guest_name");
			String guest_email = request.getParameter("guest_email");
			String guest_homepage = request.getParameter("guest_homepage");
			String guest_title = request.getParameter("guest_title");
			String guest_content = request.getParameter("guest_content");
		 */
		Guest guest=new Guest(0, name, null, guest_email, guest_homepage, guest_title, guest_content);
		/*
		 * GuestService메쏘드호출
		 */
		System.out.println("### @RequestParam ###");
		System.out.println("### guest:"+guest);
		return "forward:/WEB-INF/views/guest_write_result.jsp";
	}
}

