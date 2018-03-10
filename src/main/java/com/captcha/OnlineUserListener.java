package com.captcha;

import java.util.HashMap;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.util.Constants;

public class OnlineUserListener implements HttpSessionListener {

	public static HashMap<String,HttpSession> sessionMap = new HashMap<String,HttpSession>();
    public void sessionCreated(HttpSessionEvent event) {
            HttpSession session = event.getSession();
            // 初始化当前session
            sessionMap.put(session.getId(), session);
    }

    public void sessionDestroyed(HttpSessionEvent event) {
            HttpSession session = event.getSession();
            // 判断当前session user是否有值
            if (session.getAttribute(Constants.LOGIN_USER_INFO) != null
                            && session.getAttribute(Constants.LOGIN_USER_INFO).toString().length() > 0) {
                    // session销毁清空map 更新map
                    sessionMap.remove(session.getAttribute(Constants.LOGIN_USER_INFO).toString());
                   // session.invalidate();
                    session.removeAttribute(Constants.LOGIN_USER_INFO);
            }
    }

}
