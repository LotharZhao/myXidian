package com.zhao.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor {
	// �����������д�������߼�
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// �õ�session���username
		HttpServletRequest request = ServletActionContext.getRequest();
		Object obj = request.getSession().getAttribute("username");

		if (obj != null) {
			// ��¼״̬�����У�ִ��action
			return invocation.invoke();
		} else {
			// �ǵ�¼״̬
			return "login";
		}
	}
}
