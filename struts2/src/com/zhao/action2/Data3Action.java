package com.zhao.action2;

import com.opensymphony.xwork2.ActionSupport;
import com.zhao.entity.User;

public class Data3Action extends ActionSupport {
	// ʹ�ñ��ʽ��װ��ȡ������
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String execute() throws Exception {
		System.out.println(user);
		return NONE;
	}
}
