package com.dao.impl;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.UserDao;
import com.mapper.UserMapper;
import com.model.User;
import com.util.ToolUtil;
import com.vo.UserVO;
@Repository
public class UserDaoImpl implements UserDao{
	@Autowired
	private UserMapper userMapper;
	/**
	 * 验证用户民密码
	 */
	public int checkUser(User user) {
		Map<String, Long> map = userMapper.checkUser(user);
		int result = ToolUtil.objectToInteger(map.get("num"));
		return result;
	}
	
	/**
	 * 获取用户信息
	 * 
	 * @param UserVO
	 * @reutrn 
	 */
	public List<User> queryUserList(UserVO userVO) {
		List<User> list = userMapper.queryUserList(userVO);
		return list;
	}
	
	/**
	 * 获取用户信息条数
	 * 
	 * @param UserVO
	 * @return
	 */
	public int queryUserCount(UserVO userVO) {
		Map<String, BigDecimal> map = userMapper.queryUserCount(userVO);
		int total = ToolUtil.objectToInteger(map.get("total"));
		return total;
	}
	
	/**
	 * 添加用户信息
	 * 
	 * @param User
	 * @return
	 */
	public int saveUser(User user) {
		int result = userMapper.saveUser(user);
		return result;
	}
	
	/**
	 * 修改用户状态信息
	 * 
	 * @param User
	 * @return
	 */
	public int updateUserStatus(User user) {
		int result = userMapper.updateUserStatus(user);
		return result;
	}
	
	/**
	 * 修改用户信息
	 * 
	 * @param User
	 * @return
	 */
	public int updateUser(User user) {
		int result = userMapper.updateUser(user);
		return result;
	}
	
	/**
	 * 删除用户信息
	 * 
	 * @param User
	 * @return
	 */
	public int deleteUser(List<String> list) {
		int result = userMapper.deleteUser(list);
		return result;
	}
	
	/**
	 * 根据用户名获取用户对象
	 * 
	 * @param userName
	 * @return
	 */
	public User getUserByUserName(String userName) {
		return userMapper.getUserByUserName(userName);
	}
	
	/**
	 * 修改用户密码
	 * 
	 * @param user
	 * @return
	 */
	public int modifyPassword(User user) {
		return userMapper.modifyPassword(user);
	}
}
