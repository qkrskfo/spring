package com.itwill.shop.cart;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.shop.product.Product;
import com.itwill.shop.user.User;

@Repository("cartDao")
public class CartDaoMyBatisImpl implements CartDao{
	public static final String NAMESPACE="com.itwill.shop.cart.mapper.CartMapper.";
	
	@Autowired
	private SqlSession sqlSession;
	/*
	 * cart제품 존재여부확인
	 */
	@Override
	public boolean isProductExist(CartItem cartItem) throws Exception {
		boolean isExist=false;
		int productCount = sqlSession.selectOne(NAMESPACE+"isProductExist",cartItem);
		if(productCount==0) {
			isExist=false;
		}else if(productCount>0) {
			isExist=true;
		}
		return isExist;
	}
	@Override
	public boolean isProductExist(String sUserId, int p_no) throws Exception {
		CartItem cartItem = new CartItem(0,
										new User(sUserId, null, null, null),
						     			new Product(p_no, null, 0, null, null, 0),
						     			0);
		boolean isExist=false;
		int productCount = sqlSession.selectOne(NAMESPACE+"isProductExist",cartItem);
		if(productCount==0) {
			isExist=false;
		}else if(productCount>0) {
			isExist=true;
		}
		return isExist;
	}
	/*
	 * cart아이템 추가시 cart아이템 insert
	 */
	@Override
	public int addInsert(CartItem cartItem) throws Exception {
		return sqlSession.insert(NAMESPACE+"addInsert", cartItem);
	}
	@Override
	public int addInsert(String sUserId, int p_no, int cart_qty) throws Exception {
		CartItem cartItem = new CartItem(0,
										new User(sUserId, null, null, null),
						     			new Product(p_no, null, 0, null, null, 0),
						     			cart_qty);
		
		return sqlSession.insert(NAMESPACE+"addInsert", cartItem);
	}
	
	/*
	 * cart 아이템 추가시 수량 update
	 */
	@Override
	public int addUpdate(CartItem cartItem) throws Exception {
		return sqlSession.update(NAMESPACE+"addUpdate", cartItem);
	}
	@Override
	public int addUpdate(String sUserId, int p_no, int cart_qty) throws Exception {
		
		CartItem cartItem = new CartItem(0,
										new User(sUserId, null, null, null),
						     			new Product(p_no, null, 0, null, null, 0),
						     			cart_qty);
		
		return sqlSession.update(NAMESPACE+"addUpdate", cartItem);
	}
	/*
	 * cart 아이템 수량변경시 수량update
	 */
	@Override
	public int update(int cart_no, int cart_qty) throws Exception {
		System.out.println("CartDaoMyBatisImpl:"+cart_no+"-->"+cart_qty);
		CartItem cartItem=new CartItem(cart_no, null, null, cart_qty);
		return sqlSession.update(NAMESPACE+"update",cartItem);
	}
	@Override
	public int update(CartItem cartItem) throws Exception {
		return sqlSession.update(NAMESPACE+"update",cartItem);
	}
	/*
	 * cart item list
	 */
	@Override
	public List<CartItem> getCartList(String sUserId) throws Exception {
		return sqlSession.selectList(NAMESPACE+"getCartList", sUserId);
	}
	/*
	 * cart item
	 */
	@Override
	public CartItem getCartItemByCartNo(int cart_no) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getCartItemByCartNo",cart_no);
	}
	/*
	 * cart item1개삭제
	 */
	@Override
	public int deleteCartByNo(int cart_no) throws Exception {
		return sqlSession.delete(NAMESPACE+"deleteCartByNo",cart_no);
	}
	/*
	 * cart 전체삭제
	 */
	@Override
	public int deleteCart(String sUserId) throws Exception {
		return sqlSession.delete(NAMESPACE+"deleteCart", sUserId);
	}
	
}
