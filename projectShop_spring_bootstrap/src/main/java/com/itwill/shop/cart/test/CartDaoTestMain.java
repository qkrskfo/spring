package com.itwill.shop.cart.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.shop.cart.CartDao;
import com.itwill.shop.product.ProductDao;
import com.itwill.shop.user.User;
import com.itwill.shop.user.UserDao;
import com.itwill.shop.user.UserDaoMyBatisImpl;

public class CartDaoTestMain {

	public static void main(String[] args) throws Exception{
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("spring/application-config.xml");
		CartDao cartDao=(CartDao)applicationContext.getBean("cartDao");
		System.out.println(cartDao);
		System.out.println(cartDao.getCartList("guard1"));
	}
}
