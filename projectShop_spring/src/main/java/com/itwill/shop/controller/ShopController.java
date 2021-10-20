package com.itwill.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShopController {
	@RequestMapping(value = "/shop_main")
	public String user_main() {
		return "shop_main";
	}
}
