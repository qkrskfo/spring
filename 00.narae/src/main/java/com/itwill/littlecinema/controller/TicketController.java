package com.itwill.littlecinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.itwill.littlecinema.service.interface_service.TicketService;

@Controller
public class TicketController {

	private TicketService ticketService;

	@Autowired
	public TicketController(TicketService ticketService) {
		super();
		this.ticketService = ticketService;
	}
	
	
	public String newTicket() throws Exception {
		ticketService.add(null, null, 0, null);
		return "";
	}
	
}
