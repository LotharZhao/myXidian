package com.zhao.action2;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.zhao.entity.User;

public class ListAction extends ActionSupport {
	// ��װ���ݵ�list����

	// 1����List����
	private List<User> list;

	// 2����get��set����
	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}

	public String execute() throws Exception {
		System.out.println(list);
		return NONE;
	}
}
