package com.itwill3.dao.user;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringUserDaoImplSpringDaoTestMain {

	public static void main(String[] args)  throws Exception{
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("com/itwill3/dao/user/3.user_dao_springdao.xml");
		UserDao userDao=(UserDao)applicationContext.getBean("userDao");
		System.out.println(userDao.findUserList());
		System.out.println(userDao.findUser("guard2"));
				
		

	}

}