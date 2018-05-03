package com.zhao.controller;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginClServlet extends HttpServlet {

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

		request.setCharacterEncoding("utf-8");
		// 接收用户提交的用户名和密码
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		// 到数据库中验证
		Connection ct = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			ct = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			ps = ct.prepareStatement("select * from users where id=? and pwd=?");
			ps.setObject(1, id);
			ps.setObject(2, pwd);
			rs = ps.executeQuery();
			if (rs.next()) {
				// 使用session来传递数据到下一个页面 1
				// request.getSession().setAttribute("id", id);
				// 跳转到下一个页面：2.sendRedirct重定向
				// response.sendRedirect("/myServlet/MainFrame?id=" + id +
				// "&pwd=" + pwd);
				// 3.forward转发 最好使用之
				request.setAttribute("id", id);
				request.getRequestDispatcher("/MainFrame").forward(request,
						response);
			} else {
				// 跳回
				request.setAttribute("err", "用户id或者密码有误！");
				request.getRequestDispatcher("/LoginServlet").forward(request,
						response);
			}
		} catch (Exception e) {
			request.setAttribute("err", "用户id或者密码有误！");
			request.getRequestDispatcher("/LoginServlet").forward(request,
					response);
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ps = null;
			try {
				if (ct != null) {
					ct.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ct = null;
		}
	}

	public void init() throws ServletException {
		// Put your code here
	}
}
