package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.User;
import com.service.UserService;
import com.vo.DatagridVO;
import com.vo.UserVO;

@Controller
@RequestMapping(value="/app/mgr")
public class UserController {
	@Autowired
	private UserService userService;
	/**
	 * 删除用户信息
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/user/delete")
	@ResponseBody
	public String userRemove(String id) {
		List<String> list = new ArrayList<String>();
		String object[] = id.split(",");
		for(int i = 0; i < object.length; i ++) {
			list.add(object[i]);
		}
		int result = userService.deleteUser(list);
		if (result > 0) {
			return "succ";
		}else {
			return "fail";
		}
	}
	
	/**
	 * 修改用户信息
	 * 
	 * @param User
	 * @return
	 */
	@RequestMapping(value = "/user/update")
	@ResponseBody
	public String userUpdate(User user) {
		int result = userService.updateUser(user);
		if (result > 0) {
			return "succ";
		}else {
			return "fail";
		}
	}
	/**
	 * 保存用户信息
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/user/add")
	@ResponseBody
	public String userAdd(User user) {
		int result = userService.saveUser(user);
		if(result > 0) {
			return "succ";
		}else {
			return "fail";
		}
	}
	/**
	 * 启用用户操作功能
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/user/enable")
	@ResponseBody
	public String userEnable(User user) {
		int result = userService.enableUser(user);
		if(result > 0) {
			return "succ";
		}else {
			return "fail";
		}
	}
	
	/**
	 * 关闭用户操作功能
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/user/close", method = RequestMethod.POST)
	@ResponseBody
	public String userClose(User user) {
		int result = userService.closeUser(user);
		if(result > 0) {
			return "succ";
		}else {
			return "fail";
		}
	}
	@RequestMapping(value = "/to/user/list")
	public String toQueryUserList() {
		return "/user";
	}
	
	/**
	 * 获取用户信息
	 * 
	 * @param userVO
	 * @return
	 */
	@RequestMapping(value = "/user/list")
	@ResponseBody
	public DatagridVO<User> queryUserList(UserVO userVO) {
		return userService.queryUserList(userVO);
	}
	/**
	 * 修改用户密码
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/modify/password", method = RequestMethod.POST)
	@ResponseBody
	public String modifyPassword(UserVO user){
		return userService.modifyPassword(user);
		
	}
}
