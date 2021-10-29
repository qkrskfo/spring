package com.itwill.shop.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice
public class ShopGlobalExceptionController {
	@ExceptionHandler(Exception.class)
	public String shop_global_exception_handler(Exception e) {
		return "shop_error";
	} 
}
