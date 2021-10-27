package com.itwill.littlecinema.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itwill.littlecinema.domain.Time;
import com.itwill.littlecinema.service.interface_service.TimeService;

@Controller
public class MovieTimeTableController {
	
	@Autowired
	private TimeService timeService;
	
	@ResponseBody
	@RequestMapping(value="/timetable_rest")
	public List<Date> MovieDateTableRest() throws Exception {
		return timeService.findAllDate();
	}
	
	@RequestMapping(value="/timetable")
	public String MovieDateTable(Model model) throws Exception {
		
		List<Date> dateList = timeService.findAllDate();
		model.addAttribute("dateList", dateList);

		return "movie_timetable";
	}

	@ResponseBody
	@RequestMapping("/timetable_detail_rest")
	public List<Time> timeListRest(@RequestParam String movieDate) throws Exception {
		return timeService.findScreenTimeByDate(movieDate);
	}

	@RequestMapping("/timetable_detail")
	public String MovieTimetable(@RequestParam String movieDate, Model model) throws Exception {
		
		List<Time> timeList = timeService.findScreenTimeByDate(movieDate);
		model.addAttribute("timeList", timeList);

		return "movie_timetable_detail";
	}

}