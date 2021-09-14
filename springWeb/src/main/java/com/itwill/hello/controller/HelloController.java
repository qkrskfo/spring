package com.itwill.hello.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.itwill.hello.HelloService;

public class HelloController implements Controller{
	private HelloService helloService;
	public HelloController() {
		System.out.println("4. ### HelloController()생성자");
	}
	public void setHelloService(HelloService helloService) {
		this.helloService = helloService;
		System.out.println("5. ### HelloController.setHelloService("+helloService+") 메쏘드 호출");
	}



	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("A. ### HelloController.handleRequest()호출");
		
		helloService.hello();
		
		request.setAttribute("msg", "안녕 SpringMVC");
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("forward:/WEB-INF/views/hello.jsp");
		return mv;
	}

}