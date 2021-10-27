package com.itwill.controller.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionControllerLocal {
	
	
	@RequestMapping("/business1.do")
	public String business_method1() throws BusinessException1{
		boolean b=true;
		if(b) {
			
			throw new BusinessException1("업무예외1발생");
		}
		
		return "business_result1";
	}
	@RequestMapping("/business2.do")
	public String business_method2() throws BusinessException2 {
		boolean b=true;
		if(b) {
			
			throw new BusinessException2("업무예외2발생");
		}
		
		return "business_result2";
	}
	@RequestMapping("/business3.do")
	public String business_method3() throws NullPointerException{
		String name=null;
		int length = name.length();
		return "business_result3";
	}
	
	
	/*################@ExceptionHandler##########################*/
	
	
	
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
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("error_msg", e.getMessage());
		//modelAndView.setViewName("forward:/WEB-INF/view/business_error_result.jsp");
		modelAndView.setViewName("business_error_result");
		
		return modelAndView;
	}
	
	
	
	
	
	
	
	
	
	
	
}
