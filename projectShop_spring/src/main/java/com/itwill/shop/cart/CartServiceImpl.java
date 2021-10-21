package com.itwill.shop.cart;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private CartDao cartDao;
	/*
	 * 카트추가 or 수정
	 */
	@Override
	public int addCart(String sUserId,int p_no,int cart_qty)throws Exception {
		if(cartDao.isProductExist(sUserId, p_no)) {
			return cartDao.update(sUserId, p_no, cart_qty);
		}else {
			return cartDao.add(sUserId, p_no, cart_qty);
		}
	}
	/*
	 * 카트수량변경수정
	 */
	@Override
	public int updateCart(int cart_no,int cart_qty)throws Exception {
		return cartDao.update(cart_no, cart_qty);
	}
	/*
	 * 카트보기
	 */
	@Override
	public ArrayList<CartItem> getCartList(String sUserId) throws Exception{
		return cartDao.getCartList(sUserId);
	}
	/*
	 * 카트아이템1개보기
	 */
	@Override
	public CartItem getCartItemByCartNo(int cart_no) throws Exception{
		return cartDao.getCartItemByCartNo(cart_no);
	}
	
	/*
	 * 카트아이템1개삭제
	 */
	@Override
	public int deleteCartItem(int cart_no) throws Exception{
		return cartDao.deleteCartByNo(cart_no);
	}
	/*
	 * 카트삭제
	 */
	@Override
	public int deleteCart(String sUserId)throws Exception {
		return cartDao.deleteCart(sUserId);
	}
}
