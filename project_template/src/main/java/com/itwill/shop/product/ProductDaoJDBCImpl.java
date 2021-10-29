package com.itwill.shop.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//@Repository
public class ProductDaoJDBCImpl implements ProductDao {
	//@Autowired
	private DataSource dataSource;
	@Override
	public ArrayList<Product> getProductList() throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Product> productList = null;

		try {
			con = dataSource.getConnection();
			String sql = "select * from product";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			productList = new ArrayList<Product>();
			Product product = null;
			while (rs.next()) {
				product = new Product();
				product.setP_no(rs.getInt("p_no"));
				product.setP_name(rs.getString("p_name"));
				product.setP_price(rs.getInt("p_price"));
				product.setP_desc(rs.getString("p_desc"));
				product.setP_image(rs.getString("p_image"));
				product.setP_click_count(rs.getInt("p_click_count"));
				productList.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();

		}
		return productList;
	}

	@Override
	public Product getProduct(int p_no) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Product product = null;

		try {
			con = dataSource.getConnection();
			String sql = "select * from product where p_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, p_no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				product = new Product();
				product.setP_no(rs.getInt("p_no"));
				product.setP_name(rs.getString("p_name"));
				product.setP_price(rs.getInt("p_price"));
				product.setP_desc(rs.getString("p_desc"));
				product.setP_image(rs.getString("p_image"));
				product.setP_click_count(rs.getInt("p_click_count"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();

		}
		return product;
	}

	@Override
	public boolean updateReadcount(int p_no) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean result = false;

		try {
			con = dataSource.getConnection();
			String sql = "update product set p_click_count = p_click_count+1 where p_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, p_no);
			int count = pstmt.executeUpdate();

			if (count > 0) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();

		}
		return result;
	}
}