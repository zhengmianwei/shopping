package com.service;

import java.util.List;

import com.model.MenuTree;
import com.model.RoleMenu;
import com.model.TreeNode;
import com.model.User;
import com.model.UserRole;

public interface RightLimitService {
	/**
	 * 根据用户名获取菜单模块
	 * 
	 * @param User
	 * @return
	 */
	public List<MenuTree> getMenuByUser(User user);
	
	/**
	 * 获取角色权限信息
	 * 
	 * @param roleMenu
	 * @return
	 */
	public List<TreeNode> getRoleMenu(RoleMenu roleMenu);
	/**
	 * 绑定角色权限
	 * 
	 * @param RoleMenu
	 * @return
	 */
	public int bindingMenu(RoleMenu roleMenu);
	
	/**
	 * 绑定用户角色权限
	 * 
	 * @param userId
	 * 			 用户id
	 * @param roleId
	 * 			角色id
	 * @return
	 */
	public int bindingUserRole(UserRole userRole);
	
	/**
	 * 获取用户角色权限信息
	 * 
	 * @param username 
	 * 			用户名
	 * @return
	 */
	public List<TreeNode> findUserRole(UserRole userRole);
}
