package com.itwill.littlecinema.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.itwill.littlecinema.domain.BookedSeat;
import com.itwill.littlecinema.domain.Seat;
import com.itwill.littlecinema.domain.Time;
import com.itwill.littlecinema.repository.interface_dao.BookedSeatDao;
import com.itwill.littlecinema.service.interface_service.BookedSeatService;

@Service
public class BookSeatServiceImpl implements BookedSeatService {
	
	private BookedSeatDao bookedSeatDao;

	public BookSeatServiceImpl(BookedSeatDao bookedSeatDao) {
		this.bookedSeatDao = bookedSeatDao;
	}

	@Override
	public int add(BookedSeat bookedSeat) throws Exception {
		return bookedSeatDao.insert(bookedSeat);
	}

	@Override
	public List<BookedSeat> findBookedSeatList(int timeCode) throws Exception {
		return bookedSeatDao.selectBookedSeatList(timeCode);
	}

	@Override
	public List<BookedSeat> findByTimeBookedSeatList(Time time) throws Exception {
		return bookedSeatDao.selectByTimeBookedSeatList(time);
	}

	@Override
	public List<Seat> findBySeatCodeList(int timeCode) throws Exception {
		return bookedSeatDao.selectBySeatCodeList(timeCode);
	}

}
