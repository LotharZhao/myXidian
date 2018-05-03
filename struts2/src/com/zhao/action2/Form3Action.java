package com.zhao.action2;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class Form3Action extends ActionSupport implements ServletRequestAware {
	// 使用接口注入
	private HttpServletRequest request;

	@Override
	public String execute() throws Exception {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username + "-" + password);

		return NONE;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
}
