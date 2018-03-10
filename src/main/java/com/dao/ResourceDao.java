package com.dao;

import java.util.List;

import com.model.Resource;

public interface ResourceDao {
	/**
	 * 获取资源文件父节点
	 * 
	 * @param Resource
	 * @return
	 */
	public List<Resource> findFaterResource(Resource resource);
	
	/**
	 * 根据id获取子节点
	 */
	public List<Resource> findResourceById(Resource resource);
}
