package com.itwill0.context;

public class javaApplicationMain {

	public static void main(String[] args) {
		ProductService productService = new ProductService();
		System.out.println(productService.productList());
	}
	
}
