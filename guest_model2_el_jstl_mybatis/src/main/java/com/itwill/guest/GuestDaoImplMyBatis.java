package com.itwill.guest;

import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class GuestDaoImplMyBatis implements GuestDao{
	public static final String NAMESPACE="com.itwill.guest.mapper.GuestMapper.";
	
	private SqlSessionFactory sqlSessionFactory;
	public GuestDaoImplMyBatis() {
		try {
			InputStream myBatisConfigInputStream = Resources.getResourceAsStream("mybatis-config.xml");
			this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(myBatisConfigInputStream);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public int insertGuest(Guest guest) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Guest selectByNo(int no) throws Exception {
		// TODO Auto-generated method stub
		return sqlSessionFactory.openSession().selectOne(NAMESPACE+"selectByNo",no);
	}

	@Override
	public ArrayList<Guest> selectAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateGuest(Guest guest) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteGuest(int no) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}


}