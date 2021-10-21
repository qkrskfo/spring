package com.itwill.shop.product.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.shop.product.ProductDao;

public class ProductDaoTestMain {

	public static void main(String[] args) throws Exception{
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("spring/application-config.xml");
		ProductDao productDao=(ProductDao)applicationContext.getBean("productDao");
		System.out.println(productDao);
		
		System.out.println("1. product List: "+productDao.getProductList());
		System.out.println("2. product Detail: "+productDao.getProduct(1));
	}

}
