package com.itwill.shop.order;

import java.util.ArrayList;
import java.util.List;

public interface OrderDao {

	/*
	 * 주문전체삭제(ON DELETE CASCADE)
	 */
	int delete(String sUserId) throws Exception;

	/*
	 * 주문1건삭제
	 */
	/*
	public int delete(int j_no)throws Exception{
		String deleteSql1="delete from order_item where o_no=?";
		String deleteSql2="delete from orders where o_no=?";
		Connection con=null;
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt2=null;
		try {
			con=dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt1=con.prepareStatement(deleteSql1);
			pstmt2=con.prepareStatement(deleteSql2);
			pstmt1.setInt(1, j_no);
			pstmt2.setInt(1, j_no);
			int rowCount1 = pstmt1.executeUpdate();
			int rowCount2 = pstmt2.executeUpdate();
			con.commit();
		}catch (Exception e) {
			con.rollback();
			e.printStackTrace();
			throw e;
		}finally {
			if(con!=null)con.close();
		}
		return 0;
	}
	*/
	/*
	 * 주문1건삭제(ON DELETE CASCADE)
	 */
	int deleteByOrderNo(int o_no) throws Exception;

	/*
	 * 주문생성(JDBC)
	 */
	int create(Order order) throws Exception;
	
	/*
	 * 주문전체(특정사용자)
	 */
	List<Order> list(String sUserId) throws Exception;

	/*
	 * 주문1개보기(주문상세리스트)
	 */
	Order detail(String sUserId, int o_no) throws Exception;

}