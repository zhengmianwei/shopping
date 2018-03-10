package com.service;

import java.util.List;

import com.model.Role;
import com.vo.DatagridVO;
import com.vo.RoleVO;

public interface RoleService {
	public int addRole(Role role); // 添加角色信息
	
	public int removeRole(List<String> list); // 删除角色信息
	
	public int updateRole(Role role); // 修改角色信息
	
	public int enbaleRole(List<String> list); // 启用角色功能
	
	public int disableRole(List<String> list); //禁用角色功能
	
	public DatagridVO<Role> findRole(RoleVO roleVO); // 查询角色信息
}
