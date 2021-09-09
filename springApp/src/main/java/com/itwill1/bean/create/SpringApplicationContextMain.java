package com.itwill1.bean.create;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplicationContextMain {

	public static void main(String[] args) {
		/*
		 * ApplicationContext[BeanFactory]
		 *  - Spring Container 객체생성
		 */
		
		System.out.println("Spring Container 초기화 시작");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/itwill1/bean/create/1.bean_create.xml");
		System.out.println("Spring container 초기화 끝");

	}

}
