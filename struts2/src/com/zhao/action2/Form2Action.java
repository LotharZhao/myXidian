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
		// ʹ��ServletActionContext���ȡ��
		// 1ʹ��ServletActionContext��ȡrequest����
		HttpServletRequest request = ServletActionContext.getRequest();
		// 2����request�ķ����õ����
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		System.out.println(username + "-" + password + "-" + address);

		// ���������
		// 1request��
		request.setAttribute("req", "reqValue");
		// 2session��
		HttpSession session = request.getSession();
		session.setAttribute("sess", "sessValue");
		// 3servletContext��
		ServletContext context = ServletActionContext.getServletContext();
		context.setAttribute("contextname", "contextValue");

		return NONE;
	}
}
