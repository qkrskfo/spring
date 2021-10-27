package com.itwill.littlecinema.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.littlecinema.domain.BookedSeat;
import com.itwill.littlecinema.domain.Movie;
import com.itwill.littlecinema.domain.Time;
import com.itwill.littlecinema.service.interface_service.MovieService;
import com.itwill.littlecinema.service.interface_service.ReviewService;
import com.itwill.littlecinema.service.interface_service.TimeService;

@Controller
public class MovieInfoController {
	@Autowired
	private MovieService movieService;
	@Autowired
	private TimeService timeService;
	@Autowired
	private ReviewService reviewService;
	
	
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
		
		List<Time> timeList = timeService.findMovieTimeList(movieNo);
		model.addAttribute("timeList", timeList);
		
		Double avgScore = reviewService.findAvgScore(movieNo);
		model.addAttribute("avgScore", avgScore);
		
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
	
	@RequestMapping("/movie_timetable")
	public String movieTimetable(@RequestParam int movieNo, @RequestParam String movieDate, Model model) throws Exception {
		movieNo = 2;
		movieDate = "2021-10-21";
		Map<String, Object> movieNoDate = new HashMap<>();
		movieNoDate.put("movieDate", movieDate);
		movieNoDate.put("movieNo", movieNo);
		model.addAttribute("timeTable", timeService.findTimeTableByNoDate(movieNoDate));
		
		
		
		
		
		List<Time> timeList = timeService.findMovieTimeList(movieNo);
		
		List<Integer> countList = new ArrayList<>();
		for (Time time : timeList) {
			List<BookedSeat> bookedSeatList = timeService.findByTimeBookedSeatList(time);
			countList.add(bookedSeatList.size());
		}
		
		model.addAttribute("seatCount", "aaaaaaa");
		return "timetable_ajax";
	}
}