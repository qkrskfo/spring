package com.itwill.shop.cart;

import java.util.List;

public interface CartDao {

	/*
	 * cart제품 존재여부
	 */
	boolean isProductExist(String sUserId, int p_no) throws Exception;
	boolean isProductExist(CartItem cartItem) throws Exception;

	/*
	 * cart insert
	 */
	int addInsert(String sUserId,int p_no,int cart_qty) throws Exception;
	int addInsert(CartItem cartItem) throws Exception;
	

	/*
	 * cart add update
	 */
	int addUpdate(String sUserId,int p_no,int cart_qty) throws Exception;
	int addUpdate(CartItem cartItem) throws Exception;

	/*
	 * cart update
	 */
	int update(int cart_no, int cart_qty) throws Exception;
	int update(CartItem cartItem) throws Exception;

	/*
	 * cart item list
	 */
	List<CartItem> getCartList(String sUserId) throws Exception;
	/*
	 * cart item 
	 */
	CartItem getCartItemByCartNo(int cart_no) throws Exception;
	/*
	 * cart pk delete
	 */
	int deleteCartByNo(int cart_no) throws Exception;

	/*
	 * cart  delete
	 */
	int deleteCart(String sUserId) throws Exception;

	

}