package com.itwill.littlecinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.littlecinema.domain.BookedSeat;
import com.itwill.littlecinema.domain.Ticket;
import com.itwill.littlecinema.repository.interface_dao.BookedSeatDao;
import com.itwill.littlecinema.service.interface_service.BookedSeatService;

@Service
public class BookSeatServiceImpl implements BookedSeatService {

	@Autowired
	private BookedSeatDao bookedSeatDao;
	
	@Override
	public int add(BookedSeat bookedSeat) throws Exception {
		return bookedSeatDao.insert(bookedSeat);
	}

	@Override
	public List<BookedSeat> findBookedSeatList(int timeCode) throws Exception {
		return bookedSeatDao.selectBookedSeatList(timeCode);
	}

}
