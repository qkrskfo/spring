package com.itwill.littlecinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.littlecinema.service.interface_service.MovieService;

@Controller
public class PlayingController {

	private MovieService movieService;

	@Autowired
	public PlayingController(MovieService movieService) {
		super();
		this.movieService = movieService;
	}
	
	
	@RequestMapping("/playing")
	public String playing(Model model) throws Exception {
		model.addAttribute("movieList", movieService.findPlayingList());
		return "playing";
	}
	
}
