package com.itwill.shop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.shop.cart.CartItem;
import com.itwill.shop.cart.CartService;
import com.itwill.shop.controller.interceptor.LoginCheck;
import com.itwill.shop.product.Product;
import com.itwill.shop.user.User;

@Controller
public class CartController {
	@Autowired
	private CartService cartService;
	@LoginCheck
	@RequestMapping(value = "cart_view")
	public String cart_view(HttpSession session,Model model)throws Exception {
		String sUserId=(String)session.getAttribute("sUserId");
		List<CartItem> cartItemList=cartService.getCartList(sUserId);
		model.addAttribute("cartItemList", cartItemList);
		return "cart_view";
	}
	@LoginCheck
	@RequestMapping(value = "cart_view_select_update_qyt_image")
	public String cart_view_select_update_qyt_image(HttpSession session,Model model)throws Exception {
		String sUserId=(String)session.getAttribute("sUserId");
		List<CartItem> cartItemList=cartService.getCartList(sUserId);
		model.addAttribute("cartItemList", cartItemList);
		return "cart_view_select_update_qyt_image";
	}
	@LoginCheck
	@PostMapping(value = "cart_add_action")
	public String cart_add_action(@RequestParam int p_no,@RequestParam int cart_qty,HttpSession session)throws Exception {
		String sUserId=(String)session.getAttribute("sUserId");
		cartService.addCart(sUserId,p_no,cart_qty);
		return "redirect:cart_view";
	}
	@LoginCheck
	@PostMapping(value = "cart_update_item_action")
	public String cart_update_item_action(@RequestParam int cart_no,@RequestParam int cart_qty)throws Exception {
		if(cart_qty==0) {
			cartService.deleteCartItem(cart_no);
		}else {
			System.out.println("CartController:"+cart_no+"-->"+cart_qty);
			cartService.updateCart(cart_no, cart_qty);
		}
		return "redirect:cart_view_select_update_qyt_image";
	}
	@LoginCheck
	@PostMapping(value = "cart_delete_item_action")
	public String cart_delete_item_action(@RequestParam int cart_no)throws Exception {
		cartService.deleteCartItem(cart_no);
		//return "redirect:cart_view";
		return "redirect:cart_view_select_update_qyt_image";
	}
	@LoginCheck
	@PostMapping(value = "cart_delete_action")
	public String cart_delete_action(HttpSession session)throws Exception {
		String sUserId=(String)session.getAttribute("sUserId");
		cartService.deleteCart(sUserId);
		return "redirect:cart_view";
	
	}
	
	
}
