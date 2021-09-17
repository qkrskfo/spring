package com.itwill.guest.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GuestGlobalExceptionControllerAdvice {
	@ExceptionHandler(Exception.class)
	public String handle_exception(Exception e) {
		return "guest_error";
	}
}