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
		user1.setUsername("С��");
		user1.setPassword("qwer");
		user1.setAddress("���");
		User user2 = new User();
		user2.setUsername("С��");
		user2.setPassword("1234");
		user2.setAddress("����");

		list.add(user1);
		list.add(user2);

		return SUCCESS;
	}
}
