package com.itwill.controller.annotation;

import org.springframework.web.bind.annotation.RequestMapping;

public class ExceptionControllerLocal {

	@RequestMapping("/business1.do")
	public String business_method1() {
		return "business_result1";
	}
	
	@RequestMapping("/business2.do")
	public String business_method2() {
		return "business_result2";
	}
	
}
