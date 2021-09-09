package com.itwill0.context;

import java.util.ArrayList;
import java.util.List;

public class ProductDao {

	public ProductDao() {
		System.out.println("0. ### ProductDao() 생성자");
		
	}
	
	public List<Product> productList() {
		List<Product> productList = new ArrayList<Product>();
		productList.add(new Product());
		productList.add(new Product());
		productList.add(new Product());
		productList.add(new Product());
		productList.add(new Product());
		productList.add(new Product());
		return productList;
	}
	
}
