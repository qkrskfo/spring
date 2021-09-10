package com.itwill3.dao.user;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUserDaoImplJDBCTestMain {

	public static void main(String[] args) throws Exception {
	
	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/itwill3/dao/user/3.user_dao_jdbc.xml");
	UserDao userDao = (UserDao)applicationContext.getBean("userDao");
	
	//userDao.create(new User(null, null, null, null));
	//userDao.findUser("summer");
	//userDao.findUserList();
	
	System.out.println("### "+userDao.findUser("summer"));
	System.out.println("### "+userDao.findUserList());
	
	}

}
