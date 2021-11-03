package com.itwill.littlecinema.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.itwill.littlecinema.domain.Time;
import com.itwill.littlecinema.domain.TimeTableJsonObject;
import com.itwill.littlecinema.repository.interface_dao.BookedSeatDao;
import com.itwill.littlecinema.repository.interface_dao.TimeDao;
import com.itwill.littlecinema.service.interface_service.TimeService;

@Service
public class TimeServiceImpl implements TimeService {
	
	private TimeDao timeDao;
	private BookedSeatDao bookedSeatDao;

	public TimeServiceImpl(TimeDao timeDao, BookedSeatDao bookedSeatDao) {
		this.timeDao = timeDao;
		this.bookedSeatDao = bookedSeatDao;
	}

	@Override
	public List<Date> findAllDate() {
		return timeDao.selectAllDate();
	}

	@Override
	public List<Date> findDateByNo(int movieNo) {
		return timeDao.selectDateByNo(movieNo);
	}

	@Override
	public List<Time> findMovieTimeList(int movieNo) throws Exception {
		return timeDao.selectTimeByNo(movieNo);
	}
	
	@Override
	public List<Time> findTimeTableByNoDate(Map<String, Object> movieNoDate) throws Exception {
		return timeDao.selectTimeTableByNoDate(movieNoDate);
	}
	
	@Override
	public List<Time> findScreenTimeByDate(String movieDate) {
		return timeDao.selectScreenTimeByDate(movieDate);
	}

	@Override
	public List<TimeTableJsonObject> findTimeTable(int movieNo, String movieDate) throws Exception {
		/*
		 * Tue Oct 19 00:00:00 KST 2021
		 * EEE MMM dd HH:mm:ss z yyyy
		 * 이런 망할.. Locale.ENGLISH이 없으면, Tue Oct => 화 10월 이렇게 나옴.
		 */
		Date date = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH).parse(movieDate);
		
		//selectScreenTimeByNoDate의 인자로 들어가야 할 Map객체
		Map<String, Object> queryMap = new HashMap<>();
		queryMap.put("movieDate", date);
		queryMap.put("movieNo", movieNo);
		List<Time> timeList = timeDao.selectScreenTimeByNoDate(queryMap);
		
		List<TimeTableJsonObject> timeTable = new ArrayList<>();
		for (Time time : timeList) {
			timeTable.add(
					new TimeTableJsonObject(time.getTimeCode(),
							time.getScreen(),
							time.getStartTime(),
							time.getEndTime(),
							bookedSeatDao.selectByTimeBookedSeatList(time).size()
							)
					);
		}
		
		return timeTable;
	}

	@Override
	public Time findTimeByTimeCode(int timeCode) throws Exception {
		return timeDao.selectTimeByTimeCode(timeCode);
	}
	
	
	
	//==================================== TESTING ====================================
	
	
}