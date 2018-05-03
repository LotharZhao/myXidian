package com.zhao.action2;

import com.opensymphony.xwork2.ActionSupport;

public class Data1Action extends ActionSupport {
	// 使用属性封装获取表单数据

	// 1定义变量
	private String username;
	private String password;
	private String address;

	// 2生成变量的set和get方法
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String execute() throws Exception {
		System.out.println(username + "-" + password);
		return NONE;
	}
}
