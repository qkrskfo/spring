package com.itwill.shop.user;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository("userDao")
public class UserDaoMyBatisImpl implements UserDao{
	
	public final static String NAMESPACE=
			"com.itwill.shop.user.mapper.UserMapper.";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int create(User user) throws Exception {
		return sqlSession.insert(NAMESPACE+"create",user);
	}

	@Override
	public int update(User user) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(NAMESPACE+"update",user);
	}

	@Override
	public int remove(String userId) throws Exception {
		return sqlSession.delete(NAMESPACE+"remove",userId);
		
	}

	@Override
	public User findUser(String userId) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+"findUser",userId);
	}

	@Override
	public ArrayList<User> findUserList() throws Exception {
		List<User> uList = sqlSession.selectList(NAMESPACE+"findUserList");
		ArrayList<User> userList=(ArrayList<User>)uList;
		return userList;
	}

	@Override
	public boolean existedUser(String userId) throws Exception {
		int count = sqlSession.selectOne(NAMESPACE+"existedUser",userId);
		if(count==1) {
			return true;
		}else {
			return false;
		}
	}

}
