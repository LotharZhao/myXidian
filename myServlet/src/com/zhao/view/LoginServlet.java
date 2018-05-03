package com.zhao.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public final class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("gbk");
		PrintWriter out = response.getWriter();

		// 从cookie中选中keep cookie
		String id = "";
		Cookie cookies[] = request.getCookies();
		if (cookies != null)
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("id")) {
					id = cookie.getValue();
				}
			}
		// 从cookie中选中keep cookie
		String pwd = "";
		if (cookies != null)
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("pwd")) {
					pwd = cookie.getValue();
				}
			}

		// 返回一个界面（html界面）
		out.print("<hr/>");
		out.print("<h1>用户登录</h1>");
		out.print("<form action='/myServlet/LoginClServlet' method='post'>");
		out.print("用户id：<input type='text' name='id' value='" + id + "'/><br/>");
		out.print("密    码：<input type='password' name='pwd' value='" + pwd + "' /><br/>");
		out.print("<input type='checkbox' checked='checked' value='keep' name='iskeepname'/>保留用户名");
		out.print("<input type='checkbox' checked='checked'  value='keep' name='iskeeppwd'/>保留密码<br/>");
		out.print("<input type='submit' value='登录'/><br/>");
		out.print("</from>");
		String errInfo = (String) request.getAttribute("err");
		if (errInfo != null)
			out.print("<font color='red'>" + errInfo + "</font>");
		out.print("<hr/><img src='G:/myCode/myServlet/WebRoot/images/fly.jpg' width=80px/>");
	}

}
