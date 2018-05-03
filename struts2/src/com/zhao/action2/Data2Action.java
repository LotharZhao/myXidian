package com.zhao.action2;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zhao.entity.User;

public class Data2Action extends ActionSupport implements ModelDriven<User> {
	//使用模型驱动的方式获取表单数据
	
	private User user = new User();
	public User getModel() {
		return user;
	}
	
	public String execute() throws Exception {
		System.out.println(user);
		return NONE;
	}
}
