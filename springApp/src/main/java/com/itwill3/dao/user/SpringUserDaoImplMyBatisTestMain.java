package com.itwill3.dao.user;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringUserDaoImplMyBatisTestMain {

	public static void main(String[] args)  throws Exception{
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("com/itwill3/dao/user/3.user_dao_mybatis.xml");
		UserDao userDao=(UserDao)applicationContext.getBean("userDao");
		/*
		System.out.println("-------userDao.findUserList()------");
		System.out.println(userDao.findUserList());
		System.out.println("-------userDao.create()------");
		System.out.println(userDao.create(new User("vvvv", "vvvv", "브이", "v@gmail.com")));
		System.out.println("-------userDao.findUser()------");
		System.out.println(userDao.findUser("vvvv"));
		System.out.println("-------userDao.upadte()------");
		System.out.println(userDao.update(new User("vvvv", "vvvv", "브이수정", "changev@gmail.com")));
		System.out.println(userDao.findUser("vvvv"));
		System.out.println("-------userDao.remove()------");
		System.out.println(userDao.remove("vvvv"));
		System.out.println(userDao.findUserList());
		*/

	}

}