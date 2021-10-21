package com.itwill.shop.cart.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.shop.cart.CartDao;


public class CartDaoTestMain {

	public static void main(String[] args) throws Exception{
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("spring/application-config.xml");
		CartDao cartDao=(CartDao)applicationContext.getBean("cartDao");
		System.out.println(cartDao);
		System.out.println(cartDao.getCartList("guard1"));
	}

}
