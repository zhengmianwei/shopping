package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.ResourceService;

@Controller
@RequestMapping(value = "/app/mgr")

public class ResourceController {
	@Autowired
	private ResourceService resourceService;
	/**
	 * 跳转到资源管理页面
	 * @return
	 */
	@RequestMapping(value = "/to/resource/list") 
	public String toResourceList() {
		return "/resource";
	}
	@RequestMapping(value = "/getResourceAll", method = RequestMethod.POST, 
			produces="text/html; charset=UTF-8")
	@ResponseBody
	public String getResourceAll () {
		String json = resourceService.getTreeGrid();
		return json;
	}
}















