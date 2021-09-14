package com.itwill.hello;

public class HelloService {
	private HelloDao helloDao;
	public HelloService() {
		System.out.println("2. ### HelloService()생성자");	
	}
	public void setHelloDao(HelloDao helloDao) {
		System.out.println("3. ### HelloService.setHelloDao("+helloDao+") 메쏘드 호출");	
		this.helloDao = helloDao;
	}
	
	public void hello() {
		System.out.println("B. ### HelloService.hello() 메소드 호출");
		helloDao.hello();
	}
	
	
}