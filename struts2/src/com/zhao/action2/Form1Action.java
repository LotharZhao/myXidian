package com.zhao.action2;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Form1Action extends ActionSupport {
	@Override
	public String execute() throws Exception {
		// ʹ��ActionContext���ȡ������
		// 1��ȡActionContext����
		ActionContext actionContext = ActionContext.getContext();
		// 2���÷����õ�������
		Map<String, Object> map = actionContext.getParameters();
		Set<String> keys = map.keySet();
		for (String key : keys) {
			// ����key�õ�value
			Object[] obj = (Object[]) map.get(key);
			System.out.println(key + ":" + Arrays.toString(obj));
		}
		return NONE;
	}
}
