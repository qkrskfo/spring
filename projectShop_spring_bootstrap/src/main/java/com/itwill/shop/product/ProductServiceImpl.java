package com.itwill.shop.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;
	
	/*
	 * DogProduct 리스트반환
	 */
	@Override
	public List<Product> getProductList() throws Exception {
		List<Product> productList = productDao.getProductList();
		return productList;
	}

	/*
	 * DogProduct 1개반환
	 */
	@Override
	public Product getProduct(int p_no) throws Exception {
		Product product = productDao.getProduct(p_no);
		return product;
	}
	
	@Override
	public boolean updateReadcount(int p_no) throws Exception {
		boolean result = false;
		result = productDao.updateReadcount(p_no);
		return result;
	}
	
}