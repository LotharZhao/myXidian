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

		// ɾ������
		sc.removeAttribute("name");

		// ����web.xml��ȫ��context-param
		String username = this.getServletContext().getInitParameter("username");
		out.print(username);
		// ����web.xml��servletContext2��init-param
		String pwd = this.getServletConfig().getInitParameter("pwd");
		out.print(pwd);

		// ��ȡȫ·��
		String path = this.getServletContext().getRealPath("/images/fly.jpg");
		out.print("<br/>" + path);

		// ��ȡweb��WEB-INFĿ¼�µ��ļ�
		InputStream is = this.getServletContext().getResourceAsStream("db.properties");
		Properties pp = new Properties();
		pp.load(is);
		out.print("<br/>" + pp.getProperty("driver"));
	}

}
