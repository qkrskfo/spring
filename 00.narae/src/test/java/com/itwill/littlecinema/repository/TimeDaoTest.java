package com.itwill.littlecinema.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwill.littlecinema.repository.interface_dao.TimeDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-config.xml")
public class TimeDaoTest {

	@Autowired
	private TimeDao timeDao;

	@Test
	public void timeDaoTest() throws ParseException {
		// 1. 전체 영화상영 날짜목록 조회
		System.out.println(timeDao.selectAllDate());
		assertThat(timeDao.selectAllDate().size(), is(6));
		
		// 2. 영화별 상영 날짜목록 조회
		assertThat(timeDao.selectDateByNo(5).size(), is(4));
		
		// 3.영화 번호, 상영날짜로 상영시간 목록 조회 
		System.out.println("#####영화 번호, 상영날짜로 상영시간 목록 조회");
		Map<String, Object> movieNoDate = new HashMap<>();
		movieNoDate.put("movieDate", "2021-10-21");
		movieNoDate.put("movieNo", 2);
		assertThat(timeDao.selectScreenTimeByNoDate(movieNoDate).size(), is(3));
		System.out.println(timeDao.selectScreenTimeByNoDate(movieNoDate));
		
		
		// 4. 상영날짜로 상영시간 목록 조회
		System.out.println("#####상영날짜로 상영시간 목록 조회");
		assertThat(timeDao.selectScreenTimeByDate("2021-10-21").size(), is(9));
		System.out.println(timeDao.selectScreenTimeByDate("2021-10-21"));
		
		
		// 5. 영화번호, 상영날짜로 타임테이블 조회
		System.out.println("######### 영화번호, 상영날짜로 타임테이블 조회");
		System.out.println(timeDao.selectTimeTableByNoDate(movieNoDate));
		
		
		// 영화별 Time 목록 검색
		System.out.println("##### 영화별 Time 목록 검색");
		System.out.println(timeDao.selectTimeByNo(2));
		
		// 타임코드(pk)로 Time 조회
		System.out.println("######### TimeCode로 Time 조회");
		System.out.println(timeDao.selectTimeByTimeCode(1));
	}
}
