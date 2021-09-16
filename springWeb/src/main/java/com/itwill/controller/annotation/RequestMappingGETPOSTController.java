package com.itwill.controller.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RequestMappingGETPOSTController {

	@RequestMapping(value="/login.do", method = RequestMethod.GET)
	public String login_form_get() {
		return "forward:/WEB-INF/views/get_login_form.jsp";
	}
	
	@RequestMapping(value="/login.do", method = RequestMethod.POST)
	public String login_ation_post() {
		
		return "forward:/WEB-INF/views/post_login_result.jsp";
	}
	
}
