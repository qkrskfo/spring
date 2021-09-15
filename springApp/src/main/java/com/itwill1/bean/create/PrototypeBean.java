package com.itwill1.bean.create;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value="prototypeBean")
@Scope(value="prototype")
public class PrototypeBean {
	
	public PrototypeBean() {
		System.out.println("#### PrototypeBean()생성자:"+this);
	}

}
