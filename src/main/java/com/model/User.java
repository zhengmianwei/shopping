package com.model;

public class User {
	private String id; // 用户主键Id
	private String username; // 用户名
	private String password; // 密码
	private String enbale; // 是否可用 1为可用, 0为不可用
	private String createTime; // 创建时间
	private String updateTime; // 修改时间
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEnbale() {
		return enbale;
	}
	public void setEnbale(String enbale) {
		this.enbale = enbale;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	
}
