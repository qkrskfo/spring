package com.itwill.shop.user;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class UserDaoMyBatisImpl implements UserDao {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int create(User user) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(User user) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int remove(String userId) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User findUser(String userId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findUserList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existedUser(String userId) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
