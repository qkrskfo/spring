package com.itwill.littlecinema.repository;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwill.littlecinema.domain.Member;
import com.itwill.littlecinema.repository.interface_dao.MemberDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-config.xml")
public class MemberDaoTest {

	@Autowired
	private MemberDao md;
	
	@Test
	public void memberDaoTest() throws Exception {
		
		System.out.println("--------- select ---------");
		System.out.println(md.select("test"));
		
		System.out.println("--------- insert ---------");
		Member member = new Member("hyub", "0000", "유재협", "010-0000-1111", new Date());
		System.out.println(md.insert(member));
		
		System.out.println("--------- select ---------");
		Member m = md.select("hyub");
		System.out.println("id: " + m.getId() + ", password: " + m.getPassword() + ", name: " + m.getName());
		
		System.out.println("--------- update ---------");
		member.setPassword("1111");
		System.out.println(md.update(member));
		
		System.out.println("--------- select ---------");
		m = md.select("hyub");
		System.out.println("id: " + m.getId() + ", password: " + m.getPassword() + ", name: " + m.getName());
		
		System.out.println("--------- delete ---------");
		System.out.println(md.delete("hyub"));
		
		System.out.println("--------- select ---------");
		System.out.println(md.select("hyub"));
		
	}
}
