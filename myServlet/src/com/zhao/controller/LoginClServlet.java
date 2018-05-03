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
		// �����û��ύ���û�id������
		int id = Integer.parseInt(request.getParameter("id"));
		String pwd = request.getParameter("pwd");

		// �û��Ƿ񱣴�id
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

		// �����ݿ�����֤
		UsersService us = new UsersService();
		Users user = new Users();
		user.setId(id);
		user.setPwd(pwd);
		if (us.checkUser(user)) {
			// ��վ����
			String nums = (String) this.getServletContext().getAttribute("nums");
			nums = (Integer.parseInt(nums) + 1) + "";
			this.getServletContext().setAttribute("nums", nums);

			// ��user���󱣴浽session��
			HttpSession session = request.getSession();
			session.setAttribute("loginuser", user);

			// ��ת����һ��ҳ�棺2.sendRedirct�ض���
			// ��ֹˢ�µ��¼�����һ
			response.sendRedirect("/myServlet/MainFrame");
			// 3.forwardת�� ���ʹ��֮
			// request.getRequestDispatcher("/MainFrame").forward(request,response);
		} else {
			// ����
			request.setAttribute("err", "�û�id������������");
			request.getRequestDispatcher("/LoginServlet").forward(request,response);
		}
	}
}
