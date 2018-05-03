package com.zhao.action2;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Form1Action extends ActionSupport {
	@Override
	public String execute() throws Exception {
		// 使用ActionContext类获取表单数据
		// 1获取ActionContext对象
		ActionContext actionContext = ActionContext.getContext();
		// 2调用方法得到表单数据
		Map<String, Object> map = actionContext.getParameters();
		Set<String> keys = map.keySet();
		for (String key : keys) {
			// 根据key得到value
			Object[] obj = (Object[]) map.get(key);
			System.out.println(key + ":" + Arrays.toString(obj));
		}
		return NONE;
	}
}
