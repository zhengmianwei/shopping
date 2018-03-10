package com.dao.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.RoleDao;
import com.mapper.RoleMapper;
import com.model.Role;
import com.model.RoleMenu;
import com.util.ToolUtil;
import com.vo.RoleVO;
@Repository
public class RoleDaoImpl implements RoleDao{
	@Autowired
	private RoleMapper roleMapper;
	/**
	 * 添加角色信息
	 * 
	 * @param role
	 * @return
	 */
	public int addRole(Role role) {
		int result = roleMapper.addRole(role);
		return result;
	}
	
	/**
	 * 删除角色信息
	 * 
	 * @param id
	 * @return
	 */
	public int removeRole(List<String> list) {
		int result = roleMapper.removeRole(list);
		return result;
	}
	
	/**
	 * 修改角色信息
	 * 
	 * @param Role
	 * @return
	 */
	public int updateRole(Role role) {
		int result = roleMapper.updateRole(role);
		return result;
	}
	/**
	 * 启用角色权限
	 * 
	 * @param
	 * @return
	 */
	public int disableRole(List<String> list) {
		int result = roleMapper.disableRole(list);
		return result;
	}
	
	/**
	 * 禁用角色权限
	 * 
	 * @param
	 * @return
	 */
	public int enbaleRole(List<String> list) {
		int result = roleMapper.enbaleRole(list);
		return result;
	}
	/**
	 * 查询角色信息条数
	 * 
	 * @param Role
	 * @return
	 */
	public int findRoleTotal(RoleVO roleVO) {
		Map<String, BigDecimal> map = roleMapper.findRoleTotal(roleVO);
		int total = ToolUtil.objectToInteger(map.get("total"));
		return total;
	}
	/**
	 * 查询角色信息
	 * 
	 * @param
	 * @return
	 */
	public List<Role> findRole(RoleVO roleVO) {
		return roleMapper.findRole(roleVO);
	}
}
