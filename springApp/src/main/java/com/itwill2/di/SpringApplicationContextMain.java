package com.itwill2.di;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.user.UserService;

public class SpringApplicationContextMain {

	public static void main(String[] args) throws Exception{
		/*
		 * ApplicationContext[BeanFactory]객체생성
		 *  - Spring Container객체생성
		 */
		System.out.println("------------Spring Container초기화시작----------------");
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("com/itwill2/di/2.bean_dependency_injection.xml");
		System.out.println("------------Spring Container초기화끝------------------");
		
		System.out.println("### 1. Setter Injection(setter 메소드를 통한 의존성 주입)");
		UserService userService=(UserService)applicationContext.getBean("userService");
		userService.findUser(null);
		userService.findUserList();
		
		System.out.println("### 2. Constructor Injection(생성자를 통한 의존성 주입)");
		UserService conUserService=(UserService)applicationContext.getBean("conUserService");
		userService.findUser(null);
		userService.findUserList();
		
	}

}