package com.itwill.controller.annotation;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller(value="helloController1")
public class HelloAnnotationController1 {
	public HelloAnnotationController1() {
		System.out.println("### HelloAnnotationController1() 생성자");
	}
	
	@RequestMapping(value="/hello1.do")
	public String hello1(HttpServletRequest request) {
		System.out.println("### HelloAnnotationController1.hello1()호출");
		request.setAttribute("msg", "안녕 HelloAnnotationController1");
		return "forward:/WEB-INF/views/hello1.jsp";
	}
}