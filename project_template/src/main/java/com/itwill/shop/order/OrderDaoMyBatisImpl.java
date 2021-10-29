package com.itwill.shop.order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class OrderDaoMyBatisImpl implements OrderDao{
	public static final String NAMESPACE="com.itwill.shop.order.mapper.OrderMapper.";
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int delete(String sUserId) throws Exception {
		return sqlSession.delete(NAMESPACE+"delete",sUserId);
	}

	@Override
	public int deleteByOrderNo(int o_no) throws Exception {
		return sqlSession.delete(NAMESPACE+"deleteByOrderNo", o_no);
	}

	@Override
	public int create(Order order) throws Exception {
		this.createOrder(order);
		for (OrderItem orderItem : order.getOrderItemList()) {
			this.createOrderItem(orderItem);
		}
		return 0;
	}
	/*******************************************************/
	private int createOrder(Order order) throws Exception {
		return sqlSession.insert(NAMESPACE+"createOrder",order);
	}
	
	private int createOrderItem(OrderItem orderItem) throws Exception {
		return sqlSession.insert(NAMESPACE+"createOrderItem",orderItem);
	}
	/*********************************************************/
	@Override
	public List<Order> list(String sUserId) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+"list",sUserId);
	}

	@Override
	public Order detail(String userId, int o_no) throws Exception {
		Map paramMap=new HashMap();
		paramMap.put("userId", userId);
		paramMap.put("o_no", o_no);
		return sqlSession.selectOne(NAMESPACE+"detail",paramMap);
	}

}
