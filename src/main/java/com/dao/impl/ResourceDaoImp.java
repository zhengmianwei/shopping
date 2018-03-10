package com.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.ResourceDao;
import com.mapper.ResourceMapper;
import com.model.Resource;
@Repository
public class ResourceDaoImp implements ResourceDao{
	/**
	 * 获取资源文件父节点
	 * 
	 * @param Resource
	 * @return
	 */
	@Autowired
	private ResourceMapper resourceMapper;
	
	public List<Resource> findFaterResource(Resource resource) {
		return resourceMapper.findFaterResource(resource);
	}
	
	/**
	 * 根据id获取子节点
	 */
	public List<Resource> findResourceById(Resource resource){
		return resourceMapper.findResourceById(resource);
	}
}
