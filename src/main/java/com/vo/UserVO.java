package com.vo;

import com.model.Page;

public class UserVO extends Page{
	private String username; // 用户名
	private String password; // 密码
	private String oldpwd; // 旧密码
	private String newpwd; // 新密码
	
	private Integer enbale; // 是否可用 1为可用, 0为不可用
	private String createTime; // 创建时间
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getEnbale() {
		return enbale;
	}
	public void setEnbale(Integer enbale) {
		this.enbale = enbale;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getOldpwd() {
		return oldpwd;
	}
	public void setOldpwd(String oldpwd) {
		this.oldpwd = oldpwd;
	}
	public String getNewpwd() {
		return newpwd;
	}
	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}
	
}
