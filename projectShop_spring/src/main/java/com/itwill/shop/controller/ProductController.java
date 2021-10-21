package com.itwill.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.shop.product.Product;
import com.itwill.shop.product.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/product_list")
	public String product_list(Model model) throws Exception{
		List<Product> productList=productService.getProductList();
		model.addAttribute("productList", productList);
		return "product_list";
	}
	
	/*
	@RequestMapping(value = "/product_detail",headers="content-type=text/plain")
	@RequestMapping(value = "/product_detail",headers="content-type=xml/*")
	@RequestMapping(value = "/product_detail",headers="content-type=html/*")
	@RequestMapping(value = "/product_detail",params ="p_no=1")
	@RequestMapping(value = "/product_detail",params ="p_no!=1")
	@RequestMapping(value = "/product_detail",params ="p_no")
	@RequestMapping(value = "/product_detail",params ="!p_no")
	*/
	
	@RequestMapping(value = "/product_detail",params ="!p_no")
	public String product_detail_no_param() {
		return "redirect:product_list";
	}
	
	// params에 배열매핑 params={"", "", "", ""}
	@RequestMapping(value = "/product_detail", params ="p_no")
	public String product_detail(@RequestParam(value="p_no") int p_no,Model model) throws Exception{
		/* 예전엔 이렇게 했었자낭
		if(p_no==-1) {
			//p_no 파라메타가 없는 경우
			return "product_list";
		}
		*/
		Product product=productService.getProduct(p_no);
		model.addAttribute("product", product);
		return "product_detail";
	}
}
