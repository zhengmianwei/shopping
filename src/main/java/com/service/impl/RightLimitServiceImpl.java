package com.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.MenuDao;
import com.dao.RightLimitDao;
import com.model.Menu;
import com.model.MenuTree;
import com.model.RoleMenu;
import com.model.TreeNode;
import com.model.User;
import com.model.UserRole;
import com.service.RightLimitService;
@Service
public class RightLimitServiceImpl implements RightLimitService{
	@Autowired
	private RightLimitDao rightLimitDao;
	@Autowired
	private MenuDao menuDao;
	/**
	 * 根据用户名获取菜单模块
	 * 
	 * @param User
	 * @return
	 */
	public List<MenuTree> getMenuByUser(User user){
		List<Menu> menus = rightLimitDao.getMenuByUser(user);
		List<Menu> parentMenus = getParentMenus(menus);
		List<MenuTree> treeJsons = new ArrayList<MenuTree>();
		if(parentMenus != null && parentMenus.size() > 0) {
			for(Menu menu : parentMenus) {
				MenuTree menuTree = menuToMenuTree(menu);
				menuTree.setChildren(this.getChildren(menu.getId(), menus));
				treeJsons.add(menuTree);
			}
		}
		return treeJsons;
	}
	private List<MenuTree> getChildren(String pid, List<Menu> menus) {
		List<MenuTree> treesJson = new ArrayList<MenuTree>();
		for(Menu menu : menus) {
			if(!menu.getPid().equals("") && menu.getPid().equals(pid)) {
				MenuTree menuTree = menuToMenuTree(menu);
				treesJson.add(menuTree);
			}
		}
		return treesJson;
	}
	private List<Menu> getParentMenus(List<Menu> menus) {
		List<Menu> parentMenu = new ArrayList<Menu>();
		for(Menu menu : menus) {
			if(menu.getPid().equals("0")) {
				parentMenu.add(menu);
			}
		}
		return parentMenu;
	}
	
	private MenuTree menuToMenuTree(Menu menu) {
		MenuTree menuTree = new MenuTree();
		menuTree.setId("" + menu.getId());
		menuTree.setName(menu.getMenuName());
		menuTree.setOpen(false);
		menuTree.setUrlpath(menu.getUrl());
		return menuTree;
	}
	
	
	/**
	 * 获取用户角色权限信息
	 * 
	 * @param username 
	 * 			用户名
	 * @return
	 */
	public List<TreeNode> findUserRole(UserRole user) {
		List<UserRole> list = rightLimitDao.getUserRole(user);
		List<TreeNode> treeNode = new ArrayList<TreeNode>();
		for(UserRole userRole : list) {
			TreeNode node = new TreeNode();
			node.setId(userRole.getRoleId());
			node.setText(userRole.getRoleName());
			if(null == userRole.getUserId()) {
				node.setChecked(false); // 没有权限则不打勾
			}else {
				node.setChecked(true); // 有权限则打勾
			}
			treeNode.add(node);
		}
		return treeNode;
	}
	/**
	 * 绑定用户角色权限
	 * 
	 * @param userId
	 * 			 用户id
	 * @param roleId
	 * 			角色id
	 * @return
	 */
	public int bindingUserRole(UserRole userRole) {
		int result = 0;
		String[] roleId = userRole.getRoleId().split(",");
		rightLimitDao.deleteUserRole(userRole.getUserId()); // 删除用户角色权限
		for(int i = 0; i < roleId.length; i++) {
			userRole.setRoleId(roleId[i]);
			result = rightLimitDao.bindingUserRole(userRole); // 绑定用户角色权限
		}
		return result;
	}
	/**
	 * 获取角色权限信息
	 * 
	 * @param roleMenu
	 * @return
	 */
	public List<TreeNode> getRoleMenu(RoleMenu roleMenu) {
		List<RoleMenu> list =  rightLimitDao.getRoleMenu(roleMenu);
		List<TreeNode> treeNode = new ArrayList<TreeNode>();
		for(RoleMenu menu : list) {
			TreeNode node = new TreeNode();
			node.setId(menu.getMenuId());
			node.setText(menu.getMenuName());
			if(null == menu.getRoleId()) {
				node.setChecked(false); // 没有的权限则不打勾
			}else {
				node.setChecked(true); // 有的权限则打勾
			}
			//判断是否是父类模块
			int result = menuDao.findMenuTotalByPid(menu.getMenuId());
			if(result > 0) {
				node.setState("closed");
			}else {
				node.setState("open");
			}
			
			treeNode.add(node);
		}
		return treeNode;
	}
	
	/**
	 * 绑定角色权限
	 * 
	 * @param RoleMenu
	 * @return
	 */
	public int bindingMenu(RoleMenu roleMenu) {
		String menuId[] = roleMenu.getMenuId().split(",");
		int result = 0;
		for(int i = 0; i < menuId.length; i++) {
			roleMenu.setMenuId(menuId[i]);
			rightLimitDao.deleteRoleMeun(roleMenu.getRoleId());
			result = rightLimitDao.bindingMenu(roleMenu);
		}
		return result;
	}
}
