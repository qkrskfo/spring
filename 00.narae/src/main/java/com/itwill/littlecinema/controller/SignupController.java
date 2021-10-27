package com.itwill.littlecinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.littlecinema.domain.Member;
import com.itwill.littlecinema.service.interface_service.MemberService;

@Controller
public class SignupController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "/signup")
	public String signup() {
		return "signup";
	}
	@PostMapping(value="signup_action")
	public String signup_post(@ModelAttribute Member member,Model model) throws Exception{
		String forwardPath="";
		int result =memberService.add(member);
		if(result>0) {
			forwardPath="redirect:login";
		}else {
			model.addAttribute("fmember",member);
			model.addAttribute("msg",member.getId()+"는 사용중인 아이디입니다.");
			forwardPath="signup";
		}
		return forwardPath;
	}
	@GetMapping(value="signup_action")
	public String signup_get() {
		return "redirect:signup";
	}
}
