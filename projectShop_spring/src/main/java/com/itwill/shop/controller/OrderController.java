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
import com.itwill.shop.order.Order;
import com.itwill.shop.order.OrderService;
import com.itwill.shop.product.Product;
import com.itwill.shop.product.ProductService;
import com.itwill.shop.user.User;
import com.itwill.shop.user.UserService;

@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private UserService userService;
	@Autowired
	private ProductService productService;
	@Autowired
	private CartService cartService;
	
	@LoginCheck
	@GetMapping(value = {"/order_create_action","/order_create_form","/order_delete_action","/order_delete_all_action"} )
	public String order_create_action() {
		return "redirect:order_list";
	}
	
	
	@LoginCheck
	@PostMapping(value = "/order_create_form" )
	public String order_create_form(
			@RequestParam(defaultValue = "") String buyType,
			@RequestParam(defaultValue = "0") int p_no,
			@RequestParam(defaultValue = "0") int p_qty,
			@RequestParam(value = "cart_item_no" ,required = false) int[] cart_item_no_array,
			HttpSession session,
			Model model) throws Exception{
		System.out.println(cart_item_no_array);
		if(cart_item_no_array==null) {
			cart_item_no_array=new int[] {};
		}
		List<CartItem> cartItemList = new ArrayList<CartItem>();
		String sUserId=(String)session.getAttribute("sUserId");
		User user = userService.findUser(sUserId);
		if (buyType.equals("cart")) {
			cartItemList = cartService.getCartList(sUserId);
		} else if (buyType.equals("cart_select")) {
			for (int cart_item_no : cart_item_no_array) {
				cartItemList.add(cartService.getCartItemByCartNo(cart_item_no));
			}
		} else if (buyType.equals("direct")) {
			Product product = productService.getProduct(p_no);
			cartItemList.add(new CartItem(0, user, product,p_qty));
		}
		model.addAttribute("user", user);
		model.addAttribute("cartItemList", cartItemList);
		return "order_create_form";
	}
	
	@PostMapping(value = "/order_create_action" )
	public String order_create_action(@RequestParam(defaultValue = "") String buyType,
			@RequestParam(defaultValue = "0") int p_no,
			@RequestParam(defaultValue = "0") int p_qty,
			@RequestParam(value = "cart_item_no" ,required = false) int[] cart_item_no_array,
			HttpSession session,
			Model model) throws Exception{
		String sUserId=(String)session.getAttribute("sUserId");
		if(buyType.equals("cart")){
    		orderService.create(sUserId);
    	}else if(buyType.equals("cart_select")){
    		orderService.create(sUserId,cart_item_no_array);	
        }else if(buyType.equals("direct")){
    		orderService.create(sUserId, p_no, p_qty);
    	}
		return "redirect:order_list";
	}
	@LoginCheck
	@RequestMapping(value = "/order_list" )
	public String order_list(HttpSession session,Model model) throws Exception{
		String sUserId=(String)session.getAttribute("sUserId");
		List<Order> orderList=orderService.list(sUserId);
		model.addAttribute("orderList", orderList);
		return "order_list";
	}
	@LoginCheck
	@RequestMapping(value = "/order_detail",params = "!o_no" )
	public String order_detail_no_param() throws Exception{
		return "redirect:order_list";
	}
	@LoginCheck
	@RequestMapping(value = "/order_detail" )
	public String order_detail(@RequestParam int o_no, HttpSession session,Model model) throws Exception{
		String sUserId=(String)session.getAttribute("sUserId");
		Order order = orderService.detail(sUserId,o_no);
		model.addAttribute("order", order);
		return "order_detail";
	}
	@LoginCheck
	@PostMapping(value = "/order_delete_action" )
	public String order_delete_action(@RequestParam int j_no) throws Exception{
		orderService.deleteByOrderNo(j_no);
		return "redirect:order_list";
	}
	@LoginCheck
	@PostMapping(value = "/order_delete_all_action" )
	public String order_delete_allaction(HttpSession session) throws Exception{
		String sUserId=(String)session.getAttribute("sUserId");
		orderService.delete(sUserId);
		return "redirect:order_list";
	}
}