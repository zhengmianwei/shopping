package com.model;

public class Page{
	private Integer page;
	private Integer rows;
	private Integer startPage;
	private Integer endPage;
	public Page() {
		
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public Integer getRows() {
		return rows;
	}
	public Integer getStartPage() {
		startPage = (page-1)*rows;
		return startPage;
	}
	public void setStartPage(Integer startPage) {
		this.startPage = startPage;
	}
	public Integer getEndPage() {
		endPage = rows;
		return endPage;
	}
	public void setEndPage(Integer endPage) {
		this.endPage = endPage;
	}
}
