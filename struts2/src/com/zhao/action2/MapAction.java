package com.zhao.action2;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.zhao.entity.User;

public class MapAction extends ActionSupport {
	// ��װ���ݵ�map����

	// 1����map����
	private Map<String, User> map;

	// 2����get��set����
	public Map<String, User> getMap() {
		return map;
	}

	public void setMap(Map<String, User> map) {
		this.map = map;
	}

	public String execute() throws Exception {
		System.out.println(map);
		return NONE;
	}
}
