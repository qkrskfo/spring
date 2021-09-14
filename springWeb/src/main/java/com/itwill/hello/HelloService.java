package com.itwill.hello;

public class HelloService {
	private HelloDao helloDao;
	public HelloService() {
		System.out.println("2. ### HelloService()생성자");	
	}
	public void setHelloDao(HelloDao helloDao) {
		System.out.println("3. ### HelloService.setHelloDao("+helloDao+")메쏘드호출");	
		this.helloDao = helloDao;
	}
	
	public void helloList() {
		System.out.println("B . ### HelloService.helloList()메쏘드호출");
		helloDao.helloList();
	}
	
	
}