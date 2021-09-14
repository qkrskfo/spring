package com.itwill.user.client;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.user.User;
import com.itwill.user.UserService;

public class UserServiceClient {
	public static void main(String[] args) throws Exception{		
		ApplicationContext applicationContext = 
			new ClassPathXmlApplicationContext("99.user.xml");
		UserService userService = (UserService)applicationContext.getBean("userService");
		userService.findUser("id");
		userService.remove("id");
		userService.findUserList();
		
		
	}
}