package com.itwill.user;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class UserDaoImplMyBatis implements UserDao {
	
	public static final String NAMESPACE="com.itwill.user.mapper.UserMapper.";
	private SqlSessionFactory sqlSessionFactory;
	
	public UserDaoImplMyBatis() {
		try {
			InputStream myBatisConfigInputStream = Resources.getResourceAsStream("mybatis-config.xml");
			this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(myBatisConfigInputStream);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int create(User user) throws Exception {
		return sqlSessionFactory.openSession(true).insert(NAMESPACE+"create", user);
	}

	@Override
	public int update(User user) throws Exception {
		return sqlSessionFactory.openSession(true).update(NAMESPACE+"update", user);
	}

	@Override
	public int remove(String userId) throws Exception {
		return sqlSessionFactory.openSession(true).delete(NAMESPACE+"delete", userId);
	}

	@Override
	public User findUser(String userId) throws Exception {
		return sqlSessionFactory.openSession(true).selectOne(NAMESPACE+"findUser", userId);
	}

	@Override
	public ArrayList<User> findUserList() throws Exception {
		List<User> tempUserList =sqlSessionFactory.openSession(true).selectList(NAMESPACE+"findUserList");
		ArrayList<User> userList = (ArrayList<User>)tempUserList;
		return userList;
		
	}

	@Override
	public boolean existedUser(String userId) throws Exception {
		int count = sqlSessionFactory.openSession(true).selectOne(NAMESPACE+"existedUser", userId);
		if(count==1) {
			return true;			
		} else {
			return false;
		}
	}

}
