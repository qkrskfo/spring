package com.itwill0.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplicationMain {

	public static void main(String[] args) {
		/*
		 * 
		 */
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/itwill0/context/0.applicationContext.xml");
		System.out.println(applicationContext);
		
		ProductService productService = (ProductService)applicationContext.getBean("productService");
		System.out.println(productService.productList());
	}
	
}
