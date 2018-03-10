package com.dao.impl;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.MenuDao;
import com.mapper.MenuMapper;
import com.util.ToolUtil;
@Repository
public class MenuDaoImpl implements MenuDao{
	@Autowired
	private MenuMapper menuMapper;
	/**
	 * 根据pid获取菜单信息
	 * 
	 * @param menuId
	 * @return
	 */
	public Integer findMenuTotalByPid(String menuId) {
		Map<String, BigDecimal> map = menuMapper.findMenuTotalByPid(menuId);
		int total = ToolUtil.objectToInteger(map.get("total"));
		return total;
	}
}
