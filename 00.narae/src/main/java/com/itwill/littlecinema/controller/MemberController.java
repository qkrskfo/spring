package com.itwill.littlecinema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.itwill.littlecinema.controller.intercepter.LoginCheck;
import com.itwill.littlecinema.domain.Ticket;
import com.itwill.littlecinema.service.interface_service.MemberService;
import com.itwill.littlecinema.service.interface_service.TicketService;


@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private TicketService ticketService;
	
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
