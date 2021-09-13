package com.itwill3.dao.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImplSpringDao implements UserDao{
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int create(User user) throws Exception {
		return jdbcTemplate.update(UserSQL.USER_INSERT,
									user.getUserId(),
									user.getPassword(),
									user.getName(),
									user.getEmail());
	}

	@Override
	public int update(User user) throws Exception {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(UserSQL.USER_UPDATE,
				                  user.getPassword(),
				                  user.getName(),
				                  user.getEmail(),
				                  user.getUserId());
	}

	@Override
	public int remove(String userId) throws Exception {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(UserSQL.USER_REMOVE,userId);
	}

	@Override
	public User findUser(String userId) throws Exception {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(UserSQL.USER_SELECT_BY_ID,
											new Object[] {userId},
											new BeanPropertyRowMapper<User>(User.class));
	}

	@Override
	public ArrayList<User> findUserList() throws Exception {
		List<User> uList= jdbcTemplate.query(UserSQL.USER_SELECT_ALL,
							new BeanPropertyRowMapper<User>(User.class) );
		ArrayList<User> userList=(ArrayList<User>)uList;
		return userList;
	}

	@Override
	public boolean existedUser(String userId) throws Exception {
		int count=jdbcTemplate.queryForObject(UserSQL.USER_SELECT_BY_ID_COUNT,
									new Object[] {userId},Integer.class);
		if(count==1) {
			return true;
		}else {
			return false;
		}
	}

}