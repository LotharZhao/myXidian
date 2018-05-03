package com.zhao.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.channels.SeekableByteChannel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhao.domain.Users;

public class CreateSession extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		// 访问session
		HttpSession session = request.getSession(true);
		// 给session放入属性
		session.setAttribute("username", "zhao");
		session.setAttribute("age", "100");
		// 删除某个属性
		session.removeAttribute("age");

		Users user = new Users();
		user.setId(123);
		user.setUsername("zz");
		session.setAttribute("user", user);

		// session的生命周期，默认30分钟
		session.setMaxInactiveInterval(10);// 10s指的是发呆时间

		out.print("创建session");
	}

}
