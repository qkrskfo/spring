package com.itwill.littlecinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.littlecinema.domain.BookedSeat;
import com.itwill.littlecinema.domain.Seat;
import com.itwill.littlecinema.domain.Ticket;
import com.itwill.littlecinema.domain.Time;
import com.itwill.littlecinema.repository.interface_dao.BookedSeatDao;
import com.itwill.littlecinema.repository.interface_dao.MemberDao;
import com.itwill.littlecinema.repository.interface_dao.TicketDao;
import com.itwill.littlecinema.service.interface_service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

	private TicketDao ticketDao;
	private MemberDao memberDao;
	private BookedSeatDao bookedSeatDao;
	
	@Autowired
	public TicketServiceImpl(TicketDao ticketDao, MemberDao memberDao, BookedSeatDao bookedSeatDao) {
		super();
		this.ticketDao = ticketDao;
		this.memberDao = memberDao;
		this.bookedSeatDao = bookedSeatDao;
	}

	@Override
	public int add(String memberId, Time time, int payCost, List<String> seatCodeList) throws Exception {
		if (seatCodeList.size() == 0) {
			throw new Exception("좌석 선택 필요");
		}
		
		Ticket ticket = new Ticket(memberDao.select(memberId), time, payCost);
		ticketDao.insert(ticket);
		
		for (String seatCode : seatCodeList) {
			bookedSeatDao.insert(new BookedSeat(ticket, new Seat(seatCode, time.getScreen())));
		}
		return seatCodeList.size();
	}

	@Override
	public int cancle(int ticketNo) throws Exception {
		return ticketDao.update(ticketNo);
	}

	@Override
	public List<Ticket> findTicketList(String id) throws Exception {
		return ticketDao.selectTicketList(id);
	}



}
