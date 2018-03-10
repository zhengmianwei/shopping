package com.captcha;

import org.apache.shiro.authc.UsernamePasswordToken;

import com.model.User;



/**
 * @author leslie.chen @version1.0
 */
public class CaptchaUsernamePasswordToken extends UsernamePasswordToken {

	private static final long serialVersionUID = 1L;
	private boolean captchaValid;

	public CaptchaUsernamePasswordToken() {
		super();
	}

	public CaptchaUsernamePasswordToken(String username, char[] password, boolean rememberMe, String host,
			boolean captchaValid, User user) {
		super(username, password, rememberMe, host);
		this.setCaptchaValid(captchaValid);
		this.setUser(user);

	}

	public void setCaptchaValid(boolean captchaValid) {
		this.captchaValid = captchaValid;
	}

	public boolean isCaptchaValid() {
		return captchaValid;
	}

	private User user;
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
