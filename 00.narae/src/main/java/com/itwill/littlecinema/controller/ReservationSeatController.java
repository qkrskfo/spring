package com.itwill.littlecinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.littlecinema.service.interface_service.BookedSeatService;

@Controller
public class ReservationSeatController {

	@Autowired
	private BookedSeatService bookedSeatService;

	@RequestMapping("/reservation_seat")
	public String reservation_seat(@RequestParam(required = true, defaultValue = "1") int timeCode, Model model)
			throws Exception {
		model.addAttribute("bookedSeatList", bookedSeatService.findBookedSeatList(timeCode));
		return "reservation_seat";
	}
}