package com.itwill2.di;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplicationContextMain {

	public static void main(String[] args) {
		/*
		 * ApplicationContext[BeanFactory]객체생성
		 *  - Spring Container객체생성
		 */
		System.out.println("------------Spring Container초기화시작----------------");
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("com/itwill1/bean/create/1.bean_create.xml");
		System.out.println("------------Spring Container초기화끝------------------");
		System.out.println("------------------bean create---------------------");
		CreateBean1 createBean1=(CreateBean1)applicationContext.getBean("createBean1");
		System.out.println("#### "+createBean1);
		CreateBean2 createBean2=(CreateBean2)applicationContext.getBean(CreateBean2.class);
		System.out.println("#### "+createBean2);
		System.out.println("------------------scope[singleton]------------------");
		SingletonBean singletonBean1=(SingletonBean)applicationContext.getBean("singletonBean");
		SingletonBean singletonBean2=(SingletonBean)applicationContext.getBean("singletonBean");
		SingletonBean singletonBean3=(SingletonBean)applicationContext.getBean("singletonBean");
		System.out.println(singletonBean1);
		System.out.println(singletonBean2);
		System.out.println(singletonBean3);
		System.out.println("------------------scope[prototype]------------------");
		PrototypeBean prototypeBean1=(PrototypeBean)applicationContext.getBean("prototypeBean");
		PrototypeBean prototypeBean2=(PrototypeBean)applicationContext.getBean("prototypeBean");
		PrototypeBean prototypeBean3=(PrototypeBean)applicationContext.getBean("prototypeBean");
		System.out.println(prototypeBean1);
		System.out.println(prototypeBean2);
		System.out.println(prototypeBean3);
	}

}