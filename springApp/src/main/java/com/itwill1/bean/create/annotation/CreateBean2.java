package com.itwill1.bean.create.annotation;

import org.springframework.stereotype.Component;

@Component(value="createBean2")
public class CreateBean2 {

	public CreateBean2() {
		System.out.println("### CreateBean2() 기본생성자");
	}
	
}
