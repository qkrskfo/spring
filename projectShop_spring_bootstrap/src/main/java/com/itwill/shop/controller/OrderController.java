package com.itwill.shop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.itwill.shop.cart.CartItem;
import com.itwill.shop.cart.CartService;
import com.itwill.shop.controller.interceptor.LoginCheck;
import com.itwill.shop.order.Address;
import com.itwill.shop.order.Card;
import com.itwill.shop.order.Order;
import com.itwill.shop.order.OrderService;

import com.itwill.shop.user.User;
import com.itwill.shop.user.UserService;

@SessionAttributes({ "order", "address", "card" })
@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private UserService userService;
	
	@Autowired
	private CartService cartService;

	@ModelAttribute("order")
	public Order setUpOrder() {
		return new Order();
	}

	@ModelAttribute("address")
	public Address setUpAddress() {
		return new Address();
	}

	@ModelAttribute("card")
	public Card setUpCard() {
		return new Card();
	}

	// @LoginCheck
	// @GetMapping(value =
	// {"/order_create_action","/order_create_form","/order_delete_action","/order_delete_all_action"}
	// )
	public String order_create_action() {
		return "redirect:order_list";
	}

	@LoginCheck
	@RequestMapping(value = "/checkout-address")
	public String checkout_address(Model model, HttpSession session) throws Exception {
		String sUserId = (String) session.getAttribute("sUserId");
		User loginUser = userService.findUser(sUserId);
		List<CartItem> cartItemList = cartService.getCartList(sUserId);
		int cartTotPrice = 0;
		for (CartItem cartItem : cartItemList) {
			cartTotPrice += cartItem.getCart_qty() * cartItem.getProduct().getP_price();
		}
		model.addAttribute("loginUser", loginUser);
		model.addAttribute("cartItemList", cartItemList);
		model.addAttribute("cartTotPrice", cartTotPrice);
		return "checkout-address";
	}

	@LoginCheck
	@RequestMapping(value = "/checkout-shipping")
	public String checkout_shipping(@ModelAttribute("order") Order order, @ModelAttribute("address") Address address,
			Model model, HttpSession session) throws Exception {

		order.setAddress(address);

		String sUserId = (String) session.getAttribute("sUserId");
		User loginUser = userService.findUser(sUserId);
		List<CartItem> cartItemList = cartService.getCartList(sUserId);
		int cartTotPrice = 0;
		for (CartItem cartItem : cartItemList) {
			cartTotPrice += cartItem.getCart_qty() * cartItem.getProduct().getP_price();
		}
		model.addAttribute("loginUser", loginUser);
		model.addAttribute("cartItemList", cartItemList);
		model.addAttribute("cartTotPrice", cartTotPrice);

		return "checkout-shipping";
	}

	@LoginCheck
	@RequestMapping(value = "/checkout-payment")
	public String checkout_payment(@ModelAttribute("order") Order order, Model model, HttpSession session)
			throws Exception {

		String sUserId = (String) session.getAttribute("sUserId");
		User loginUser = userService.findUser(sUserId);
		List<CartItem> cartItemList = cartService.getCartList(sUserId);
		int cartTotPrice = 0;
		for (CartItem cartItem : cartItemList) {
			cartTotPrice += cartItem.getCart_qty() * cartItem.getProduct().getP_price();
		}
		model.addAttribute("loginUser", loginUser);
		model.addAttribute("cartItemList", cartItemList);
		model.addAttribute("cartTotPrice", cartTotPrice);

		return "checkout-payment";
	}

	@LoginCheck
	@RequestMapping(value = "/checkout-review")
	public String checkout_review(@SessionAttribute("order") Order order, @ModelAttribute("card") Card card,
			Model model, HttpSession session) throws Exception {

		order.setCard(card);

		String sUserId = (String) session.getAttribute("sUserId");
		User loginUser = userService.findUser(sUserId);
		List<CartItem> cartItemList = cartService.getCartList(sUserId);
		int cartTotPrice = 0;
		for (CartItem cartItem : cartItemList) {
			cartTotPrice += cartItem.getCart_qty() * cartItem.getProduct().getP_price();
		}
		model.addAttribute("loginUser", loginUser);
		model.addAttribute("cartItemList", cartItemList);
		model.addAttribute("cartTotPrice", cartTotPrice);
		

		return "checkout-review";
	}

	@LoginCheck
	@RequestMapping(value = "/checkout-complete")
	public String checkout_complete(@SessionAttribute("order") Order order, Model model, HttpSession session)
			throws Exception {
		String sUserId = (String) session.getAttribute("sUserId");
		orderService.create(sUserId);
		
		System.out.println(order);
		
		User loginUser = userService.findUser(sUserId);
		List<CartItem> cartItemList = cartService.getCartList(sUserId);
		int cartTotPrice = 0;
		for (CartItem cartItem : cartItemList) {
			cartTotPrice += cartItem.getCart_qty() * cartItem.getProduct().getP_price();
		}
		model.addAttribute("loginUser", loginUser);
		model.addAttribute("cartItemList", cartItemList);
		model.addAttribute("cartTotPrice", cartTotPrice);

		return "checkout-complete";
	}

	@LoginCheck
	@RequestMapping(value = "/account-orders")
	public String order_list(HttpSession session, Model model) throws Exception {
		String sUserId = (String) session.getAttribute("sUserId");
		List<Order> orderList = orderService.list(sUserId);
		List<CartItem> cartItemList = cartService.getCartList(sUserId);
		User loginUser = userService.findUser(sUserId);
		int cartTotPrice = 0;
		for (CartItem cartItem : cartItemList) {
			cartTotPrice += cartItem.getProduct().getP_price() * cartItem.getCart_qty();
		}

		model.addAttribute("loginUser", loginUser);
		model.addAttribute("cartItemList", cartItemList);
		model.addAttribute("cartTotPrice", cartTotPrice);
		model.addAttribute("orderList", orderList);
		return "account-orders";
	}

	// @LoginCheck
	// @RequestMapping(value = "/order_detail",params = "!o_no" )
	public String order_detail_no_param() throws Exception {
		return "redirect:order_list";
	}

	// @LoginCheck
	// @RequestMapping(value = "/order_detail" )
	public String order_detail(@RequestParam int o_no, HttpSession session, Model model) throws Exception {
		String sUserId = (String) session.getAttribute("sUserId");
		Order order = orderService.detail(sUserId, o_no);
		model.addAttribute("order", order);
		return "order_detail";
	}

	// @LoginCheck
	// @PostMapping(value = "/order_delete_action" )
	public String order_delete_action(@RequestParam int j_no) throws Exception {
		orderService.deleteByOrderNo(j_no);
		return "redirect:order_list";
	}

	// @LoginCheck
	// @PostMapping(value = "/order_delete_all_action" )
	public String order_delete_allaction(HttpSession session) throws Exception {
		String sUserId = (String) session.getAttribute("sUserId");
		orderService.delete(sUserId);
		return "redirect:order_list";
	}
}
