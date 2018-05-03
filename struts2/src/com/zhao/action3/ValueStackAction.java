package com.zhao.action3;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class ValueStackAction extends ActionSupport {

	// 01定义变量
	private String name;
	// 02生成变量的get方法
	public String getName() {
		return name;
	}

	public String execute() throws Exception {
		// 1获取ActionContext类的对象
		ActionContext context = ActionContext.getContext();
		// 2调用方法得到值栈对象
		ValueStack stack = context.getValueStack();
		// 3调用方法set
		stack.set("zhao", "zhaoliangtao");
		// 4调用方法push
		stack.push("abcde");
		
		// 03在执行方法里面向变量设置值
		name = "呜啦啦啦";

		return SUCCESS;
	}
}
