package com.itwill.shop.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.shop.cart.CartService;
import com.itwill.shop.controller.interceptor.LoginCheck;
import com.itwill.shop.user.User;
import com.itwill.shop.user.UserService;
@RestController
public class CartRestController {
	@Autowired
	private CartService cartService;
	@Autowired 
	private UserService userService;
	
	@LoginCheck
	@RequestMapping(value = "cart_item_count",produces = "application/json;charset=UTF-8")
	public Map cart_item_count(HttpSession session,Model model)throws Exception {
		String sUserId=(String)session.getAttribute("sUserId");
		User sUser=userService.findUser(sUserId);
		int cart_item_count = cartService.getCartList(sUserId).size();
		Map map=new HashMap();
		map.put("user_name", sUser.getName());
		map.put("cart_item_count", cart_item_count);
		
		return map;
	}
}
