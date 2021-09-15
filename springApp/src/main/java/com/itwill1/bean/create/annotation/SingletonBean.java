package com.itwill1.bean.create.annotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value="singletonBean")
@Scope(value = "singleton")
public class SingletonBean {

	public SingletonBean() {
		System.out.println("###SingletonBean() 기본생성자 호출"+this);
	}
	
}
