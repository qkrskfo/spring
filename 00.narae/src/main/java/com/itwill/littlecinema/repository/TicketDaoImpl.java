package com.itwill.littlecinema.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwill.littlecinema.domain.Ticket;
import com.itwill.littlecinema.repository.interface_dao.TicketDao;

@Repository
public class TicketDaoImpl implements TicketDao {
	
	private static final String NAMESPACE = "mapper.TicketMapper.";
	private SqlSession sqlSession;
	
	public TicketDaoImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public int insert(Ticket ticket) throws Exception {
		return sqlSession.insert(NAMESPACE + "insertTicket", ticket);
	}

	@Override
	public int update(int ticketNo) throws Exception {
		return sqlSession.update(NAMESPACE + "updateTicketStatus", ticketNo);
	}

	@Override
	public List<Ticket> selectTicketList(String id) throws Exception {
		return sqlSession.selectList(NAMESPACE + "selectById", id);
	}
	
	@Override
	public Ticket selectTicketBookedSeatByNo(int ticketNo) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "selectTicketBookedSeatByNo", ticketNo);
	}
	
}
