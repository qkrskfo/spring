package com.itwill.littlecinema.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwill.littlecinema.domain.Member;
import com.itwill.littlecinema.domain.Review;
import com.itwill.littlecinema.repository.interface_dao.MovieDao;
import com.itwill.littlecinema.repository.interface_dao.ReviewDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-config.xml")
public class ReviewDaoTest {

	@Autowired
	private ReviewDao reviewDao;
	@Autowired
	private MovieDao movieDao;

	@Test
	public void reviewDaoTest() {
		Member testMember = new Member("askitral1c", "테스트", "테스트", "테스트", new Date());
		Review review = new Review(0, testMember, movieDao.selectDetailByNo(6), 0, "노잼");

		// 1. 새 리뷰
		assertThat(reviewDao.insert(review), is(1));
		System.out.println("### 생성한 리뷰 번호: " + review.getReviewNo());
		
		Review insertedReview = reviewDao.selectByNo(review.getReviewNo());
		System.out.println(insertedReview);
		assertThat(insertedReview.getScore(), is(0));
		assertThat(insertedReview.getReviewComment(), is("노잼"));

		// 2. 리뷰 수정
		reviewDao.update(new Review(insertedReview.getReviewNo(), testMember, movieDao.selectDetailByNo(6), 5, "꿀잼"));
		Review updatedReview = reviewDao.selectByNo(insertedReview.getReviewNo());
		assertThat(updatedReview.getScore(), is(5));
		assertThat(updatedReview.getReviewComment(), is("꿀잼"));

		// 3. 리뷰 삭제
		assertThat(reviewDao.delete(insertedReview.getReviewNo()), is(1));
		
		// 4. (내정보) 리뷰 갯수 (이승현)
		System.out.println(reviewDao.selectByReviewCount("test"));
	}
}
