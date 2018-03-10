package com.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.model.Order;
import com.vo.OrderVO;

public interface IOrderDao {
	/**
	 * 添加订单
	 * 
	 * @param order
	 * @return
	 */
	public int saveOrder(Order order);
	
	/**
	 * 删除订单
	 * 
	 * @param id
	 * @return
	 */
	public int deleteOrder(List<String> id);
	
	/**
	 * 修改订单
	 * 
	 * @param order
	 * @return
	 */
	public int updateOrder(Order order);
	
	/**
	 * 查询订单
	 * 
	 * @param order
	 * @return
	 */
	public List<Order> queryOrderList(OrderVO orderVO);
	
	/**
	 * 查询订单数量
	 * 
	 * @param order
	 * @return
	 */
	public Map<String, BigDecimal>queryCountOrder(OrderVO orderVO);
}
