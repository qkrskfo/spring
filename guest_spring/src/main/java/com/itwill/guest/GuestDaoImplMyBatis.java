package com.itwill.guest;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class GuestDaoImplMyBatis implements GuestDao{
	public static final String NAMESPACE="com.itwill.guest.mapper.GuestMapper.";
	private SqlSessionFactory sqlSessionFactory;
	public GuestDaoImplMyBatis() {
		try {
			InputStream myBatisConfigInputStream = Resources.getResourceAsStream("mybatis-config.xml");
			this.sqlSessionFactory=new SqlSessionFactoryBuilder().build(myBatisConfigInputStream);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public int insertGuest(Guest guest) throws Exception {
		return sqlSessionFactory.openSession(true).insert(NAMESPACE+"create",guest);
	}
	@Override
	public Guest selectByNo(int no) throws Exception {
		return sqlSessionFactory.openSession().selectOne(NAMESPACE+"selectByNo", no);
	}

	@Override
	public ArrayList<Guest> selectAll() throws Exception {
		List<Guest> gList = 
				sqlSessionFactory
				.openSession()
				.selectList(NAMESPACE+"selectAll");
		ArrayList<Guest> guestList = (ArrayList<Guest>)gList;
		return guestList;
	}

	@Override
	public int updateGuest(Guest guest) throws Exception {
		return sqlSessionFactory
				.openSession(true)
				.update(NAMESPACE+"updateGuest",guest);
	}

	@Override
	public int deleteGuest(int no) throws Exception {
		return sqlSessionFactory
				.openSession(true)
				.delete(NAMESPACE+"deleteGuest", no);
	}

}
