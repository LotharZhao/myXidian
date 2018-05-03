package com.zhao.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhao.domain.Users;

public class MainFrame extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		Users user = (Users) request.getSession().getAttribute("loginuser");
		if (user == null) {
			request.setAttribute("err", "请输入用户名、密码");
			request.getRequestDispatcher("/LoginServlet").forward(request,
					response);
			return;
		}

		out.print("<h2>欢迎" + user.getId() + "登陆</h2>");
		out.print("<a href='/myServlet/LoginServlet'>安全退出</a><br/>");
		
		showTime(request, response, out);

		String nums = this.getServletContext().getAttribute("nums").toString();
		out.print("<br/>该网页被访问了" + nums + "次");


		out.print("<h4>请选择您要进行的操作：</h4>");
		out.print("<a href='/myServlet/ManageUsers'>管理用户</a><br/>");
		out.print("<a href='/myServlet/UserClServlet?type=addUser'>添加用户</a><br/>");
		out.print("<a href='/'>查找用户</a><br/>");
		out.print("<a href='/'>安全退出</a><br/>");
	}

	private void showTime(HttpServletRequest request,
			HttpServletResponse response, PrintWriter out) {
		// 读取所有cookie信息，然后筛选
		Cookie cookies[] = request.getCookies();
		boolean b = false;// 假设没有lasttime
		if (cookies != null)// 保证有cookie
			// 遍历cookie
			for (Cookie cookie : cookies) {
				String cookieName = cookie.getName();
				if ("lasttime".equals(cookieName)) {
					out.print("您上次登陆时间是：" + cookie.getValue());
					// 更新时间
					SimpleDateFormat sdf = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss");
					String nowTime = sdf.format(new Date());
					cookie.setValue(nowTime);
					cookie.setMaxAge(7 * 24 * 3600);
					response.addCookie(cookie);

					b = true;
					break;
				}
			}
		if (!b) {
			// 没有找到
			out.print("您是第一次登陆");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String nowTime = sdf.format(new Date());
			Cookie cookie = new Cookie("lasttime", nowTime);
			cookie.setMaxAge(7 * 24 * 3600);
			response.addCookie(cookie);
		}
	}

}
