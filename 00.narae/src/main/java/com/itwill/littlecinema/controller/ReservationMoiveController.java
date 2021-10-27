package com.itwill.littlecinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.littlecinema.domain.Movie;
import com.itwill.littlecinema.service.interface_service.MovieService;

@Controller
public class ReservationMoiveController {
	
	@Autowired
	private MovieService movieService;
	
	@RequestMapping("/reservation_movie")
	public String playing(Model model) throws Exception {
		model.addAttribute("movieList", movieService.findPlayingList());
		return "reservation_movie";
	}
	
	@RequestMapping("/reservation_summary")
	public String summary(@RequestParam int movieNo, Model model) throws Exception {
		
		Movie movie = movieService.findDetailByNo(movieNo);
		model.addAttribute("movie", movie);
		
		
		return "reservation_summary";
	}
	
}
