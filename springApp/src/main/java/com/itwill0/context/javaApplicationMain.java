package com.itwill0.context;

public class javaApplicationMain {

	public static void main(String[] args) {
		ProductDao productDao = new ProductDao();
		ProductService productService = new ProductService();
		
		productService.setProductDao(productDao); //dependency injection?
		System.out.println(productService.productList());
	}
	
}
