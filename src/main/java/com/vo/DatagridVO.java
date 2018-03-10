package com.vo;

import java.util.ArrayList;
import java.util.List;

public class DatagridVO<T> {
	private int total; // 数量
	private List<T> rows = new ArrayList<T>(); // 数据
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	
}
