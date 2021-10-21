package com.itwill.shop.cart;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("cartDao")
public class CartDaoMyBatisImpl implements CartDao {
	public static final String NAMESPACE="com.itwill.shop.cart.mapper.CartMapper.";
	@Autowired
	private SqlSession sqlSession;
	

	@Override
	public boolean isProductExist(String sUserId, int p_no) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int add(String sUserId, int p_no, int cart_qty) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(String sUserId, int p_no, int cart_qty) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(int cart_no, int cart_qty) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CartItem> getCartList(String sUserId) throws Exception {
		//return sqlSession.selectList("com.itwill.shop.cart.mapper.CartMapper.getCartList, sUserId);
		return sqlSession.selectList(NAMESPACE+"getCartList", sUserId);
	}

	@Override
	public int deleteCartByNo(int cart_no) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCart(String sUserId) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CartItem getCartItemByCartNo(int cart_no) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}