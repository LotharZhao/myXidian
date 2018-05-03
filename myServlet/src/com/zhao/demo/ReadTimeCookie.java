package com.zhao.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadTimeCookie extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		// ��ȡ����cookie��Ϣ��Ȼ��ɸѡ
		Cookie cookies[] = request.getCookies();
		boolean b = false;// ����û��lasttime
		if (cookies != null)// ��֤��cookie
			// ����cookie
			for (Cookie cookie : cookies) {
				String name = cookie.getName();
				if ("lasttime".equals(name)) {
					out.print("���ϴε�½ʱ���ǣ�" + cookie.getValue());
					//����ʱ��
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String nowTime = sdf.format(new Date());
					cookie.setValue(nowTime);
					cookie.setMaxAge(7 * 24 * 3600);
					response.addCookie(cookie);
					
					b = true;
					break;
				}
			}
		if (!b) {
			// û���ҵ�
			out.print("���ǵ�һ�ε�½");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String nowTime = sdf.format(new Date());
			Cookie cookie = new Cookie("lasttime", nowTime);
			cookie.setMaxAge(7 * 24 * 3600);
			response.addCookie(cookie);
		}
	}
}
