package com.zhao.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainFrame extends HttpServlet {

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		// String username = request.getParameter("uname");
		// String pwd = request.getParameter("pwd");
		// String username = (String)
		// request.getSession().getAttribute("loginuser");
		String id = (String) request.getAttribute("id");

		// out.print("<h1>主页面</h1>" + username + "+" + pwd+"+"+loginuser);
		out.print("<h1>主页面</h1>" + id);
		out.print("<a href='/myServlet/LoginServlet'>返回登录界面</a>");
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
