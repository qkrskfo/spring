package com.itwill3.dao.user;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class UserDaoImplMyBatis implements UserDao{
	public final static String NAMESPACE="com.itwill3.dao.user.mapper.UserMapper.";
	private SqlSession sqlSession;
	
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public int create(User user) throws Exception {
		return sqlSession.insert(NAMESPACE+"create");//mapper에 insert id가 create잖아
	}

	@Override
	public int update(User user) throws Exception {
		return sqlSession.update(NAMESPACE+"update", user);
	}

	@Override
	public int remove(String userId) throws Exception {
		return sqlSession.delete(NAMESPACE+"remove, userId");
	}

	@Override
	public User findUser(String userId) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"findUser", userId);
	}

	@Override
	public ArrayList<User> findUserList() throws Exception {
		List<User> uList = sqlSession.selectList(NAMESPACE+"findUserList");
		ArrayList<User> userList = (ArrayList<User>)uList;
		return userList;
	}

	@Override
	public boolean existedUser(String userId) throws Exception {
		int count = sqlSession.selectOne(NAMESPACE+"existedUser", userId);
		if(count==1) {
			return true;
		} else {
			return false;
		}
	}

}