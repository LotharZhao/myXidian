package com.zhao.action1;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAction extends ActionSupport {
	/*
	 * 1.ÿ�η���servletʱ�򣬶���ִ��service����
	 * -web.xml����servlet����·��
	 * 
	 * 2.����action��ÿ�η���actionʱ��Ĭ��ִ������execute����
	 * -����action���ʵ�·��
	 */
	public String execute() {
//		return "ok";
		System.out.println("action...");
		return NONE;
	}
}
