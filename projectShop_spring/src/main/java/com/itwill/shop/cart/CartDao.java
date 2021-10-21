package com.itwill.shop.cart;

import java.util.ArrayList;
import java.util.List;

public interface CartDao {

	/*
	 * cart제품 존재여부
	 */
	boolean isProductExist(String sUserId, int p_no) throws Exception;

	/*
	 * cart insert
	 */
	int add(String sUserId, int p_no, int cart_qty) throws Exception;

	/*
	 * cart add update
	 */
	int update(String sUserId, int p_no, int cart_qty) throws Exception;

	/*
	 * cart update
	 */
	int update(int cart_no, int cart_qty) throws Exception;

	/*
	 * cart list
	 */
	List<CartItem> getCartList(String sUserId) throws Exception;

	/*
	 * cart pk delete
	 */
	int deleteCartByNo(int cart_no) throws Exception;

	/*
	 * cart  delete
	 */
	int deleteCart(String sUserId) throws Exception;

	CartItem getCartItemByCartNo(int cart_no) throws Exception;

}