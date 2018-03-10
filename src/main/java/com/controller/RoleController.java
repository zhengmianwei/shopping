package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.Role;
import com.service.RoleService;
import com.vo.DatagridVO;
import com.vo.RoleVO;

@RequestMapping(value = "/app/mgr")
@Controller
public class RoleController {
	@Autowired
	private RoleService roleService;
	/**
	 * 添加角色信息
	 */
	@RequestMapping(value = "/role/add")
	@ResponseBody
	public String addRole(Role role) {
		int result = roleService.addRole(role);
		if (result > 0) {
			return "succ";
		} else {
			return "fail";
		}
	}
	
	/**
	 * 删除角色信息
	 */
	@RequestMapping(value = "/role/remove")
	@ResponseBody
	public String removeRole(String id) {
		String[] object = id.split(",");
		List<String> list = new ArrayList<String>();
		for(int i = 0; i < object.length; i++) {
			list.add(object[i]);
		}
		int result = roleService.removeRole(list);
		if (result > 0) {
			return "succ";
		} else {
			return "fail";
		}
	}
	/**
	 * 启用角色功能
	 */
	@RequestMapping(value = "/role/enable")
	@ResponseBody
	public String enableRole(String id) {
		List<String> list = new ArrayList<String>();
		String object[] = id.split(",");
		for(int i = 0; i < object.length; i ++) {
			list.add(object[i]);
		}		
		int result = roleService.enbaleRole(list);
		if (result > 0) {
			return "succ";
		} else {
			return "fail";
		}
	}
	
	/**
	 * 禁用角色功能
	 */
	@RequestMapping(value = "/role/disable")
	@ResponseBody
	public String disableRole(String id) {
		List<String> list = new ArrayList<String>();
		String object[] = id.split(",");
		for(int i = 0; i < object.length; i ++) {
			list.add(object[i]);
		}
		int result = roleService.disableRole(list);
		if (result > 0) {
			return "succ";
		} else {
			return "fail";
		}
	}
	/**
	 * 修改角色信息
	 */
	@RequestMapping(value = "/role/update") 
	@ResponseBody
	public String updateRole(Role role) {
		int result = roleService.updateRole(role);
		if (result > 0) {
			return "succ";
		} else {
			return "fail";
		}
	}
	
	/**
	 * 查询角色信息
	 */
	@RequestMapping(value = "/role/list")
	@ResponseBody
	public DatagridVO<Role> roleList(RoleVO roleVO) {
		return roleService.findRole(roleVO);
	}
	
	/**
	 * 跳转到角色查询页面
	 */
	@RequestMapping(value = "/to/role/list")
	public String toRoleList() {
		return "/role";
	}
}




















