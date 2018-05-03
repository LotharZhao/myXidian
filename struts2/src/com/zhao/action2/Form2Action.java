package com.zhao.action2;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Form2Action extends ActionSupport {
	@Override
	public String execute() throws Exception {
		// 使用ServletActionContext类获取表单
		// 1使用ServletActionContext获取request对象
		HttpServletRequest request = ServletActionContext.getRequest();
		// 2调用request的方法得到结果
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		System.out.println(username + "-" + password + "-" + address);

		// 操作域对象
		// 1request域
		request.setAttribute("req", "reqValue");
		// 2session域
		HttpSession session = request.getSession();
		session.setAttribute("sess", "sessValue");
		// 3servletContext域
		ServletContext context = ServletActionContext.getServletContext();
		context.setAttribute("contextname", "contextValue");

		return NONE;
	}
}
