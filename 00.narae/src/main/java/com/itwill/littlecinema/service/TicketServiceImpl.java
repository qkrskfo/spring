package com.itwill.littlecinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.littlecinema.domain.Ticket;
import com.itwill.littlecinema.repository.interface_dao.TicketDao;
import com.itwill.littlecinema.service.interface_service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

	private TicketDao ticketDao;

	@Autowired
	public TicketServiceImpl(TicketDao ticketDao) {
		this.ticketDao = ticketDao;
	}
	
	@Override
	public int add(Ticket ticket) throws Exception {
		return ticketDao.insert(ticket);
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
