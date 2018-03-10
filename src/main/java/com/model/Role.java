package com.model;

public class Role {
	private String id; // 主键ID
	private String roleName; // 角色名称
	private String description; // 角色描述
	private String createTime; // 创建时间
	private String enbale; // 是否可用
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getEnbale() {
		return enbale;
	}
	public void setEnbale(String enbale) {
		this.enbale = enbale;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
