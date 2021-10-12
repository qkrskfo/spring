package com.itwil.ajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping(value="02.ajaxRequest.do")
	public String ajaxRequest() {
		return "forward:/WEB-INF/views/02.ajaxRequest.jsp";
	}
}
