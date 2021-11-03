package com.itwill.littlecinema.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.itwill.littlecinema.controller.intercepter.LoginCheck;
import com.itwill.littlecinema.service.interface_service.BookedSeatService;
import com.itwill.littlecinema.service.interface_service.TimeService;
import com.itwill.littlecinema.service.interface_service.TicketService;

@Controller
public class BookingController {
	
	private TimeService timeService;
	private BookedSeatService bookedSeatService;
	private TicketService ticketService;
	
	public BookingController(TimeService timeService, BookedSeatService bookedSeatService,
			TicketService ticketService) {
		this.timeService = timeService;
		this.bookedSeatService = bookedSeatService;
		this.ticketService = ticketService;
	}
	
	
	
	@RequestMapping("/booking")
	public String start(@RequestParam(required = false) Integer timeCode, Model model) throws Exception {
		if (timeCode != null) {
			model.addAttribute("time", timeService.findTimeByTimeCode(timeCode));
		}
		return "booking";
	}
	
	@PostMapping("/booking_seat")
	public String booking_seat(@RequestParam Integer timeCode, Model model) throws Exception  {
		model.addAttribute("seatCodeList", bookedSeatService.findBySeatCodeList(timeCode));
		model.addAttribute("bookedSeatList", bookedSeatService.findBookedSeatList(timeCode));
		model.addAttribute("timeCode", timeCode);
		return "booking_seat";
	}
	
	
	// PayController
	
	//결제 폼
	//@LoginCheck
	@RequestMapping(value="/pay")
	public String pay_form(@RequestParam(required = false) Integer timeCode,
							@RequestParam(required = false) Integer payCost, 
							@RequestParam(required = false) List<String> seat) throws Exception {
		System.out.println(timeCode);
		System.out.println(payCost);
		System.out.println(seat);
		return "redirect:main";
	}

	//결제하기
	@LoginCheck
	@RequestMapping(value="/pay_action")
	public String pay_action(@SessionAttribute("sMemberId") String sMemberId,
							@RequestParam(required = true) Integer timeCode,
							@RequestParam(required = false) Integer payCost,
							@RequestParam List<String> seat) throws Exception {
		return "redirect:pay_list?ticketNo=" + ticketService.add(sMemberId, timeCode, payCost, seat);
	}
	
	//결제내역보기
	@LoginCheck
	@RequestMapping(value="/pay_list")
	public String paylist_action(@SessionAttribute("sMemberId") String sMemberId,
								@RequestParam int ticketNo,
								Model model) throws Exception {
		model.addAttribute("ticket", ticketService.findTicketNo(ticketNo));
		return "pay_list";
	}

	//TODO: 예매 취소 추가

}
