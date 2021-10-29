package com.itwill.shop.product.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.shop.product.ProductDao;
import com.itwill.shop.user.User;
import com.itwill.shop.user.UserDao;
import com.itwill.shop.user.UserDaoMyBatisImpl;

public class ProductDaoTestMain {

	public static void main(String[] args) throws Exception{
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("spring/application-config.xml");
		ProductDao productDao=(ProductDao)applicationContext.getBean("productDao");
		System.out.println(productDao);
		System.out.println("1.product list:"+productDao.getProductList());
		System.out.println("2.product detail:"+productDao.getProduct(1));
		
		
	}

}
