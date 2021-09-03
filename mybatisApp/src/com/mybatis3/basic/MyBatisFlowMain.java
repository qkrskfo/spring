package com.mybatis3.basic;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis3.domain.Student;

public class MyBatisFlowMain {

	public static void main(String[] args) throws Exception{
		/*
		 * 0. mybatis-config.xml --> InputStream
		 */
		InputStream myBatisConfigInputStream = Resources.getResourceAsStream("mybatis-config.xml");
		
		/*
		 * 1. SqlSessionFactoryBuilder
		 */
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		
		/*
		 * 2. SqlSessionFactory
		 */
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(myBatisConfigInputStream);
		
		/*
		 * 3. SqlSession open
		 */
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		/*
		 * auto commit true
		 */
		
		/*
		 * 4. SqlSession사용(CRUD)
		 */
		System.out.println("##### SqlSession 객체: "+sqlSession);
		/*
		sqlSession.select(null);
		sqlSession.delete(null);
		sqlSession.update(null);
		sqlSession.insert(null);
		*/
		
		/*
		 * 5. SqlSession close
		 */
		sqlSession.close();
		
	}
}













