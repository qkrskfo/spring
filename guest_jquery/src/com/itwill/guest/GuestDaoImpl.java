package com.itwill.guest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class GuestDaoImpl implements GuestDao {
	private DataSource dataSource;
	
	public GuestDaoImpl() throws Exception{
		  Properties properties=new Properties();
		  properties.load(this.getClass().getResourceAsStream("/db.properties"));
		  /*** Apache DataSource ***/
		  BasicDataSource basicDataSource = new BasicDataSource();
		  basicDataSource.setDriverClassName(properties.getProperty("driverClass"));
		  basicDataSource.setUrl(properties.getProperty("url"));
		  basicDataSource.setUsername(properties.getProperty("user"));
		  basicDataSource.setPassword(properties.getProperty("password")); 
		  dataSource = basicDataSource; 
	}
	
	@Override
	public int insertGuest(Guest guest) throws Exception {
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(GuestSQL.GUEST_INSERT);
		pstmt.setString(1,guest.getGuest_name());
		pstmt.setString(2,guest.getGuest_email());
		pstmt.setString(3,guest.getGuest_homepage());
		pstmt.setString(4,guest.getGuest_title());
		pstmt.setString(5,guest.getGuest_content());
		int insertRowCount=pstmt.executeUpdate();
		con.close();
		return insertRowCount;
	}
	
	@Override
	public Guest selectByNo(int no) throws Exception {
		Guest guest=null;
		Connection con = 
				dataSource.getConnection();
		PreparedStatement pstmt=
				con.prepareStatement(GuestSQL.GUEST_SELECT_NO);
		pstmt.setInt(1, no);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
					guest=new Guest(rs.getInt("guest_no"),
							rs.getString("guest_name"),
							rs.getString("guest_date"),
							rs.getString("guest_email"),
							rs.getString("guest_homepage"),
							rs.getString("guest_title"),
							rs.getString("guest_content"));
			
		}
		con.close();
		
		return guest ;
	}

	
	@Override
	public ArrayList<Guest> selectAll() throws Exception {
		ArrayList<Guest> guestList=new ArrayList<Guest>();
		
		Connection con = 
				dataSource.getConnection();
		PreparedStatement pstmt=
				con.prepareStatement(GuestSQL.GUEST_SELECT_ALL);
		ResultSet rs=pstmt.executeQuery();
		while (rs.next()) {
			guestList.add(
					new Guest(rs.getInt("guest_no"),
							rs.getString("guest_name"),
							rs.getString("guest_date"),
							rs.getString("guest_email"),
							rs.getString("guest_homepage"),
							rs.getString("guest_title"),
							rs.getString("guest_content")));
		}
		con.close();
		return guestList;
	}
	
	@Override
	public int updateGuest(Guest guest) throws Exception {
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(GuestSQL.GUEST_UPDATE);
		pstmt.setString(1,guest.getGuest_name());
		pstmt.setString(2,guest.getGuest_email());
		pstmt.setString(3,guest.getGuest_homepage());
		pstmt.setString(4,guest.getGuest_title());
		pstmt.setString(5,guest.getGuest_content());
		pstmt.setInt(6,guest.getGuest_no());
		int updateRowCount=pstmt.executeUpdate();
		con.close();
		return updateRowCount;
	}

	@Override
	public int deleteGuest(int no) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(GuestSQL.GUEST_DELETE);
		pstmt.setInt(1, no);
		int deleteRowCount=pstmt.executeUpdate();
		con.close();
		return deleteRowCount;
	}
}















