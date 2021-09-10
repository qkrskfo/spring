package com.itwill3.dao.guest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringGuestDaoImplJDBCTestMain {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/itwill3/dao/guest/3.guest_dao_jdbc.xml");
		
	}
	
}
