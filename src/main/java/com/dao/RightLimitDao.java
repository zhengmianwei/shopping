package com.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.model.Menu;
import com.model.RoleMenu;
import com.model.User;
import com.model.UserRole;

public interface RightLimitDao {
	/**
	 * 根据用户名获取菜单模块
	 * 
	 * @param User
	 * @return
	 */
	public List<Menu> getMenuByUser(User user);
	
	/**
	 * 获取用户角色权限信息
	 * 
	 * @param username 用户名
	 * @return
	 */
	public List<UserRole> getUserRole(UserRole userRole);
	/**
	 * 删除用户角色权限
	 * 
	 * @param userId 用户id
	 * @return
	 */
	public int deleteUserRole(String userId);
	
	/**
	 * 绑定用户角色权限
	 * 
	 * @param roleId 
	 * 			角色id
	 * @param userId 
	 * 			用户Id
	 * @retur 
	 */
	public int bindingUserRole(UserRole userRole);
	
	/**
	 * 获取角色权限信息
	 * 
	 * @param roleMenu
	 * @return
	 */
	public List<RoleMenu> getRoleMenu(RoleMenu roleMenu);
	/**
	 * 删除用户
	 */
	
	/**
	 * 绑定角色权限
	 * 
	 * @param RoleMenu
	 * @return
	 */
	public int bindingMenu(RoleMenu roleMenu);
	/**
	 * 根据角色id模块id获取角色模块信息
	 * 
	 * @param roleId
	 * @param menuId
	 * @return
	 */
	public int findRoleMenuTotal(RoleMenu roleMenu);
	
	/**
	 * 删除角色模块
	 * 
	 * @param roleId
	 * @return
	 */
	public int deleteRoleMeun(String roleId);
}
