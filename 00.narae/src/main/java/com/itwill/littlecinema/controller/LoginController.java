package com.itwill.littlecinema.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.littlecinema.controller.intercepter.LoginCheck;
import com.itwill.littlecinema.domain.Member;
import com.itwill.littlecinema.service.interface_service.MemberService;


@Controller
public class LoginController {

	@Autowired
	private MemberService memberService;
	
	
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	
	@PostMapping(value="/login_action")
	public String login_post(@ModelAttribute Member member,HttpSession session,Model model) throws Exception{
		String forwardPath="";
		int result = memberService.login(member.getId(), member.getPassword());
		if(result==0) {
			//아이디존재X
			model.addAttribute("msg1", "존재하지않는 아이디입니다.");
			model.addAttribute("fmember", member);
			forwardPath="login";
		}else if(result==1) {
			//패쓰워드 불일치
			model.addAttribute("msg2", "패쓰워드가 일치하지 않습니다");
			model.addAttribute("fmember", member);
			forwardPath="login";
		}else if(result==2) {
			//로그인성공
			session.setAttribute("sMemberId", member.getId());
			forwardPath="redirect:main"; 
		}
		return forwardPath;
	}

	@GetMapping(value="/login_action")
	public String login_get() {
		return "redirect:main";
	}
	
	@LoginCheck
	@RequestMapping(value="/logout_action")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:main";
	}
	
	
	
	
}
