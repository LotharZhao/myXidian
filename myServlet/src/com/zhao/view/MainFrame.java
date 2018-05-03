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
			request.setAttribute("err", "�������û���������");
			request.getRequestDispatcher("/LoginServlet").forward(request,
					response);
			return;
		}

		out.print("<h2>��ӭ" + user.getId() + "��½</h2>");
		out.print("<a href='/myServlet/LoginServlet'>��ȫ�˳�</a><br/>");
		
		showTime(request, response, out);

		String nums = this.getServletContext().getAttribute("nums").toString();
		out.print("<br/>����ҳ��������" + nums + "��");


		out.print("<h4>��ѡ����Ҫ���еĲ�����</h4>");
		out.print("<a href='/myServlet/ManageUsers'>�����û�</a><br/>");
		out.print("<a href='/myServlet/UserClServlet?type=addUser'>����û�</a><br/>");
		out.print("<a href='/'>�����û�</a><br/>");
		out.print("<a href='/'>��ȫ�˳�</a><br/>");
	}

	private void showTime(HttpServletRequest request,
			HttpServletResponse response, PrintWriter out) {
		// ��ȡ����cookie��Ϣ��Ȼ��ɸѡ
		Cookie cookies[] = request.getCookies();
		boolean b = false;// ����û��lasttime
		if (cookies != null)// ��֤��cookie
			// ����cookie
			for (Cookie cookie : cookies) {
				String cookieName = cookie.getName();
				if ("lasttime".equals(cookieName)) {
					out.print("���ϴε�½ʱ���ǣ�" + cookie.getValue());
					// ����ʱ��
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
