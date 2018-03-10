package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.MenuTree;
import com.model.RoleMenu;
import com.model.TreeNode;
import com.model.User;
import com.model.UserRole;
import com.service.RightLimitService;

@Controller
@RequestMapping(value="/app/mgr")
public class RightLimitController {
	@Autowired
	private RightLimitService rightLimitService;
	/**
	 * 根据用户名获取菜单模块
	 * 
	 * @param User
	 * @return
	 */
	@RequestMapping(value = "/findMenuByUser")
	@ResponseBody
	public List<MenuTree> getMenuByUser(User user) {
		List<MenuTree> list = rightLimitService.getMenuByUser(user);
		return list;
	}
	
	/**
	 * 获取用户角色权限信息
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/findUserRole")
	@ResponseBody
	public List<TreeNode> getUserRole(UserRole userRole) {
		List<TreeNode> list = rightLimitService.findUserRole(userRole);
		return list;
	}
	
	/**
	 * 绑定用户角色权限信息
	 */
	@RequestMapping(value = "/bindingUserRole")
	@ResponseBody
	public String bindingUserRole(UserRole userRole) {
		int result = rightLimitService.bindingUserRole(userRole);
		if(result > 0) {
			return "succ";
		}else {
			return "fail";
		}
	}
	/**
	 * 获取角色模块权限信息
	 * 
	 * @param roleMenu
	 * @return
	 */
	@RequestMapping(value = "/findRoleMenu")
	@ResponseBody
	public List<TreeNode> getRoleMenu(String roleId, String id) {
		RoleMenu roleMenu = new RoleMenu();
		roleMenu.setRoleId(roleId);
		roleMenu.setMenuId(id);
		return rightLimitService.getRoleMenu(roleMenu);
	}
	/**
	 * 角色绑定菜单
	 * 
	 * @param roleId 角色id
	 * @param menu 菜单id
	 * @return
	 */
	@RequestMapping(value = "/bindingMenu")
	@ResponseBody
	public String bindingMenu(RoleMenu roleMenu) {
		try{
			int result = rightLimitService.bindingMenu(roleMenu);
			if(result > 0) {
				return "succ";
			}else {
				return "fail";
			}
		}catch(Exception e) {
			e.printStackTrace();
			return "fail";
		}
		
	}
}
