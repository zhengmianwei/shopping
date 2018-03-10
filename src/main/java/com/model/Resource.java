package com.model;

import java.sql.Timestamp;

public class Resource {
	 private int id; // 主键id
	 private String resourceName; // 资源名称
	 private String resourceUrl; // 资源访问路径
	 private String description; // 资源描述
	 private String icon; // 资源图标
	 private String parentid; // 父节点id
	 private String resourceType; // 资源类型, 菜单或按钮
	 private int enable; // 是否可用
	 private int resourceOrder; // 资源排序
	 private Timestamp createTime; // 创建时间
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	
	public String getResourceUrl() {
		return resourceUrl;
	}
	public void setResourceUrl(String resourceUrl) {
		this.resourceUrl = resourceUrl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getParentid() {
		return parentid;
	}
	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
	public String getResourceType() {
		return resourceType;
	}
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}
	public int getEnable() {
		return enable;
	}
	public void setEnable(int enable) {
		this.enable = enable;
	}
	public int getResourceOrder() {
		return resourceOrder;
	}
	public void setResourceOrder(int resourceOrder) {
		this.resourceOrder = resourceOrder;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	 
}
