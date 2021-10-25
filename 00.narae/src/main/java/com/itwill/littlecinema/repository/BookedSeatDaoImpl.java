package com.itwill.littlecinema.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.littlecinema.domain.BookedSeat;
import com.itwill.littlecinema.domain.Ticket;
import com.itwill.littlecinema.repository.interface_dao.BookedSeatDao;

@Repository
public class BookedSeatDaoImpl implements BookedSeatDao {

	public static final String NAMESPACE = "mapper.BookedSeatMapper.";

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(BookedSeat bookedSeat) throws Exception {
		return sqlSession.insert(NAMESPACE + "insertBookedSeat", bookedSeat);
	}

	@Override
	public List<BookedSeat> selectBookedSeatList(int timeCode) throws Exception {
		return sqlSession.selectList(NAMESPACE + "selectByTimeCode", timeCode);
	}

}
