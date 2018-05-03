package com.zhao.action3;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class ValueStackAction extends ActionSupport {

	// 01�������
	private String name;
	// 02���ɱ�����get����
	public String getName() {
		return name;
	}

	public String execute() throws Exception {
		// 1��ȡActionContext��Ķ���
		ActionContext context = ActionContext.getContext();
		// 2���÷����õ�ֵջ����
		ValueStack stack = context.getValueStack();
		// 3���÷���set
		stack.set("zhao", "zhaoliangtao");
		// 4���÷���push
		stack.push("abcde");
		
		// 03��ִ�з����������������ֵ
		name = "��������";

		return SUCCESS;
	}
}
