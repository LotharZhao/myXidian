package com.zhao.action4;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	public String login() {
		// 得到request对象
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// 验证用户名密码
		if ("admin".equals(username)) {
			// 成功，向session里面放值
			request.getSession().setAttribute("username", username);
			request.getSession().setAttribute("password", password);
			return "loginsuccess";
		} else {
			return "login";
		}
	}
	
	public String logout() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().removeAttribute("username");
		request.getSession().removeAttribute("password");
		return "logout";
	}
}