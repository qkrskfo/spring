package com.itwill3.dao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDataSourceMain {

	public static void main(String[] args) {
		/*
		 * ApplicationContext[BeanFactory]객체생성
		 *  - Spring Container객체생성
		 */
		System.out.println("------------Spring Container초기화시작----------------");
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("------------Spring Container초기화끝------------------");

	}

}