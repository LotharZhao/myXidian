package com.zhao.action3;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.zhao.entity.User;

public class ListValueStackAction extends ActionSupport {

	private List<User> list;

	public List<User> getList() {
		return list;
	}

	public String execute() throws Exception {
		list = new ArrayList<User>();

		User user1 = new User();
		user1.setUsername("小明");
		user1.setPassword("qwer");
		user1.setAddress("天津");
		User user2 = new User();
		user2.setUsername("小红");
		user2.setPassword("1234");
		user2.setAddress("重庆");

		list.add(user1);
		list.add(user2);

		return SUCCESS;
	}
}
