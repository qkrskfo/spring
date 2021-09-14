package com.itwill.hello.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.itwill.hello.HelloService;

public class HelloController implements Controller {
	
	private HelloService helloService;
	
	public HelloController() {
		System.out.println("### HelloController() 생성자");
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("### HelloController.handleRequest() 호출");
		
		request.setAttribute("msg", "안녕 SpringMvc");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("forward:/WEB-INF/views/hello.jsp");
		return mv;
	}
	
	

}
