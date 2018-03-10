package com.captcha;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;

import com.model.User;
import com.service.UserService;
import com.util.Constants;
/**
 * apache shiro 登录过滤器
 * 
 * @author leslie.chen @version1.0
 */
public class CaptchaFormAuthenticationFilter extends FormAuthenticationFilter {

	@Autowired
	private UserService userService;

	protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
		// 获得登录用户名和密码
		String username = getUsername(request);
		String password = getPassword(request);
		String host = getHost(request);
		// 登录时，检查到登录的Session没有被清空时，则执行等出操作
		if (SecurityUtils.getSubject().getSession() != null) {
			SecurityUtils.getSubject().logout();
		}
		User user = null;
		try {
			user = userService.getUserByUserName(username);
			return new CaptchaUsernamePasswordToken(username, password != null ? password.toCharArray() : null, false,
					host, false, user);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
			ServletResponse response) throws Exception {

		CaptchaUsernamePasswordToken ptoken = (CaptchaUsernamePasswordToken) token;

		User user = ptoken.getUser(); // 在token里获得用户信息
		// 将当前用户信息保存在session里
		// ----------------------------
		HttpSession session = ((HttpServletRequest) request).getSession(true);
		session.setAttribute(Constants.LOGIN_USER_INFO, user);
		String username = user.getUsername().trim();
		if (OnlineUserListener.sessionMap.get(username) != null
				&& OnlineUserListener.sessionMap.get(username).toString().length() > 0) {
			// 当前用户已经在线 删除用户
			HttpSession sessionold = (HttpSession) OnlineUserListener.sessionMap.get(username);
			// 注销已在线用户session
			try {
				sessionold.invalidate();
			} catch (Exception e) {

			}
			// sessionold.removeAttribute(SystemUserConstant.LOGIN_USER_INFO);
			OnlineUserListener.sessionMap.remove(username);
			// 清除已在线用户，更新map key 当前用户 value session对象
			OnlineUserListener.sessionMap.put(username, session);
			OnlineUserListener.sessionMap.remove(session.getId());
		} else {
			// 根据当前sessionid 取session对象。 更新map key=用户名 value=session对象 删除map
			// key= sessionid
			OnlineUserListener.sessionMap.get(session.getId());
			OnlineUserListener.sessionMap.put(username, OnlineUserListener.sessionMap.get(session.getId()));
			OnlineUserListener.sessionMap.remove(session.getId());
		}
		return super.onLoginSuccess(token, subject, request, response);
	}

	@Override
	protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request,
			ServletResponse response) {
		return super.onLoginFailure(token, e, request, response);
	}
}
