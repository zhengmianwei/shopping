package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.RoleDao;
import com.model.Role;
import com.service.RoleService;
import com.util.ID;
import com.vo.DatagridVO;
import com.vo.RoleVO;
@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	private RoleDao roleDao;
	/**
	 * 添加角色信息
	 * 
	 * @param role
	 * @return
	 */
	public int addRole(Role role) {
		role.setId(ID.get());
		role.setEnbale("0");
		int result = roleDao.addRole(role);
		return result;
	}
	
	/**
	 * 删除角色信息
	 * 
	 * @param id
	 * @return
	 */
	public int removeRole(List<String> list) {
		int result = roleDao.removeRole(list);
		return result;
	}
	
	/**
	 * 修改角色信息
	 * 
	 * @param Role
	 * @return
	 */
	public int updateRole(Role role) {
		int result = roleDao.updateRole(role);
		return result;
	}
	
	/**
	 * 启用角色功能
	 * 
	 * @param
	 * @return
	 */
	public int enbaleRole(List<String> list) {
		int result = roleDao.enbaleRole(list);
		return result;
	}
	
	/**
	 * 禁用角色功能
	 */
	public int disableRole(List<String> list) {
		int result = roleDao.disableRole(list);
		return result;
	}
	
	/**
	 * 查询角色信息
	 * 
	 * @param
	 * @return
	 */
	public DatagridVO<Role> findRole(RoleVO roleVO) {
		int total = roleDao.findRoleTotal(roleVO);
		List<Role> list = roleDao.findRole(roleVO);
		DatagridVO<Role> datagridVO = new DatagridVO<Role>();
		datagridVO.setTotal(total);
		datagridVO.setRows(list);
		return datagridVO;
	}
}
