package com.zhao.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public final class LoginServlet extends HttpServlet {

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
		response.setCharacterEncoding("gbk");
		PrintWriter out = response.getWriter();
		// 返回一个界面（html界面）
		out.print("<h1>用户登录</h1>");
		out.print("<form action='/myServlet/LoginClServlet' method='post'>");
		out.print("用户id：<input type='text' name='id'/><br/>");
		out.print("密    码：<input type='password' name='pwd'/><br/>");
		out.print("<input type='submit' vlaue='登录'/><br/>");
		out.print("</from>");
		String errInfo = (String) request.getAttribute("err");
		out.print("<font color='red'>" + errInfo + "</font>");	
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
