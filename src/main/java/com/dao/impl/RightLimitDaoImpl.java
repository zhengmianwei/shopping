package com.dao.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.RightLimitDao;
import com.mapper.RightLimitMapper;
import com.model.Menu;
import com.model.RoleMenu;
import com.model.User;
import com.model.UserRole;
import com.util.ToolUtil;
@Repository
public class RightLimitDaoImpl implements RightLimitDao{
	@Autowired
	private RightLimitMapper rightLimitMapper;
	/**
	 * /**
	 * 根据用户名获取菜单模块
	 * 
	 * @param User
	 * @return
	 */
	public List<Menu> getMenuByUser(User user) {
		return rightLimitMapper.getMenuByUser(user);
	}
	/**
	 * 获取用户角色权限信息
	 * 
	 * @param username 用户名
	 * @return
	 */
	public List<UserRole> getUserRole(UserRole userRole) {
		return rightLimitMapper.getUserRole(userRole);
	}
	/**
	 * 删除用户角色权限
	 * 
	 * @param userId 用户id
	 * @return
	 */
	public int deleteUserRole(String userId) {
		return rightLimitMapper.deleteUserRole(userId);
	}
	
	/**
	 * 绑定用户角色权限
	 * 
	 * @param roleId 
	 * 			角色id
	 * @param userId 
	 * 			用户Id
	 * @retur 
	 */
	public int bindingUserRole(UserRole userRole) {
		return rightLimitMapper.bindingUserRole(userRole);
	}
	/**
	 * 获取角色权限信息
	 * 
	 * @param roleMenu
	 * @return
	 */
	public List<RoleMenu> getRoleMenu(RoleMenu roleMenu) {
		return rightLimitMapper.getRoleMenu(roleMenu);
	}
	/**
	 * 绑定角色权限
	 * 
	 * @param RoleMenu
	 * @return
	 */
	public int bindingMenu(RoleMenu roleMenu) {
		return rightLimitMapper.bindingMenu(roleMenu);
	}
	/**
	 * 根据角色id模块id获取角色模块信息
	 * 
	 * @param roleId
	 * @param menuId
	 * @return
	 */
	public int findRoleMenuTotal(RoleMenu roleMenu) {
		Map<String, BigDecimal> map = rightLimitMapper.findRoleMenuTotal(roleMenu);
		int total = ToolUtil.objectToInteger(map.get("total"));
		return total;
	}

	/**
	 * 删除角色模块
	 * 
	 * @param roleId
	 * @return
	 */
	public int deleteRoleMeun(String roleId) {
		return rightLimitMapper.deleteRoleMeun(roleId);
	}
}
