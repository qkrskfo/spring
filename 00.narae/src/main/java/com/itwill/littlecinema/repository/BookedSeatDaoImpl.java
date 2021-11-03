package com.itwill.littlecinema.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwill.littlecinema.domain.BookedSeat;
import com.itwill.littlecinema.domain.Seat;
import com.itwill.littlecinema.domain.Time;
import com.itwill.littlecinema.repository.interface_dao.BookedSeatDao;

@Repository
public class BookedSeatDaoImpl implements BookedSeatDao {
	
	private static final String NAMESPACE = "mapper.BookedSeatMapper.";
	private SqlSession sqlSession;
	
	public BookedSeatDaoImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public int insert(BookedSeat bookedSeat) throws Exception {
		return sqlSession.insert(NAMESPACE + "insertBookedSeat", bookedSeat);
	}

	@Override
	public List<BookedSeat> selectBookedSeatList(int timeCode) throws Exception {
		return sqlSession.selectList(NAMESPACE + "selectByTimeCode", timeCode);
	}

	@Override
	public List<BookedSeat> selectByTimeBookedSeatList(Time time) throws Exception {
		return sqlSession.selectList(NAMESPACE + "selectByTime", time);
	}

	@Override
	public List<Seat> selectBySeatCodeList(int timeCode) throws Exception {
		return sqlSession.selectList(NAMESPACE + "selectBySeatCodeList", timeCode);
	}
	
	

}
