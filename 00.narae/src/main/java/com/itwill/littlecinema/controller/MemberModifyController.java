package com.itwill.littlecinema.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.itwill.littlecinema.controller.intercepter.LoginCheck;
import com.itwill.littlecinema.domain.Member;
import com.itwill.littlecinema.service.interface_service.MemberService;

@Controller
public class MemberModifyController {

	@Autowired
	private MemberService memberService;

	@LoginCheck
	@RequestMapping(value = "/member_modify")
	public String member_info(@SessionAttribute("sMemberId") String sMemberId, Model model) throws Exception {
		System.out.println(memberService.findMember(sMemberId));
		model.addAttribute("loginMember", memberService.findMember(sMemberId));
		return "member_modify";
	}

	@LoginCheck
	@PostMapping(value = "/member_modify_action")
	public String member_modify_action(@ModelAttribute Member member, HttpSession session) throws Exception {
		String forwardPath = "";
		String loginMemberId = (String) session.getAttribute("sMemberId");
		member.setId(loginMemberId);
		System.out.println(member.getBirth_date());
		memberService.modify(member);
		forwardPath = "redirect:member_info";
		return forwardPath;

	}

	@LoginCheck
	@GetMapping(value = "/member_modify_action")
	public String member_modify_action_myinfo_get() throws Exception {
		return "redirect:member_info";
	}

}
