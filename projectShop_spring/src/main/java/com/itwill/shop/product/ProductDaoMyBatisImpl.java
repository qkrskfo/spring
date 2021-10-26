package com.itwill.shop.product;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository("productDao")
public class ProductDaoMyBatisImpl implements ProductDao {
	public final static String NAMESPACE=
			"com.itwill.shop.product.mapper.ProductMapper.";
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<Product> getProductList() throws Exception {
		List<Product> productList = sqlSession.selectList(NAMESPACE+"getProductList");
		return productList;
	}

	@Override
	public Product getProduct(int p_no) throws Exception {
		Product product = sqlSession.selectOne(NAMESPACE+"getProduct",p_no);
		return product;
	}

	@Override
	public boolean updateReadcount(int p_no) throws Exception {
		boolean result = false;
		int updateCount = sqlSession.update(NAMESPACE+"updateReadcount", p_no);
		if(updateCount>0) {
			result = true;
		}
		return result;
	}
}