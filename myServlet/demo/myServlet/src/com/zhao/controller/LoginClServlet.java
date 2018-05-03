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
		// �����û��ύ���û���������
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		// �����ݿ�����֤
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
				// ʹ��session���������ݵ���һ��ҳ�� 1
				// request.getSession().setAttribute("id", id);
				// ��ת����һ��ҳ�棺2.sendRedirct�ض���
				// response.sendRedirect("/myServlet/MainFrame?id=" + id +
				// "&pwd=" + pwd);
				// 3.forwardת�� ���ʹ��֮
				request.setAttribute("id", id);
				request.getRequestDispatcher("/MainFrame").forward(request,
						response);
			} else {
				// ����
				request.setAttribute("err", "�û�id������������");
				request.getRequestDispatcher("/LoginServlet").forward(request,
						response);
			}
		} catch (Exception e) {
			request.setAttribute("err", "�û�id������������");
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
