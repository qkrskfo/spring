package com.itwill.littlecinema.service;

import java.text.SimpleDateFormat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwill.littlecinema.domain.Member;
import com.itwill.littlecinema.service.interface_service.MemberService;
import com.itwill.littlecinema.service.interface_service.ReviewService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-config.xml")
public class MemberServiceTest {
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	ReviewService reviewService;
	
	@Test
	public void memberServiceTest() throws Exception {
		
		//Member addMember = new Member("iampnr", "1111", "박나래", "010-1111-1111", new SimpleDateFormat("yyyy/MM/dd").parse("2020/07/19"));
		//System.out.println("회원가입"+memberService.add(addMember));
		
		//System.out.println("회원정보"+memberService.findMember("iampnr"));
		
		//Member modifyMember = new Member("iampnr", "1111", "박나래", "01033334333", new SimpleDateFormat("yyyy/MM/dd").parse("2020/07/19"));
		//System.out.println("회원정보수정"+memberService.modify(modifyMember));
		
		//System.out.println("회원탈퇴"+memberService.remove("iampnr"));
		
		System.out.println("리뷰갯수"+ reviewService.selectByReviewCount("test"));
	}
}
