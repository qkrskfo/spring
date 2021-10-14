package com.itwill.user.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserGlobalExceptionController {
	@ExceptionHandler(Exception.class)
	public String user_global_exception_handler(Exception e) {
		return "user_error";
	}
}
