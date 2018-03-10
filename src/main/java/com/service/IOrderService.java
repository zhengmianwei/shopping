package com.service;

import java.util.List;

import com.model.Order;
import com.model.Page;
import com.vo.DatagridVO;
import com.vo.OrderVO;

public interface IOrderService {
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
	public boolean deleteOrder(String id);
	
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
	public DatagridVO<Order> queryOrderList(OrderVO orderVO);
}
