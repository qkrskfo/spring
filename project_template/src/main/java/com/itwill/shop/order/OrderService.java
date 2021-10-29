package com.itwill.shop.order;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
@Transactional
public interface OrderService {

	/*
	 * 주문1개삭제
	 */
	int deleteByOrderNo(int o_no) throws Exception;

	/*
	 * 주문전체삭제
	 */
	int delete(String sUserId) throws Exception;

	/*
	 * 주문목록
	 */
	List<Order> list(String sUserId) throws Exception;

	/*
	 * 주문상세보기
	 */
	Order detail(String sUserId, int o_no) throws Exception;

	/*
	 * 상품에서 직접주문
	 */
	int create(String sUserId, int p_no, int oi_qty) throws Exception;

	/*
	 * cart에서 주문
	 */
	int create(String sUserId) throws Exception;

	/*
	 * cart에서 선택주문
	 */
	int create(String sUserId, int[] cart_item_noStr_array) throws Exception;

}