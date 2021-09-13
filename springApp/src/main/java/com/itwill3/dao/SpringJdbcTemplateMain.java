package com.itwill3.dao;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.itwill3.dao.user.User;

public class SpringJdbcTemplateMain {

	public static void main(String[] args) throws Exception {
		/*
		 * ApplicationContext[BeanFactory]객체생성 - Spring Container객체생성
		 */
		System.out.println("------------Spring Container초기화시작----------------");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"com/itwill3/dao/3.spring_jdbctemplate.xml");
		System.out.println("------------Spring Container초기화끝------------------");
		JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");

		String USER_INSERT = "insert into userinfo(userid,password,name,email) values(?,?,?,?)";
		
		String USER_SELECT_BY_ID = "select userid,password,name,email from userinfo where userid=?";
		String USER_SELECT_ALL = "select userid,password,name,email from userinfo";
		String USER_SELECT_BY_ID_COUNT = "select count(*) cnt from userinfo where userid=?";
		
		String USER_UPDATE = "update  userinfo set password=?,name=?,email=? where userid=?";
		String USER_REMOVE = "delete userinfo where userid=?";
		System.out.println("---------------JdbcTemplate.update[insert]--------------");
		//int insertRowCount = jdbcTemplate.update(USER_INSERT,"aaaa","1111","에이에이","a@gmail.com");
		//System.out.println("insert row count:"+insertRowCount);
		System.out.println("---------------JdbcTemplate.update[update]--------------");
		int updateRowCount=jdbcTemplate.update(USER_UPDATE,"aaaa","에이수정","achange@gmail.com","aaaa");
		System.out.println("update row count:"+updateRowCount);
		System.out.println("---------------JdbcTemplate.update[delete]--------------");
		int deleteRowCount=jdbcTemplate.update(USER_REMOVE,"asdf");
		System.out.println("delete row count:"+deleteRowCount);
		
		System.out.println("---------------JdbcTemplate.queryForObject[select one(DTO)]");
		User user = jdbcTemplate.queryForObject( USER_SELECT_BY_ID,new Object[]{"aaaa"}, 
					new BeanPropertyRowMapper<User>(User.class)); 
		/*
		 * BeanPropertyRowMapper객체
		 *  1. sql문실행 
		 *  2. User객체생성
		 *  3. 컬럼의이름과일치하는 User객체 property에 데이타를  setting
		 */
		System.out.println(user);
		System.out.println("---------------JdbcTemplate.queryForObject[select one(Integer)]");
		Integer count =jdbcTemplate.queryForObject(USER_SELECT_BY_ID_COUNT, new Object[]{"aaaa"},Integer.class);
		System.out.println("count:"+count);
		System.out.println("---------------JdbcTemplate.query[select many]");
		List<User> userList=jdbcTemplate.query(USER_SELECT_ALL,new BeanPropertyRowMapper<User>(User.class));
		System.out.println(userList);
		System.out.println("*************************** MAP **********************************");
		System.out.println("---------------JdbcTemplate.queryForMap[select one]");
		Map rowMap=jdbcTemplate.queryForMap(USER_SELECT_BY_ID,"aaaa");
		System.out.println(rowMap);
		String userId = (String)rowMap.get("USERID");
		String password = (String)rowMap.get("PASSWORD");
		String name = (String)rowMap.get("NAME");
		String email = (String)rowMap.get("EMAIL");
		System.out.println("rowMap-->"+userId+" "+password+" "+name+" "+email);
		
		System.out.println("--- JdbTemplate.queryForList[selet many map]");
		List<Map<String,Object>> rowMapList = jdbcTemplate.queryForList(USER_SELECT_ALL);
		for(Map<String, Object> tempRowMap : rowMapList) {
			System.out.println("rowMap --> "+tempRowMap);
		}
		
	}

}