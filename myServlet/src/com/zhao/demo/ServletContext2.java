package com.zhao.demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContext2 extends HttpServlet {

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

		ServletContext sc = this.getServletContext();
		String name = (String) sc.getAttribute("name");
		String name2 = (String) sc.getAttribute("name2");
		out.print(name);
		out.print(name2);

		// 删除属性
		sc.removeAttribute("name");

		// 访问web.xml的全局context-param
		String username = this.getServletContext().getInitParameter("username");
		out.print(username);
		// 访问web.xml的servletContext2的init-param
		String pwd = this.getServletConfig().getInitParameter("pwd");
		out.print(pwd);

		// 获取全路径
		String path = this.getServletContext().getRealPath("/images/fly.jpg");
		out.print("<br/>" + path);

		// 读取web或WEB-INF目录下的文件
		InputStream is = this.getServletContext().getResourceAsStream("db.properties");
		Properties pp = new Properties();
		pp.load(is);
		out.print("<br/>" + pp.getProperty("driver"));
	}

}
