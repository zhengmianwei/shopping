package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ResourceDao;
import com.model.Resource;
import com.service.ResourceService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@Service
public class ResourceServiceImpl implements ResourceService{
	@Autowired
	private ResourceDao resourceDao;
	/**
	 * 获取树网格数据
	 * 
	 * @param Resource
	 * @return
	 */
	public String getTreeGrid() {
		Resource resource = new Resource();
		JSONArray jsonArray = new JSONArray();
		List<Resource> fatherResource = resourceDao.findFaterResource(resource);
		for(Resource object : fatherResource) {
			List<Resource> seedList = resourceDao.findResourceById(object);
			JSONArray childArray = new JSONArray();
			for(Resource seed : seedList) {
				JSONObject seedObject = JSONObject.fromObject(seed);
				childArray.add(seedObject);
			}
			JSONObject currentObject = JSONObject.fromObject(object);
			currentObject.put("children", childArray);
			jsonArray.add(currentObject);
		}
		return jsonArray.toString();
	}
}
