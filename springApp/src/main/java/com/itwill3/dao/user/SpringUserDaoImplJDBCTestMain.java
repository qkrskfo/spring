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
	//System.out.println("### "+userDao.create(new User("summer5", "5555", "인서트", "1004@dddd.com")));
	System.out.println("### "+userDao.remove("summer4"));
	System.out.println("### "+userDao.update(new User("summer3", "3333", "수정", "test@ddd.com")));
	
	}

}
