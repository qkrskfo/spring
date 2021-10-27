package com.itwill.littlecinema.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itwill.littlecinema.domain.Time;
import com.itwill.littlecinema.service.interface_service.TimeService;

@Controller
public class DateListController {

	private TimeService timeService;
	
	@Autowired
	public DateListController(TimeService timeService) {
		super();
		this.timeService = timeService;
	}
	
	@ResponseBody
	@RequestMapping("/movie_to_dateList_rest")
	public List<Time> dateListRest(@RequestParam(required = true, defaultValue = "2") int movieNo) throws Exception {
		return timeService.findMovieTimeList(movieNo);
	}
	
	@RequestMapping("/movie_to_dateList")
	public String dateList(@RequestParam(required = true, defaultValue = "2") int movieNo, 
							Model model) throws Exception {
		model.addAttribute("dateList", timeService.findDateByNo(movieNo));
		model.addAttribute("movieNo", movieNo);
		return "movie_to_date"; 
	}
	
	
	@ResponseBody
	@RequestMapping("/date_to_timeTable_rest")
	public List<Time> timeTableRest(@RequestParam(required = true, defaultValue = "2") int movieNo, 
									@RequestParam(required = true, defaultValue = "2021-10-21") String movieDate) throws Exception {
		Map<String, Object> movieNoDate = new HashMap<>();
		movieNoDate.put("movieDate", movieDate);
		movieNoDate.put("movieNo", movieNo);
		return timeService.findTimeTableByNoDate(movieNoDate);
	}
	
	@RequestMapping("/date_to_timeTable")
	public String timeTable(@RequestParam(required = true, defaultValue = "2") int movieNo, 
							@RequestParam(required = true, defaultValue = "2021-10-21") String movieDate, 
							Model model) throws Exception {
		Map<String, Object> movieNoDate = new HashMap<>();
		movieNoDate.put("movieDate", movieDate);
		movieNoDate.put("movieNo", movieNo);
		model.addAttribute("timeTable", timeService.findTimeTableByNoDate(movieNoDate));
		return "date_to_timeTable";
	}
}
