package com.itwill.littlecinema.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwill.littlecinema.domain.Movie;
import com.itwill.littlecinema.repository.interface_dao.MovieDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-config.xml")
public class MovieDaoTest {
	
	@Autowired
	private MovieDao movieDao;
	
	@Test
	public void movieDaoTest() {
		// 1. 영화 상세정보 및 해당 리뷰 목록 조회
		assertThat(movieDao.selectDetailByNo(1),is(notNullValue()));
		System.out.println(movieDao.selectDetailByNo(2));
		
		// 2. 상영중인 영화 목록 조회
		List<Movie> movieList = movieDao.selectPlayingList();
		for (Movie movie : movieList) {
			System.out.println("######## 제목: "+movie.getTitle());
		}
		
		// 3. 상영예정 영화 목록 조회
		System.out.println(movieDao.selectScheduledList());
	}

}
