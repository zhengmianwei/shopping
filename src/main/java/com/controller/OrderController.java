package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.Order;
import com.model.Page;
import com.service.IOrderService;
import com.vo.DatagridVO;
import com.vo.OrderVO;

@Controller
@RequestMapping(value = "/order")
public class OrderController {
	@Autowired
	private IOrderService orderService;
	/**
	 * 保存订单
	 * 
	 * @param order
	 * @return
	 */
	@RequestMapping(value = "/save")
	@ResponseBody
	public int saveOrder(Order order) {
		return orderService.saveOrder(order);
	}
	
	/**
	 * 删除订单
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/remove")
	@ResponseBody
	public boolean deleteOrder(String id) {
		return orderService.deleteOrder(id);
	}
	
	/**
	 * 修改订单
	 * 
	 * @param order
	 * @return
	 */
	@RequestMapping(value = "/modify")
	@ResponseBody
	public int updateOrder(Order order) {
		return orderService.updateOrder(order);
	}
	
	@RequestMapping(value="/toList")
	public String toOrderQuery() {
		return "/order";
	}
	
	/**
	 * 查询订单
	 * 
	 * @param order
	 * @return
	 */
	@RequestMapping(value = "/queryList")
	@ResponseBody
	public DatagridVO<Order> queryOrderList(OrderVO orderVO) {
		return orderService.queryOrderList(orderVO);
	}
}
