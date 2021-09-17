package com.itwill.controller.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionControllerLocal {
	
	@RequestMapping("/business1.do")
	public String business_method1() throws BusinessException1 {
		boolean b = true;
		if(b) {
			throw new BusinessException1("업무예외1 발생");
		}
		return "business_result1";
	}
	
	@RequestMapping("/business2.do")
	public String business_method2() throws BusinessException2 {
		boolean b = true;
		if(b) {
			throw new BusinessException2("업무예외2 발생");
		}
		return "business_result2";
	}
	
	@RequestMapping("/business3.do")
	public String business_method3() {
		String name = null;
		int length = name.length();
		return "business_result3";
	}
	
	/*######## @Exception Handler #######*/
	@ExceptionHandler(Exception.class)
	public String handle_exception(Exception e) {
		return "global_error_result";
	}
	
	@ExceptionHandler(RuntimeException.class)
	public String handle_runtime_exception(RuntimeException e) {
		return "global_error_result";
	}
	
	@ExceptionHandler(BusinessException1.class)
	public String handle_business_exception1(BusinessException1 e) {
		//return "forward:/WEB-INF/views/business_error_result.jsp";
		return "business_error_result";
	}
	/*
	@ExceptionHandler(BusinessException2.class)
	public String handle_business_exception2(BusinessException2 e) {
		//return "forward:/WEB-INF/views/business_error_result.jsp";
		return "business_error_result";
	}
	*/
	
	@ExceptionHandler(BusinessException2.class)
	public ModelAndView handle_business_exception2(BusinessException2 e) {
		
		ModelAndView modelAndView = new ModelAndView();
		//내가 인자를 받을 수 없을때는 modelandview를 리턴하게하면 됨
		modelAndView.addObject("error_msg", e.getMessage());
		modelAndView.setViewName("business_error_result");
		//return "forward:/WEB-INF/views/business_error_result.jsp";
		//return "business_error_result";
		return modelAndView;
	}
	
}
