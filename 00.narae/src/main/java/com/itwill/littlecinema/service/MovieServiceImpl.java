package com.itwill.littlecinema.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.itwill.littlecinema.domain.Movie;
import com.itwill.littlecinema.repository.interface_dao.MovieDao;
import com.itwill.littlecinema.service.interface_service.MovieService;
@Service
public class MovieServiceImpl implements MovieService {
	
	private MovieDao movieDao;
	
	public MovieServiceImpl(MovieDao movieDao) {
		this.movieDao=movieDao;
	}

	@Override
	public Movie findDetailByNo(int movieNo) throws Exception {
		Movie movie = movieDao.selectDetailByNo(movieNo);
		return movie;
	}

	@Override
	public List<Movie> findPlayingList() throws Exception {
		return movieDao.selectPlayingList();
	}

	@Override
	public List<Movie> findScheduledList() throws Exception {
		return movieDao.selectScheduledList();
	}
	
	
}
