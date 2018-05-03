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
		out.print("function confirmOper(){return window.confirm('确定删除？');}");
		out.print("</script>");
		out.print("<h2>管理用户</h2>");
		out.print("<a href='/myServlet/MainFrame'>返回主界面</a>");

		// 分页
		int pageNow = 1;// 当前页
		String spageNow = request.getParameter("pageNow");
		if (spageNow != null)
			pageNow = Integer.parseInt(spageNow);
		int pageSize = 3;// 指定每页显示数目
		int pageCount = 1;// 多少页，该值应为计算值

		UsersService us = new UsersService();
		pageCount = us.getPageCount(pageSize);
		ArrayList<Users> al = us.getUsersByPage(pageNow, pageSize);

		out.print("<table border=1px width=400px>");
		out.print("<tr><th>id</th><th>用户名</th><th>email</th><th>级别</th><th>修改</th><th>删除</th></tr>");
		for (Users user : al) {
			out.print("<tr><td>" + user.getId() + "</td><td>" + user.getUsername() + "</td>"
					+ "<td>" + user.getEmail() + "</td><td>" + user.getGrade() + "</td>"
					+ "<td><a href='/myServlet/UserClServlet?type=updateUser&id=" + user.getId() + "'>修改</a></td>"
					+ "<td><a onclick='return confirmOper()' href='/myServlet/UserClServlet?type=del&id=" + user.getId() + "'>删除</a></td></tr>");
		}
		out.print("</table>");
		// 显示分页
		if (pageNow > 1) {
			out.print("<a href='/myServlet/ManageUsers?pageNow="
					+ (pageNow - 1) + "'>上一页</a>&nbsp;");
		} else
			out.print("上一页&nbsp;");
		for (int i = 1; i <= pageCount; i++) {
			out.print("<a href='/myServlet/ManageUsers?pageNow=" + i + "'><"
					+ i + "></a>&nbsp;");
		}
		if (pageNow < pageCount) {
			out.print("<a href='/myServlet/ManageUsers?pageNow="
					+ (pageNow + 1) + "'>下一页</a>&nbsp;");
		} else
			out.print("下一页&nbsp;");
		out.print("&nbsp;&nbsp;当前页" + pageNow + "/总页数" + pageCount + "<br/>");
		out.print("跳转到：<input type='text' name='pageNow' id='pageNow'/><input type='button' onclick='gotoPageNow()' value='跳转'>");
	}

}
