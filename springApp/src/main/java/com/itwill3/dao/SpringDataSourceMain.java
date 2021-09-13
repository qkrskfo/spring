package com.itwill3.dao;
import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class SpringDataSourceMain {

	public static void main(String[] args) throws Exception {
		/*
		 * ApplicationContext[BeanFactory]객체생성
		 *  - Spring Container객체생성
		 */
		System.out.println("------------Spring Container초기화시작----------------");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"com/itwill3/dao/3.spring_jdbctemplate.xml");
		System.out.println("------------Spring Container초기화끝------------------");
		/*
		DataSource apacheDataSource = (DataSource)applicationContext.getBean("apacheDataSource");
		System.out.println("### 1.ApacheDataSource"+apacheDataSource);
		System.out.println("### 1.ApacheDataSource Connection"+apacheDataSource.getConnection());
		
		DataSource springDataSource = (DataSource)applicationContext.getBean("springDataSource");
		System.out.println("### 2.SpringDataSource"+springDataSource);
		System.out.println("### 2.SpringDataSource Connection"+springDataSource.getConnection());
		*/
		
		JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");

		String USER_INSERT = "insert into userinfo(userid,password,name,email) values(?,?,?,?)";
		String USER_UPDATE = "update  userinfo set password=?,name=?,email=? where userid=?";
		String USER_REMOVE = "delete userinfo where userid=?";
		String USER_SELECT_BY_ID = "select userid,password,name,email from userinfo where userid=?";
		String USER_SELECT_ALL = "select userid,password,name,email from userinfo";
		String USER_SELECT_BY_ID_COUNT = "select count(*) cnt from userinfo where userid=?";
		System.out.println("---------------update[insert]--------------");
		//int insertRowCount = jdbcTemplate.update(USER_INSERT,"aaaa","1111","에이에이","a@gmail.com");
		//System.out.println("insert row count:"+insertRowCount);
	}

}