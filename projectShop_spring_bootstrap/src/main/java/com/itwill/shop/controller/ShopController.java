package com.itwill.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.shop.product.Product;
import com.itwill.shop.product.ProductService;

@Controller
public class ShopController {
	@Autowired
	private ProductService productService;
	@RequestMapping(value = "/index")
	public String user_main(Model model) throws Exception{
		List<Product> productList=productService.getProductList();
		model.addAttribute("productList", productList);
		System.out.println("---------------------");
		return "index";
	}
}
