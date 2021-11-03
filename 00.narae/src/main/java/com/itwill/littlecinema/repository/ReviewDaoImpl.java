package com.itwill.littlecinema.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwill.littlecinema.domain.Review;
import com.itwill.littlecinema.repository.interface_dao.ReviewDao;

@Repository
public class ReviewDaoImpl implements ReviewDao {

	private final static String NAMESPACE = "mapper.ReviewMapper.";
	private SqlSession sqlSession;

	public ReviewDaoImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public Review selectByNo(int reviewNo) {
		return sqlSession.selectOne(NAMESPACE + "selectByNo", reviewNo);
	}

	@Override
	public int insert(Review review) {
		return sqlSession.insert(NAMESPACE + "insert", review);
	}

	@Override
	public int update(Review review) {
		return sqlSession.insert(NAMESPACE + "update", review);
	}

	@Override
	public int delete(int reviewNo) {
		return sqlSession.delete(NAMESPACE + "delete", reviewNo);
	}

	@Override
	public Double selectAvgScore(int movieNo) {
		Double result = sqlSession.selectOne(NAMESPACE + "selectAvgScore", movieNo);
		if (result == null) {
			return 0.0;
		} else {
			return result;
		}
	}

	@Override
	public int selectByReviewCount(String id) {
		int countResult = sqlSession.selectOne(NAMESPACE + "selectByReviewCount", id);
		if(countResult == 0) {
			return 0;
		} else {
			return countResult;
		}
	}

}
