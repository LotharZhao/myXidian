package com.zhao.action3;

import com.opensymphony.xwork2.ActionSupport;
import com.zhao.entity.User;

public class ObjectValueStackAction extends ActionSupport {

	private User user;

	public User getUser() {
		return user;
	}

	public String execute() throws Exception {
		user = new User();
		user.setUsername("sam");
		user.setPassword("qwer");
		user.setAddress("USA");

		return SUCCESS;
	}
}
