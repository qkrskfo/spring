package com.itwill.shop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.shop.cart.CartItem;
import com.itwill.shop.cart.CartService;
import com.itwill.shop.controller.interceptor.LoginCheck;
import com.itwill.shop.product.Product;
import com.itwill.shop.product.ProductService;
import com.itwill.shop.user.User;
import com.itwill.shop.user.UserService;

@Controller
public class CartController {
	@Autowired
	private CartService cartService;
	@Autowired 
	private UserService userService;
	@Autowired 
	private ProductService productService;
	
	@LoginCheck
	@RequestMapping(value = "cart")
	public String cart_view(HttpSession session,Model model)throws Exception {
		String sUserId=(String)session.getAttribute("sUserId");
		User loginUser=userService.findUser(sUserId);
		List<Product> productList=productService.getProductList();
		List<CartItem> cartItemList = cartService.getCartList(sUserId);
		int cartTotPrice=0;
		for (CartItem cartItem : cartItemList) {
				cartTotPrice+=cartItem.getProduct().getP_price()*cartItem.getCart_qty();
		}
		
		model.addAttribute("loginUser", loginUser);
		model.addAttribute("cartItemList", cartItemList);
		model.addAttribute("cartTotPrice", cartTotPrice);
		model.addAttribute("productList", productList);
		return "cart";
	}
	
	//@LoginCheck
	//@RequestMapping(value = "cart_view_select_update_qyt_image")
	public String cart_view_select_update_qyt_image(HttpSession session,Model model)throws Exception {
		String sUserId=(String)session.getAttribute("sUserId");
		List<CartItem> cartItemList=cartService.getCartList(sUserId);
		model.addAttribute("cartItemList", cartItemList);
		return "cart_view_select_update_qyt_image";
	}
	//@LoginCheck
	//@PostMapping(value = "cart_add_action")
	public String cart_add_action(@RequestParam int p_no,@RequestParam int cart_qty,HttpSession session)throws Exception {
		String sUserId=(String)session.getAttribute("sUserId");
		cartService.addCart(sUserId,p_no,cart_qty);
		return "redirect:cart_view";
	}
	//@LoginCheck
	//@GetMapping(value = "cart_add_action_popup_window")
	public String cart_add_action_popup_window_get() {
		return "redierct:product_list";
	}
	//@LoginCheck
	//@PostMapping(value = "cart_add_action_popup_window")
	public String cart_add_action_popup_window_post(@RequestParam int p_no,@RequestParam int cart_qty,HttpSession session)throws Exception {
		String sUserId=(String)session.getAttribute("sUserId");
		cartService.addCart(sUserId,p_no,cart_qty);
		return "cart_add_action_popup_window";
	}
	//@LoginCheck
	//@PostMapping(value = "cart_update_item_action")
	public String cart_update_item_action(@RequestParam int cart_no,@RequestParam int cart_qty)throws Exception {
		if(cart_qty==0) {
			cartService.deleteCartItem(cart_no);
		}else {
			System.out.println("CartController:"+cart_no+"-->"+cart_qty);
			cartService.updateCart(cart_no, cart_qty);
		}
		return "redirect:cart_view_select_update_qyt_image";
	}
	//@LoginCheck
	//@PostMapping(value = "cart_delete_item_action")
	public String cart_delete_item_action(@RequestParam int cart_no)throws Exception {
		cartService.deleteCartItem(cart_no);
		//return "redirect:cart_view";
		return "redirect:cart_view_select_update_qyt_image";
	}
	//@LoginCheck
	//@PostMapping(value = "cart_delete_action")
	public String cart_delete_action(HttpSession session)throws Exception {
		String sUserId=(String)session.getAttribute("sUserId");
		cartService.deleteCart(sUserId);
		return "redirect:cart_view";
	
	}
	
	
}