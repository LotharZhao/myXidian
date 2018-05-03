package com.zhao.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor {
	// 这个方法里面写拦截器逻辑
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// 得到session里的username
		HttpServletRequest request = ServletActionContext.getRequest();
		Object obj = request.getSession().getAttribute("username");

		if (obj != null) {
			// 登录状态，放行，执行action
			return invocation.invoke();
		} else {
			// 非登录状态
			return "login";
		}
	}
}
