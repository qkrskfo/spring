package com.itwill.littlecinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.itwill.littlecinema.controller.intercepter.LoginCheck;
import com.itwill.littlecinema.service.interface_service.MemberService;

@Controller
public class MemberInfoController {

	@Autowired
	private MemberService memberService;

	@LoginCheck
	@RequestMapping(value = "/member_info")
	public String member_info(@SessionAttribute("sMemberId") String sMemberId, Model model) throws Exception {
		System.out.println(memberService.findMember(sMemberId));
		model.addAttribute("loginMember",memberService.findMember(sMemberId));
		return "member_info";
	}

}
