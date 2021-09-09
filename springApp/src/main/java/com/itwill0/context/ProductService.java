package com.itwill0.context;

import java.util.List;

public class ProductService {

	private ProductDao productDao;
	
	public ProductService() {
		System.out.println("0. ### ProductService() 생성자");
	}
	
	
	
	public ProductDao getProductDao() {
		return productDao;
	}



	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}



	public List<Product> productList() {
		return productDao.productList();
	}
	
}
