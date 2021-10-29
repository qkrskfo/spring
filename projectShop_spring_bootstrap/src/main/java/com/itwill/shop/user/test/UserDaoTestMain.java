package com.itwill.shop.user.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.shop.user.User;
import com.itwill.shop.user.UserDao;
import com.itwill.shop.user.UserDaoMyBatisImpl;

public class UserDaoTestMain {

	public static void main(String[] args) throws Exception{
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("spring/application-config.xml");
		UserDao userDao=(UserDao)applicationContext.getBean("userDao");
		System.out.println(userDao);
		//System.out.println("1 . create -->"+userDao.create(new User("yyy", "yyy", "yyy", "yyy")));
		System.out.println("2.findUser -->"+userDao.findUser("yyy"));
	}

}
