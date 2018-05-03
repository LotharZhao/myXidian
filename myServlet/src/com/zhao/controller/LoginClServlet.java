package com.zhao.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhao.domain.Users;
import com.zhao.service.UsersService;

public class LoginClServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		// 接收用户提交的用户id和密码
		int id = Integer.parseInt(request.getParameter("id"));
		String pwd = request.getParameter("pwd");

		// 用户是否保存id
		String val = request.getParameter("iskeepname");
		if (val != null && val.equals("keep")) {
			Cookie cookie = new Cookie("id", id + "");
			cookie.setMaxAge(7 * 24 * 3600);
			response.addCookie(cookie);
		} else {
			Cookie cookies[] = request.getCookies();
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("id")) {
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
		}
		String val2 = request.getParameter("iskeeppwd");
		if (val2 != null && val2.equals("keep")) {
			Cookie cookie = new Cookie("pwd", pwd);
			cookie.setMaxAge(7 * 24 * 3600);
			response.addCookie(cookie);
		} else {
			Cookie cookies[] = request.getCookies();
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("pwd")) {
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
		}

		// 到数据库中验证
		UsersService us = new UsersService();
		Users user = new Users();
		user.setId(id);
		user.setPwd(pwd);
		if (us.checkUser(user)) {
			// 网站计数
			String nums = (String) this.getServletContext().getAttribute("nums");
			nums = (Integer.parseInt(nums) + 1) + "";
			this.getServletContext().setAttribute("nums", nums);

			// 把user对象保存到session中
			HttpSession session = request.getSession();
			session.setAttribute("loginuser", user);

			// 跳转到下一个页面：2.sendRedirct重定向
			// 防止刷新导致计数加一
			response.sendRedirect("/myServlet/MainFrame");
			// 3.forward转发 最好使用之
			// request.getRequestDispatcher("/MainFrame").forward(request,response);
		} else {
			// 跳回
			request.setAttribute("err", "用户id或者密码有误！");
			request.getRequestDispatcher("/LoginServlet").forward(request,response);
		}
	}
}
