package com.service.impl;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.IOrderDao;
import com.model.Order;
import com.service.IOrderService;
import com.util.ToolUtil;
import com.vo.DatagridVO;
import com.vo.OrderVO;
@Service
public class OrderServiceImpl implements IOrderService{
	@Autowired
	private IOrderDao orderDao;
	/**
	 * 添加订单
	 * 
	 * @param order
	 * @return
	 */
	public int saveOrder(Order order) {
		return orderDao.saveOrder(order);
	}
	
	/**
	 * 删除订单
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteOrder(String id) {
		List<String> list = new LinkedList<String>();
		String[] ids = id.split(",");
		for(int i = 0; i < ids.length; i++) {
			list.add(ids[i]);
		}
		int result = orderDao.deleteOrder(list);
		if(result > 0) {
			return true;
		} else {
			return false;
		}
		
	}
	
	/**
	 * 修改订单
	 * 
	 * @param order
	 * @return
	 */
	public int updateOrder(Order order) {
		return orderDao.updateOrder(order);
	}
	
	/**
	 * 查询订单
	 * 
	 * @param order
	 * @return
	 */
	public DatagridVO<Order> queryOrderList(OrderVO orderVO) {
		DatagridVO<Order> datagridVO = new DatagridVO<Order>();
		Map<String, BigDecimal> map = orderDao.queryCountOrder(orderVO);
		int total = ToolUtil.objectToInteger(map.get("total"));
		datagridVO.setRows(orderDao.queryOrderList(orderVO));
		datagridVO.setTotal(total);
		return datagridVO;
	}
}
