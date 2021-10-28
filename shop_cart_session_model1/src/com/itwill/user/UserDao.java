package com.itwill.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.tomcat.dbcp.dbcp2.ConnectionFactory;
/*
 사용자관리에서 데이타베이스와의 작업을 전담하는 클래스
 USERINFO 테이블에 사용자를 추가,삭제,검색,수정등의 작업을한다.
 */
public class UserDao  {
	/*
	 * Connection을 반환해주는객체
	 */
	private DataSource dataSource;
	/*
	public UserDao() throws Exception {
		InitialContext ic = new InitialContext();
		dataSource = (DataSource) ic.lookup("java:/comp/env/jdbc/OracleDB");
		System.out.println("UserDao()생성자:" + this + "-->" + dataSource);
	}
	*/
	  public UserDao() throws Exception { 
		  Properties properties=new Properties();
		  properties.load(this.getClass().getResourceAsStream("/com/itwill/shop/jdbc.properties"));
		  /*** Apache DataSource ***/
		  BasicDataSource basicDataSource = new BasicDataSource();
		  basicDataSource.setDriverClassName(properties.getProperty("driverClass"));
		  basicDataSource.setUrl(properties.getProperty("url"));
		  basicDataSource.setUsername(properties.getProperty("user"));
		  basicDataSource.setPassword(properties.getProperty("password")); 
		  dataSource = basicDataSource; 
	  }
	  
	/*
	 * 사용자관리테이블에 새로운사용자생성
	 */
	public int create(User user) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		String insertQuery = "insert into user1 values(?,?,?,?)";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(insertQuery);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getEmail());
			int rows = pstmt.executeUpdate();
			return rows;
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
	}

	/*
	 * 기존의 사용자정보를 수정
	 */
	public int update(User user) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		String updateQuery = "update user1 set password=?,name=?,email=? where userid=?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(updateQuery);
			pstmt.setString(1, user.getPassword());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getUserId());
			int rows = pstmt.executeUpdate();
			return rows;
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
	}

	/*
	 * 사용자아이디에해당하는 사용자를 삭제
	 */
	public int remove(String userId) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		String removeQuery = "delete from user1 where userid=?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(removeQuery);
			pstmt.setString(1, userId);
			int rows = pstmt.executeUpdate();
			return rows;
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
	}
	
	/*
	 * 사용자아이디에해당하는 정보를 데이타베이스에서 찾아서
	 * User 도메인클래스에 저장하여 반환
	 */
	public User findUser(String userId) throws Exception {
		User user = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectQuery = "select userid,password,name,email from user1 where userid=?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(selectQuery);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new User(rs.getString("userid"),
						rs.getString("password"), rs.getString("name"),
						rs.getString("email"));
			}
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
		return user;
	}
	/*
	 * 모든사용자 정보를 데이타베이스에서 찾아서 
	 * List<User> 콜렉션 에 저장하여 반환
	 */
	public ArrayList<User> findUserList() throws Exception {
		ArrayList<User> userList= new ArrayList<User>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectQuery = "select userid,password,name,email from user1";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(selectQuery);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				userList.add(new User(
						rs.getString("userid"),
						rs.getString("password"),
						rs.getString("name"),
						rs.getString("email")));
			}
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
		return userList;
	}
	/*
	 * 인자로 전달되는 아이디를 가지는 사용자가 존재하는지의 여부를판별
	 */
	public boolean existedUser(String userId)throws Exception{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String existedQuery="select count(*) cnt from user1" +
							" where userid=?";
		try{
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(existedQuery);
			pstmt.setString(1, userId);
			rs=pstmt.executeQuery();
			int count=0;
			if(rs.next()){
				count=rs.getInt("cnt");
			}
			if(count==1){
				return true;
			}else{
				return false;
			}
		}finally{
			if(rs!=null)
				rs.close();
			if(pstmt!=null)
				pstmt.close();
			if(con!=null)
				con.close();
		}
		
	}
	
}














