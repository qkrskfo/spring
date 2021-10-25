package com.itwill.littlecinema.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.littlecinema.domain.Movie;
import com.itwill.littlecinema.domain.Time;
import com.itwill.littlecinema.service.interface_service.MovieService;
import com.itwill.littlecinema.service.interface_service.TimeService;

@Controller
public class MovieInfoController {
	@Autowired
	private MovieService movieService;
	@Autowired
	private TimeService timeService;
	
	@RequestMapping(value="/movie_info", params="!movieNo")
	public String movie_info_no_param() {
		return "redirect:playing";
	}
	/*
	@RequestMapping(value="/movie_info", params="movieNo")
	public String movie_info(@RequestParam int movieNo, Model model) throws Exception {
		
		Movie movie = movieService.findDetailByNo(movieNo);
		model.addAttribute("movie", movie);
		
		return "movie_info";
	}
	 */
	
	@RequestMapping(value="/movie_info", params="movieNo")
	public String movie_info(@RequestParam int movieNo, Model model) throws Exception {
		
		Movie movie = movieService.findDetailByNo(movieNo);
		model.addAttribute("movie", movie);
		
		List<Date> dateList = timeService.findDateByNo(movieNo);
		model.addAttribute("dateList", dateList);
		
		return "movie_info";
	}
	
	
	/*
	@RequestMapping(value="/movie_info", params="movieNo, movieDate")
	public String movie_info(@RequestParam int movieNo, String movieDate, Model model) throws Exception {
		Map<String, Object> movieNoDate = new HashMap<>();
		movieNoDate.put("movieDate", movieDate);
		movieNoDate.put("movieNo", movieNo);
		
		Movie movie = movieService.findDetailByNo(movieNo);
		model.addAttribute("movie", movie);
		
		List<Time> timeList = timeService.findScreenTimeByNoDate(movieNoDate);
		model.addAttribute("timeList", timeList);
		
		return "movie_info";
	}
	*/
	
}