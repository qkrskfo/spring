package com.itwill.littlecinema.repository.interface_dao;

import java.util.List;

import com.itwill.littlecinema.domain.Ticket;

public interface TicketDao {
	
	/**
	 * 예매하기
	 * @param id
	 * @return affected row
	 */
	public int insert(Ticket ticket) throws Exception;
	
	//예매취소
	public int update(int ticketNo) throws Exception;
	
	//예매 내역 조회
	public List<Ticket> selectTicketList(String id) throws Exception;
	
}
