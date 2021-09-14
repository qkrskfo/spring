package com.itwill.user.client;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.user.User;
import com.itwill.user.UserService;

public class UserServiceClient {
	public static void main(String[] args) throws Exception{
		System.out.println("-- ApplicationContext 초기화 전 --");
		ApplicationContext applicationContext = 
			new ClassPathXmlApplicationContext("com/itwill/user/client/99.user.xml");
		System.out.println("-- ApplicationContext 초기화 후 --");
	
	}
}