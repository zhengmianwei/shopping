package com.dao.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.IOrderDao;
import com.mapper.OrderMapper;
import com.model.Order;
import com.vo.OrderVO;
@Repository
public class OrderDaoImpl implements IOrderDao{
	@Autowired
	private OrderMapper orderMapper;
	/**
	 * 添加订单
	 * 
	 * @param order
	 * @return
	 */
	public int saveOrder(Order order) {
		return orderMapper.saveOrder(order);
	}
	
	/**
	 * 删除订单
	 * 
	 * @param id
	 * @return
	 */
	public int deleteOrder(List<String> id) {
		return orderMapper.deleteOrder(id);
	}
	
	/**
	 * 修改订单
	 * 
	 * @param order
	 * @return
	 */
	public int updateOrder(Order order) {
		return orderMapper.modifyOrder(order);
	}
	
	/**
	 * 查询订单
	 * 
	 * @param order
	 * @return
	 */
	public List<Order> queryOrderList(OrderVO orderVO) {
		return orderMapper.queryOrderList(orderVO);
	}
	
	/**
	 * 查询订单数量
	 * 
	 * @param order
	 * @return
	 */
	public Map<String, BigDecimal>queryCountOrder(OrderVO orderVO) {
		return orderMapper.queryCountOrder(orderVO);
	}
}
