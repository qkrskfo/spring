package com.itwill.shop.product;

import java.util.List;

public interface ProductService {

	/*
	 * DogProduct 리스트반환
	 */
	List<Product> getProductList() throws Exception;

	/*
	 * DogProduct 1개반환
	 */
	Product getProduct(int p_no) throws Exception;

	boolean updateReadcount(int p_no) throws Exception;

}