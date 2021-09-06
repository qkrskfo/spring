package com.mybatis3.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis3.domain.Address;

public class AddressDao {
	private SqlSessionFactory sqlSessionFactory;
	public AddressDao() {
		try {
			InputStream myBatisConfigInputStream = Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			this.sqlSessionFactory = sqlSessionFactoryBuilder.build(myBatisConfigInputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/****************************  
	SELECT [addresses + students JOIN ] (1 : N) 
	*****************************/
	public Address findAddressByIdWithStudents(Integer addrId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Address address = sqlSession.selectOne("com.mybatis3.dao.mapper.AddressMapper.findAddressByIdWithStudents", addrId);
		sqlSession.close();
		return address;
	}
	
}
