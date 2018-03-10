package com.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.model.Role;
import com.model.RoleMenu;
import com.vo.RoleVO;
public interface RoleMapper {
	public int addRole(Role role); // 添加角色信息
	
	public int removeRole(List<String> list); // 删除角色信息
	
	public int updateRole(Role role); // 修改角色信息
	
	//public int updateRoleStatus(List<String> list); // 修改角色信息状态
	
	public int enbaleRole(List<String> list); // 禁用角色权限
	
	public int disableRole(List<String> list); // 启用角色权限
	
	public Map<String, BigDecimal> findRoleTotal(RoleVO roleVO); // 查询角色信息条数
	
	public List<Role> findRole(RoleVO roleVO); // 查询角色信息
}
