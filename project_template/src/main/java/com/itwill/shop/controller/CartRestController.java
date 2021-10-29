package com.itwill.shop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.shop.cart.CartItem;
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
	@RequestMapping(value = "cart_rest",produces = "application/json;charset=UTF-8")
	public List<CartItem> cart_item_count(HttpSession session)throws Exception {
		String sUserId=(String)session.getAttribute("sUserId");
		List<CartItem> cartItemList=cartService.getCartList(sUserId);
		return cartItemList;
	}
	@LoginCheck
	@RequestMapping(value = "cart_add_action_rest",produces = "text/plain;charset=UTF-8")
	public String cart_add_action(@RequestParam int p_no,@RequestParam int cart_qty,HttpSession session)throws Exception {
		String result="false";
		String sUserId=(String)session.getAttribute("sUserId");
		cartService.addCart(sUserId,p_no,cart_qty);
		result="true";
		return result;
	}
	@LoginCheck
	@PostMapping(value = "cart_delete_item_action_rest",produces = "text/plain;charset=UTF-8")
	public String cart_delete_item_action_rest(@RequestParam int cart_no)throws Exception {
		String result="false";	
		cartService.deleteCartItem(cart_no);
		result="true";
		return result;
		}
}
