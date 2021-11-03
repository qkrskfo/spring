package com.itwill.littlecinema.repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwill.littlecinema.domain.Time;
import com.itwill.littlecinema.repository.interface_dao.TimeDao;

@Repository
public class TimeDaoImpl implements TimeDao {
	
	private final static String NAMESPACE = "mapper.TimeMapper.";
	private SqlSession sqlSession;

	public TimeDaoImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<Date> selectAllDate() {
		return sqlSession.selectList(NAMESPACE + "selectAllDate");
	}

	@Override
	public List<Date> selectDateByNo(int movieNo) {
		return sqlSession.selectList(NAMESPACE + "selectDateByNo", movieNo);
	}
	
	@Override
	public List<Time> selectTimeByNo(int movieNo) {
		return sqlSession.selectList(NAMESPACE + "selectTimeByNo", movieNo);
	}

	@Override
	public List<Time> selectScreenTimeByDate(String movieDate) {
		return sqlSession.selectList(NAMESPACE + "selectScreenTimeByDate", movieDate);
	}

	@Override
	public List<Time> selectTimeTableByNoDate(Map<String, Object> movieNoDate) {
		return sqlSession.selectList(NAMESPACE + "selectTimeTableByNoDate", movieNoDate);
	}
	
	@Override
	public Time selectTimeByTimeCode(int timeCode) {
		return sqlSession.selectOne(NAMESPACE + "selectTimeByTimeCode", timeCode);
	}
	
	//==================================== TESTING ====================================
	
	@Override
	public List<Time> selectScreenTimeByNoDate(Map<String, Object> movieNoDate) {
		return sqlSession.selectList(NAMESPACE + "selectScreenTimeByNoDate", movieNoDate);
	}


}