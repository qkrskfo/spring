package com.itwill.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShopController {
	
	
	@RequestMapping(value = "/index")
	public String index() {
		System.out.println("------------------->index");
		return "index";
	}
	@RequestMapping(value = "/shop-grid-ns")
	public String shop() {
		System.out.println("------------------->shop");
		return "shop-grid-ns";
	}
	@RequestMapping(value = "/shop-single")
	public String shop_single() {
		System.out.println("------------------->shop-single");
		return "shop-single";
	}
	
}
