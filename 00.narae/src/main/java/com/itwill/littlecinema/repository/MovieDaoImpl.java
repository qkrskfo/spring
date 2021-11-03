package com.itwill.littlecinema.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwill.littlecinema.domain.Movie;
import com.itwill.littlecinema.repository.interface_dao.MovieDao;

@Repository
public class MovieDaoImpl implements MovieDao {
	
	private final static String NAMESPACE = "mapper.MovieMapper.";
	private SqlSession sqlSession;
	
	public MovieDaoImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public Movie selectDetailByNo(int movieNo) {
		return sqlSession.selectOne(NAMESPACE + "selectDetailByNo", movieNo);
	}

	@Override
	public List<Movie> selectPlayingList() {
		return sqlSession.selectList(NAMESPACE + "selectPlayingList");
	}

	@Override
	public List<Movie> selectScheduledList() {
		return sqlSession.selectList(NAMESPACE + "selectScheduledList");
	}

}
