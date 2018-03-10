package com.vo;

import com.model.Page;

public class OrderVO extends Page{
	// 订单号
	private String orderNo;
	// 商品号
	private String goodsNo;
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getGoodsNo() {
		return goodsNo;
	}
	public void setGoodsNo(String goodsNo) {
		this.goodsNo = goodsNo;
	}
	
	
}
