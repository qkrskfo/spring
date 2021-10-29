package com.itwill.littlecinema.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.littlecinema.domain.BookedSeat;
import com.itwill.littlecinema.domain.Time;
import com.itwill.littlecinema.repository.interface_dao.BookedSeatDao;
import com.itwill.littlecinema.repository.interface_dao.TimeDao;
import com.itwill.littlecinema.service.interface_service.TimeService;
@Service
public class TimeServiceImpl implements TimeService {

	@Autowired
	private TimeDao timeDao;
	
	@Autowired
	private BookedSeatDao bookedSeatDao;

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
	public List<Time> findScreenTimeByNoDate(Map<String, Object> movieNoDate) {
		return timeDao.selectScreenTimeByNoDate(movieNoDate);
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
	public List<BookedSeat> findByTimeBookedSeatList(Time time) throws Exception {
		return bookedSeatDao.selectByTimeBookedSeatList(time);
	}
	
}