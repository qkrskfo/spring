package com.itwill.littlecinema.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.littlecinema.domain.Review;
import com.itwill.littlecinema.repository.interface_dao.ReviewDao;
import com.itwill.littlecinema.service.interface_service.ReviewService;


@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewDao reviewDao;
	
	//리뷰 1개 정보
	@Override
	public Review findByNo(int reviewNo) throws Exception {
		Review review = reviewDao.selectByNo(reviewNo);
		return review;
	}
	
	//리뷰 작성
	@Override
	public int add(Review review) throws Exception {
		return reviewDao.insert(review);
	}

	//리뷰 수정
	@Override
	public int modify(Review review) throws Exception {
		return reviewDao.update(review);
	}
	
	//리뷰 삭제
	@Override
	public int remove(int reviewNo) throws Exception {
		return reviewDao.delete(reviewNo);
	}
	
	//평점 평균 조회
	@Override
	public double findAvgScore(int movieNo) throws Exception {
		return reviewDao.selectAvgScore(movieNo);
	}

}
