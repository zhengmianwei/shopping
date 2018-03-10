package com.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.model.User;
import com.vo.UserVO;

public interface UserDao {
	public List<User> queryUserList(UserVO userVO); // 获取用户信息
	
	public int queryUserCount(UserVO userVO); // 获取用户信息条数 
	
	public int saveUser(User user); // 添加用户信息
	
	public int updateUserStatus(User user); // 修改用户状态信息
	
	public int updateUser(User user); // 修改用户信息
	
	public int deleteUser(List<String> list); // 删除用户信息
	
	public int checkUser(User user);   //验证用户民密码
	
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
	public int modifyPassword(User user);
}
