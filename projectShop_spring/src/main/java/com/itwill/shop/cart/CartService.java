package com.itwill.shop.cart;

import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
@Transactional(isolation = Isolation.READ_COMMITTED)
//transactional을 하면 아래 모든 메소드의 트랜잭션이 설정됨.

public interface CartService {

	/*
	 * 카트추가 or 수정
	 */
	
	// addcart는 다른 트랜잭션 레벨을 설정하고 싶으면 각 메소드 별로 설정 가능
	@Transactional(isolation = Isolation.SERIALIZABLE) //독립성 최상위 레벨(안좋음)
	int addCart(String sUserId, int p_no, int cart_qty) throws Exception;
	int addCart(CartItem cartItem) throws Exception;
	/*
	 * 카트수량변경수정
	 */
	int updateCart(int cart_no, int cart_qty) throws Exception;
	int updateCart(CartItem cartItem) throws Exception;

	/*
	 * 카트보기
	 */
	List<CartItem> getCartList(String sUserId) throws Exception;

	/*
	 * 카트아이템1개보기
	 */
	CartItem getCartItemByCartNo(int cart_no) throws Exception;

	/*
	 * 카트아이템1개삭제
	 */
	int deleteCartItem(int cart_no) throws Exception;

	/*
	 * 카트삭제
	 */
	int deleteCart(String sUserId) throws Exception;

}