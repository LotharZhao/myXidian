package com.zhao.action1;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAction extends ActionSupport {
	/*
	 * 1.每次访问servlet时候，都会执行service方法
	 * -web.xml配置servlet访问路径
	 * 
	 * 2.访问action，每次访问action时候，默认执行名称execute方法
	 * -配置action访问的路径
	 */
	public String execute() {
//		return "ok";
		System.out.println("action...");
		return NONE;
	}
}
