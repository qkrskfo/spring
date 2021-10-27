package com.itwill.littlecinema.repository.interface_dao;

import java.util.List;

import com.itwill.littlecinema.domain.Movie;

public interface MovieDao {
	/**
	 * 영화 상세정보 및 해당 리뷰 목록 조회
	 * @param movieNo
	 * @return 영화 + 리뷰 리스트
	 */
	Movie selectDetailByNo(int movieNo);
	
	/**
	 * 상영 중인 영화 목록 조회
	 * @return 영화 리스트
	 */
	List<Movie> selectPlayingList();
	

	

}
