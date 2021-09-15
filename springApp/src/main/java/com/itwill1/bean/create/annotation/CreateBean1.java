package com.itwill1.bean.create.annotation;

import org.springframework.stereotype.Component;

@Component(value = "createBean1")
public class CreateBean1 {
	public CreateBean1() {
		System.out.println("### CreateBean1()기본생성자");
	}
}