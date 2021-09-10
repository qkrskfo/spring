package com.itwill.user;

import java.util.ArrayList;

public interface UserService {

	/*
	 * 회원가입
	 */
	/**************1.반환값사용***********************/
	int create(User user) throws Exception;

	/*********************************************/
	/**************2.사용자정의예외객체사용********
	public int create(User user)throws Exception{
		//1.아이디중복체크
		if(userDao.existedUser(user.getUserId())) {
			//아이디중복
			throw new ExistedUserException(user.getUserId()
					+" 는 이미존재하는 아이디입니다");
		}
		//2.회원가입
		return userDao.create(user);
	}
	***********************************************/
	/*
	 * 회원로그인
	 */
	int login(String userId, String password) throws Exception;
	/*
	 * 회원로그아웃
	 */

	/*
	 * 회원상세보기
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
	 * 전체회원리스트
	 */
	ArrayList<User> findUserList() throws Exception;

	/*
	 * 아이디중복체크
	 */
	boolean isDuplicateId(String userId) throws Exception;

}