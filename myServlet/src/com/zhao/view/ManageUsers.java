package com.zhao.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhao.domain.Users;
import com.zhao.service.UsersService;

public class ManageUsers extends HttpServlet {

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

		out.print("<script type='text/javascript' language='javascript'>");
		out.print("function gotoPageNow(){"
				+ "var pageNow=document.getElementById('pageNow');"
				+ "if(pageNow.value>=1)window.open('/myServlet/ManageUsers?pageNow='+pageNow.value,'_self');}");
		out.print("function confirmOper(){return window.confirm('ȷ��ɾ����');}");
		out.print("</script>");
		out.print("<h2>�����û�</h2>");
		out.print("<a href='/myServlet/MainFrame'>����������</a>");

		// ��ҳ
		int pageNow = 1;// ��ǰҳ
		String spageNow = request.getParameter("pageNow");
		if (spageNow != null)
			pageNow = Integer.parseInt(spageNow);
		int pageSize = 3;// ָ��ÿҳ��ʾ��Ŀ
		int pageCount = 1;// ����ҳ����ֵӦΪ����ֵ

		UsersService us = new UsersService();
		pageCount = us.getPageCount(pageSize);
		ArrayList<Users> al = us.getUsersByPage(pageNow, pageSize);

		out.print("<table border=1px width=400px>");
		out.print("<tr><th>id</th><th>�û���</th><th>email</th><th>����</th><th>�޸�</th><th>ɾ��</th></tr>");
		for (Users user : al) {
			out.print("<tr><td>" + user.getId() + "</td><td>" + user.getUsername() + "</td>"
					+ "<td>" + user.getEmail() + "</td><td>" + user.getGrade() + "</td>"
					+ "<td><a href='/myServlet/UserClServlet?type=updateUser&id=" + user.getId() + "'>�޸�</a></td>"
					+ "<td><a onclick='return confirmOper()' href='/myServlet/UserClServlet?type=del&id=" + user.getId() + "'>ɾ��</a></td></tr>");
		}
		out.print("</table>");
		// ��ʾ��ҳ
		if (pageNow > 1) {
			out.print("<a href='/myServlet/ManageUsers?pageNow="
					+ (pageNow - 1) + "'>��һҳ</a>&nbsp;");
		} else
			out.print("��һҳ&nbsp;");
		for (int i = 1; i <= pageCount; i++) {
			out.print("<a href='/myServlet/ManageUsers?pageNow=" + i + "'><"
					+ i + "></a>&nbsp;");
		}
		if (pageNow < pageCount) {
			out.print("<a href='/myServlet/ManageUsers?pageNow="
					+ (pageNow + 1) + "'>��һҳ</a>&nbsp;");
		} else
			out.print("��һҳ&nbsp;");
		out.print("&nbsp;&nbsp;��ǰҳ" + pageNow + "/��ҳ��" + pageCount + "<br/>");
		out.print("��ת����<input type='text' name='pageNow' id='pageNow'/><input type='button' onclick='gotoPageNow()' value='��ת'>");
	}

}
