package com.zhao.day2.anno;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Controller(value="user") //<bean id="user" class=""></bean>
@Scope(value="prototype")
public class User {

	public void add() {
		System.out.println("add...");
	}
}
