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

		// ����session
		HttpSession session = request.getSession(true);
		// ��session��������
		session.setAttribute("username", "zhao");
		session.setAttribute("age", "100");
		// ɾ��ĳ������
		session.removeAttribute("age");

		Users user = new Users();
		user.setId(123);
		user.setUsername("zz");
		session.setAttribute("user", user);

		// session���������ڣ�Ĭ��30����
		session.setMaxInactiveInterval(10);// 10sָ���Ƿ���ʱ��

		out.print("����session");
	}

}
