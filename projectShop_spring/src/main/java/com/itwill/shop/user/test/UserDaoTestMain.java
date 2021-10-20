package com.itwill.shop.user.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.shop.user.User;
import com.itwill.shop.user.UserDao;

public class UserDaoTestMain {

	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/application-config.xml");
		UserDao userDao = (UserDao)applicationContext.getBean("userDao");
		System.out.println(userDao);
		
		//System.out.println("create-->"+userDao.create(new User("zzz", "zzz", "zzz", "zzz")));
	}

}
