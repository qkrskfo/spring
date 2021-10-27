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

import com.itwill.littlecinema.domain.Movie;
import com.itwill.littlecinema.domain.Time;
import com.itwill.littlecinema.service.interface_service.MovieService;
import com.itwill.littlecinema.service.interface_service.ReviewService;
import com.itwill.littlecinema.service.interface_service.TimeService;

//@Controller
public class MovieInfoController2 {

	//@Autowired
	private MovieService movieService;
	//@Autowired
	private TimeService timeService;
	//@Autowired
	private ReviewService reviewService;
	
	// @RequestMapping(value="/movie_info", params="movieNo")
	    public String movie_info(@RequestParam int movieNo, Model model) throws Exception {
	        
	        Movie movie = movieService.findDetailByNo(movieNo);
	        model.addAttribute("movie", movie);
	        
	        List<Date> dateList = timeService.findDateByNo(movieNo);
	        model.addAttribute("dateList", dateList);
	        
	        
	        Map<String, Object> movieNoDate = new HashMap<>();
	        List<List<Time>> wholeTimeList = new ArrayList<>();
	        for (Date date : dateList) {
	            movieNoDate.put("movieDate", date);
	            movieNoDate.put("movieNo", movieNo);
	            List<Time> timeList = timeService.findScreenTimeByNoDate(movieNoDate);
	            wholeTimeList.add(timeList);
	        }
	        model.addAttribute("wholeTimeList", wholeTimeList);
	        
	        Double avgScore = reviewService.findAvgScore(movieNo);
	        model.addAttribute("avgScore", avgScore);
	        
	        return "movie_info";
	    }
	
}
