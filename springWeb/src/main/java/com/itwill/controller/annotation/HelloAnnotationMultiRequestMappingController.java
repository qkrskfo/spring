package com.itwill.controller.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloAnnotationMultiRequestMappingController {
	
	@RequestMapping(value = "/hello3.do")
	public String hello3() {
		return "forward:/WEB-INF/views/hello3.jsp";
	}
	@RequestMapping(value = "/hello4.do")
	public String hello4() {
		return "forward:/WEB-INF/views/hello4.jsp";
	}
	@RequestMapping(value = "/hello5.do")
	public String hello5() {
		return "forward:/WEB-INF/views/hello5.jsp";
	}
	/*
	 servlet[*.do]-->redirect[*.do]-->servlet[*.do]-->jsp
	 */
	@RequestMapping("/hello_redirect_servlet.do")
	public String hello_redirect_servlet() {
		return "redirect:hello_redirected_servlet.do";
	}
	@RequestMapping("/hello_redirected_servlet.do")
	public String hello_redirected_servlet() {
		return "forward:/WEB-INF/views/hello_redirected_servlet.jsp";
	}
	
	
}