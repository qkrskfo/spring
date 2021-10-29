package com.itwill.shop.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	/*
	 * 회원가입
	 */
	@Override
	public int create(User user)throws Exception{
		//1.아이디중복체크
		if(userDao.existedUser(user.getUserId())) {
			//아이디중복
			return -1;
		}else {
			//아이디안중복
			//2.회원가입
			int insertRowCount=userDao.create(user);
			return insertRowCount;
		}
	}
	/*
	 * 회원로그인
	 */
	@Override
	public int login(String userId,String password) throws Exception {
		int result=-1;
		//1.아이디 존재여부
		User user = userDao.findUser(userId);
		if(user==null) {
			//아이디존재안함
			result=0;
		}else {
			//아이디존재함
			if(user.getPassword().equals(password)) {
				//패쓰워드일치(로그인성공)
				result=2;
			}else {
				//패쓰워드불일치
				result=1;
			}
		}
		return result;
	}
	/*
	 * 회원전체리스트
	 */
	@Override
	public List<User> findUserList() throws Exception {
		return userDao.findUserList();
	}

	/*
	 * 회원1명보기
	 */
	@Override
	public User findUser(String userId) throws Exception {
		User findUser = userDao.findUser(userId);
		return findUser;
	}

	/*
	 * 회원수정
	 */
	@Override
	public int update(User user) throws Exception {
		return userDao.update(user);
	}

	/*
	 * 회원탈퇴
	 */
	@Override
	public int remove(String userId) throws Exception {
		return userDao.remove(userId);
	}

	/*
	 * 아이디중복체크
	 * 
	 */
	public boolean isDuplcateUserId(String userId) throws Exception {
		boolean isExist = userDao.existedUser(userId);
		if (isExist) {
			return true;
		} else {
			return false;
		}
	}

}