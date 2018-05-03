package com.zhao.action2;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.zhao.entity.User;

public class ListAction extends ActionSupport {
	// 封装数据到list集合

	// 1声明List变量
	private List<User> list;

	// 2生成get和set方法
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
