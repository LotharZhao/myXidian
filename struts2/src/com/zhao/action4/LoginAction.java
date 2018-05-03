package com.zhao.action4;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	public String login() {
		// �õ�request����
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// ��֤�û�������
		if ("admin".equals(username)) {
			// �ɹ�����session�����ֵ
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