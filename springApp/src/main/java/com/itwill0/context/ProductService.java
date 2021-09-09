package com.itwill0.context;

import java.util.List;

public class ProductService {

	private ProductDao productDao;
	
	public ProductService() {
		
	}
	
	public List<Product> productList() {
		return productDao.productList();
	}
	
}
