package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.model.User;
import com.service.UserService;
import com.util.ID;
import com.vo.DatagridVO;
import com.vo.UserVO;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	/**
	 * 验证用户民密码
	 */
	public int checkUser(User user) {
		return userDao.checkUser(user);
	}
	
	/**
	 * 获取用户信息
	 * 
	 * @param username
	 * @return
	 */
	public DatagridVO<User> queryUserList(UserVO userVO) {
		int total = userDao.queryUserCount(userVO); // 获取用户条数
		List<User> list = userDao.queryUserList(userVO); // 获取用户信息
		DatagridVO<User> datagridVO = new DatagridVO<User>();
		datagridVO.setRows(list);
		datagridVO.setTotal(total);
		return datagridVO;
	}
	
	/**
	 * 添加用户信息
	 * 
	 * @param username 
	 * 		用户名
	 * @param passwork
	 * 		密码
	 * @param enbale
	 * 		是否可用
	 */
	public int saveUser(User user) {
		user.setId(ID.get()); // 保存userid
		user.setEnbale("0");
		return userDao.saveUser(user);
	}
	/**
	 * 启用用户操作功能
	 * 
	 * @param id 主键id
	 * 
	 * @param enable 是否可用
	 */
	public int enableUser(User user) {
		user.setEnbale("1"); // 启用
		return userDao.updateUserStatus(user);
	}
	
	/**
	 * 关闭用户操作功能
	 * 
	 * @param id 
	 * 		主键id
	 * @param enable 
	 * 		是否可用
	 */
	public int closeUser(User user) {
		user.setEnbale("0"); //关闭
		return userDao.updateUserStatus(user);
	}
	
	/**
	 * 修改用户信息
	 * 
	 * @param user
	 * @return	
	 */
	public int updateUser(User user) {
		int result = userDao.updateUser(user);
		return result;
	}
	
	/**
	 * 删除用户信息
	 * 
	 * @param user
	 * @return
	 */
	public int deleteUser(List<String> list) {
		int result = userDao.deleteUser(list);
		return result;
	}
	
	/**
	 * 根据用户名获取用户对象
	 * 
	 * @param userName
	 * @return
	 */
	public User getUserByUserName(String userName) {
		return userDao.getUserByUserName(userName);
	}
	
	/**
	 * 修改用户密码
	 * 
	 * @param user
	 * @return
	 */
	public String modifyPassword(UserVO userVO) {
		User user = new User();
		user.setUsername(userVO.getUsername());
		user.setPassword(userVO.getOldpwd());
		// 根据用户和密码获取用户信息
		int userCount = userDao.checkUser(user);
		if(userCount > 0) {
			user.setPassword(userVO.getNewpwd());
			int result = userDao.modifyPassword(user);
			if(result > 0) {
				return "succ";
			}else {
				return "fail";
			}
		}else {
			return "check";
		}
	}
}
