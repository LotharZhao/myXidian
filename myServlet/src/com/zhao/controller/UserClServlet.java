package com.zhao.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhao.domain.Users;
import com.zhao.service.UsersService;

public class UserClServlet extends HttpServlet {

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

		String type = request.getParameter("type");
		UsersService us = new UsersService();
		if("addUser".equals(type)){
			request.getRequestDispatcher("/AddServlet").forward(request, response);
		}else if("add".equals(type)){
			String username = request.getParameter("username");
			String pwd = request.getParameter("pwd");
			String email = request.getParameter("email");
			int grade = Integer.parseInt(request.getParameter("grade"));
			Users user = new Users(0, username, pwd, email, grade);
			if (us.addUser(user)) {
				request.setAttribute("info", "添加成功！");
				request.getRequestDispatcher("/ShowServlet").forward(request, response);
			} else {
				request.setAttribute("info", "添加失败！");
				request.getRequestDispatcher("/ShowServlet").forward(request, response);
			}
		}else if("updateUser".equals(type)){
			String id = request.getParameter("id");
			Users user = us.getUserById(id);
			// 为了让下一个servlet使用我们的user对象，可以把该user放入到request对象中
			request.setAttribute("userinfo", user);
			// 请求转发
			request.getRequestDispatcher("/UpdateServlet").forward(request, response);
		}else if ("update".equals(type)) {
			int id = Integer.parseInt(request.getParameter("id"));
			String username = request.getParameter("username");
			String pwd = request.getParameter("pwd");
			String email = request.getParameter("email");
			int grade = Integer.parseInt(request.getParameter("grade"));
			Users user = new Users(id, username, pwd, email, grade);
			if (us.updateUser(user)) {
				request.setAttribute("info", "修改成功！");
				request.getRequestDispatcher("/ShowServlet").forward(request, response);
			} else {
				request.setAttribute("info", "修改失败！");
				request.getRequestDispatcher("/ShowServlet").forward(request, response);
			}
		}else if ("del".equals(type)) {
			String id = request.getParameter("id");
			if (us.delUser(id)) {
				request.setAttribute("info", "删除成功！");
				request.getRequestDispatcher("/ShowServlet").forward(request, response);
			} else {
				request.setAttribute("info", "删除失败！");
				request.getRequestDispatcher("/ShowServlet").forward(request, response);
			}
		}
	}

}
