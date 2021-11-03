package com.itwill.littlecinema.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionController {
	
	@ExceptionHandler(Exception.class)
	public String globalException(Exception e) {
		e.printStackTrace();
		return "404";
	} 
	
}
