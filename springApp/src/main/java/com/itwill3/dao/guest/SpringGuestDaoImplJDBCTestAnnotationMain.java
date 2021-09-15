package com.itwill3.dao.guest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringGuestDaoImplJDBCTestAnnotationMain {

	public static void main(String[] args) throws Exception {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/itwill3/dao/guest/3.guest_dao_jdbc_annotation.xml");
		GuestDao guestDao = (GuestDao)applicationContext.getBean("guestDao");
		System.out.println("### "+guestDao.selectAll());
		System.out.println("### "+guestDao.selectByNo(2));
	}
	
}
