package com.itwill.littlecinema.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.itwill.littlecinema.controller.intercepter.LoginCheck;
import com.itwill.littlecinema.domain.Member;
import com.itwill.littlecinema.domain.Ticket;
import com.itwill.littlecinema.service.interface_service.MemberService;
import com.itwill.littlecinema.service.interface_service.ReviewService;
import com.itwill.littlecinema.service.interface_service.TicketService;


@Controller
public class MemberController {
	
	private MemberService memberService;
	private TicketService ticketService;
	private ReviewService reviewService;
	
	public MemberController(MemberService memberService, TicketService ticketService, ReviewService reviewService) {
		this.memberService = memberService;
		this.ticketService = ticketService;
		this.reviewService = reviewService;
	}

	//SignupController
	
	@RequestMapping(value = "/signup")
	public String signup() {
		return "signup";
	}
	
	@PostMapping(value="signup_action")
	public String signup_post(@ModelAttribute Member member,Model model) throws Exception{
		String forwardPath="";
		int result =memberService.add(member);
		if(result>0) {
			forwardPath="redirect:login-signup";
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
	
	//MemberModifyController
	
	@LoginCheck
	@RequestMapping(value = "/member_modify")
	public String member_modify(@SessionAttribute("sMemberId") String sMemberId, Model model) throws Exception {
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
	
	//MemberInfoController
	
	//@LoginCheck
	@RequestMapping(value = "/member_info")
	public String member_info(/*@SessionAttribute("sMemberId")*/ String sMemberId, Model model) throws Exception {
		sMemberId = "test";
		System.out.println(reviewService.selectByReviewCount(sMemberId));
		model.addAttribute("reviewCount", reviewService.selectByReviewCount(sMemberId));
		model.addAttribute("loginMember",memberService.findMember(sMemberId));
		return "member_info";
	}
	
	//LoginController
	
	@RequestMapping(value = "/login-signup")
	public String login() {
		return "login-signup";
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
	
	
	//MemberController
	
	@LoginCheck
	@RequestMapping(value = "/member_ticket_history")
	public String member_ticket_history(@SessionAttribute("sMemberId") String sMemberId, Model model) throws Exception {
		List<Ticket> memberTicketList = ticketService.findTicketList(sMemberId);
		
		model.addAttribute("memberTicketList", memberTicketList);
		
		return "member_ticket_history";
	}
	
	@PostMapping(value = "/member_remove_action")
	public String member_remove_action(@SessionAttribute("sMemberId") String sMemberId) throws Exception{
		/*
		 * 세션에서 sMemberId를 받은 다음 서비스에서 삭제시킨 후 logout으로 redirect
		 */
		memberService.remove(sMemberId);
		return "redirect:logout_action";
	}
	
}