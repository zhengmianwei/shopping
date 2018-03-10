package com.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.User;
import com.service.UserService;
@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	
	/**
	 * 用户登陆接口
	 * @param user
	 * @return
	 */

	@RequestMapping(value="/login", produces = {"application/json;charset=UTF-8"},
			method = RequestMethod.POST)
	public String login(User user, ModelMap model){
		String rootPath=getClass().getResource("/").getFile().toString(); 
		//System.out.println("rootPath--------------"+rootPath);
		String message = "";
		int num = 0;
		try{
			num = userService.checkUser(user);
		}catch(Exception e){
			e.printStackTrace();
		}
		if(num > 0){
			message = "登陆成功!";
			return "/index";
			/*message = "登陆成功!";
			return "redirect:/catalog/findCatalog.do?user.username = "+user.getUsername();*/
		}else{
			message = "用户名或密码错误!";
			return "/login";
		}
		
	}
	
	/*** 
     * 跳转到登录页面 
     *  
     * @return 
     */  
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String toLogin() {  
        // 跳转到/page/login.jsp页面  
        return "/login";  
    }  
    
    /**
     * 退出登录
     * 
     * @return
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout() {
    	return "/login";
    }
}
