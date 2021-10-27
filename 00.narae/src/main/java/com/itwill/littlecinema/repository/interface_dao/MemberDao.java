package com.itwill.littlecinema.repository.interface_dao;

import com.itwill.littlecinema.domain.Member;

public interface MemberDao {
	
	/**
	 * 회원 가입
	 * @param Member 객체
	 * @return affected row
	 */
	int insert(Member member) throws Exception;
	
	/**
	 * 회원정보 조회
	 * @param id
	 * @return 회원 정보(객체)
	 */
	Member select(String id) throws Exception;
	
	/**
	 * 회원정보 수정
	 * @param Member 객체
	 * @return affected row
	 */
	int update(Member member) throws Exception;
	
	/**
	 * 회원탈퇴
	 * @param id
	 * @return affected row
	 */
	int delete(String id) throws Exception;

	/**
	 * 아이디 존재 여부 확인
	 * @param id
	 * @return boolean
	 */
	boolean existedMember(String id) throws Exception;
	
}
