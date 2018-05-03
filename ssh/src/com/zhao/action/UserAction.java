package com.zhao.action;

import com.opensymphony.xwork2.ActionSupport;
import com.zhao.service.UserService;

public class UserAction extends ActionSupport {

	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("action...");
		userService.findByName();
		return NONE;
	}
}
