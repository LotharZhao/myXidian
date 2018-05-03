package com.zhao.action3;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class ContextAction extends ActionSupport {

	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("req", "abcd");
		
		return SUCCESS;
	}
}
