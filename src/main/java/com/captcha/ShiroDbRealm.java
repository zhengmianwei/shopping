package com.captcha;

import java.io.Serializable;


import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.model.User;
import com.service.UserService;

/**
 * 自实现用户与权限查询. 演示关系，密码用明文存储，因此使用默认 的SimpleCredentialsMatcher
 */
public class ShiroDbRealm extends AuthorizingRealm {

	@Autowired
	private UserService sysUserService;

	/**
	 * 认证回调函数, 登录时调用.
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
			throws AuthenticationException {

		CaptchaUsernamePasswordToken token = (CaptchaUsernamePasswordToken) authcToken;
		User user = token.getUser();

		if (user != null) {

			return new SimpleAuthenticationInfo(new ShiroUser(user.getUsername()), user.getPassword(), getName());
		}
		return null;
	}

	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		ShiroUser shiroUser = (ShiroUser) principals.fromRealm(getName()).iterator().next();

		User user = null;

		try {
			user = sysUserService.getUserByUserName(shiroUser.getLoginName());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		if (user != null) {
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			return info;
		}
		return null;
	}

	/**
	 * 更新用户授权信息缓存.
	 */
	public void clearCachedAuthorizationInfo(String principal) {

		SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());
		clearCachedAuthorizationInfo(principals);
	}

	/**
	 * 清除所有用户授权信息缓存.
	 */
	public void clearAllCachedAuthorizationInfo() {
		Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
		if (cache != null) {
			for (Object key : cache.keys()) {
				cache.remove(key);
			}
		}
	}

	/**
	 * 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息.
	 */
	public static class ShiroUser implements Serializable {

		private static final long serialVersionUID = -1748602382963711884L;
		private String username;

		public ShiroUser(String username) {
			this.username = username;
		}

		public String getLoginName() {
			return username;
		}

		/**
		 * 本函数输出将作为默认的<shiro:principal/>输出.
		 */
		@Override
		public String toString() {
			return username;
		}

	}
}
