package com.itwill.littlecinema.repository.interface_dao;

import java.util.List;

import com.itwill.littlecinema.domain.BookedSeat;
import com.itwill.littlecinema.domain.Ticket;
import com.itwill.littlecinema.domain.Time;

public interface BookedSeatDao {

	//예매하면 좌석 마감
	public int insert(BookedSeat bookedSeat) throws Exception;
	
	//좌석 고를 때 예매된 좌석들 보기
	public List<BookedSeat> selectBookedSeatList(int timeCode) throws Exception;

	//좌석 고를 때 예매된 좌석들 보기
	public List<BookedSeat> selectByTimeBookedSeatList(Time time) throws Exception;
	
}
