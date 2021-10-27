package com.itwill.hello;

import java.util.ArrayList;
import java.util.List;

public class HelloDao {
	public HelloDao() {
		System.out.println("1.#### HelloDao()생성자");
	}
	
	public List<HelloDto> helloList() {
		System.out.println("C . ### HelloDao.helloList()메쏘드호출");
		
		List<HelloDto> helloList=
				new ArrayList<HelloDto>();
		helloList.add(new HelloDto("안녕"));
		helloList.add(new HelloDto("Hello"));
		helloList.add(new HelloDto("Nihao"));
		helloList.add(new HelloDto("Bonjour"));
		return helloList;
	}
}
