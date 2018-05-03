package com.zhao.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class myServlet1 extends HttpServlet {

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 一般习惯把doGet()和doPost()合二为一
		this.doPost(request, response);
	}

	int i = 0;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int j = 0;
		i++;
		j++;

		response.setContentType("text/html");
		String encoding = this.getServletConfig().getInitParameter("encoding");
		response.setCharacterEncoding(encoding);
		PrintWriter out = response.getWriter();

		out.print("对不起，该网站暂时关闭  " + new java.util.Date().toString());
		out.print("<br/>i=" + i + " j=" + j);

		Enumeration<String> names = this.getServletConfig().getInitParameterNames();
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			out.print("<br/>" + name + ":");
			out.print(this.getServletConfig().getInitParameter(name));
		}
		out.print("<br/><a href='http://localhost:8088/myServlet/myServlet2'>go to myServlet2</a>");

		request.setCharacterEncoding("utf-8");
		String u = request.getParameter("username");
		String p = request.getParameter("pwd");
		String sex = request.getParameter("sex");
		String hobbies[] = request.getParameterValues("hobby");
		String city = request.getParameter("city");
		String intro = request.getParameter("intro");
		String hidden1 = request.getParameter("hidden1");
		out.print("<br/>" + u + ":" + p);
		out.print("<br/>" + sex + "<br/>");
		if (hobbies != null) {
			for (int n = 0; n < hobbies.length; n++)
				out.print(hobbies[n] + " ");
		} else
			out.print("no hobby");
		out.print("<br/>" + city);
		out.print("<br/>" + intro);
		out.print("<br/>" + hidden1);
	}

	public void init() throws ServletException {
		System.out.println("myServlet1 init() run...");
		SendEmailThread sendEmail = new SendEmailThread();
		// sendEmail.start();// 开始定时发送邮件
	}

}
