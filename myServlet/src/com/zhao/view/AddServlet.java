package com.zhao.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhao.domain.Users;

public class AddServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print("<h2>����û�</h2>");
		out.print("<a href='/myServlet/MainFrame'>����</a>");

		Users user = (Users) request.getAttribute("userinfo");
		out.print("<form action='/myServlet/UserClServlet?type=add' method='post'>");
		out.print("<table border=1px>");
		out.print("<tr><td>�û���</td><td><input type='text' name='username''/></td></tr>");
		out.print("<tr><td>����</td><td><input type='text' name='pwd' value=''/></td></tr>");
		out.print("<tr><td>email</td><td><input type='text' name='email''/></td></tr>");
		out.print("<tr><td>����</td><td><input type='text' name='grade''/></td></tr>");
		out.print("<tr><td><td><input type='submit' value='�ύ�޸�'/></td><td><input type='reset' value='������д'/></td></tr>");
		out.print("</table>");
		out.print("</form>");
	}

}
