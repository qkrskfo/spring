package com.itwill.shop.user;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
@Transactional
public interface UserService {
	/*
	 * 회원가입
	 */
	int create(User user) throws Exception;
	/*
	 * 회원로그인
	 */
	int login(String userId, String password) throws Exception;
	/*
	 * 회원전체리스트
	 */
	List<User> findUserList() throws Exception;
	/*
	 * 회원1명보기
	 */
	User findUser(String userId) throws Exception;
	/*
	 * 회원수정
	 */
	int update(User user) throws Exception;
	/*
	 * 회원탈퇴
	*/
	int remove(String userId) throws Exception;
	/*
	 * 회원아이디중복체크
	*/
	boolean isDuplcateUserId(String userId) throws Exception;
}