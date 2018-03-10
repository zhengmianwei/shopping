package com.service;

import java.util.List;

import com.model.User;
import com.vo.DatagridVO;
import com.vo.UserVO;

public interface UserService {
	public DatagridVO<User> queryUserList(UserVO userVO); // 获取用户信息
	
	public int saveUser(User user); // 添加用户信息
	
	public int enableUser(User user); // 启用用户操作功能
	
	public int closeUser(User user); // 关闭用户操作功能
	
	public int updateUser(User user); //修改用户信息
	
	public int deleteUser(List<String> list); // 删除用户信息
	
	/**
	 * 验证用户民密码
	 */
	public int checkUser(User user);
	
	/**
	 * 根据用户名获取用户对象
	 * 
	 * @param userName
	 * @return
	 */
	public User getUserByUserName(String userName);
	
	/**
	 * 修改用户密码
	 * 
	 * @param user
	 * @return
	 */
	public String modifyPassword(UserVO user);
}
