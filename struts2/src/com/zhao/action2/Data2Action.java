package com.zhao.action2;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zhao.entity.User;

public class Data2Action extends ActionSupport implements ModelDriven<User> {
	//ʹ��ģ�������ķ�ʽ��ȡ������
	
	private User user = new User();
	public User getModel() {
		return user;
	}
	
	public String execute() throws Exception {
		System.out.println(user);
		return NONE;
	}
}
