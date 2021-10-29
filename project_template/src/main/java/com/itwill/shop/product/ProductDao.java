package com.itwill.shop.product;

import java.util.List;

public interface ProductDao {

	List<Product> getProductList() throws Exception;

	Product getProduct(int p_no) throws Exception;

	boolean updateReadcount(int p_no) throws Exception;

}