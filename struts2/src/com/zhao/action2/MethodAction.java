package com.zhao.action2;

import com.opensymphony.xwork2.ActionSupport;

public class MethodAction extends ActionSupport {
	// ���
	public String add() {
		System.out.println("add...");
		return NONE;
	}

	public String update() {
		System.out.println("update...");
		return NONE;
	}
}
