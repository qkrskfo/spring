package com.itwill.controller.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller(value = "helloController1")
public class HelloAnnotationController1 {
	public HelloAnnotationController1() {
		System.out.println("### HelloAnnotationController1() 생성자");
	}
	@RequestMapping(value = "/hello1.do")
	public String hello1() {
		System.out.println("### HelloAnnotationController1.hello1()호출");
		return "forward:/WEB-INF/views/hello1.jsp";
	}
}