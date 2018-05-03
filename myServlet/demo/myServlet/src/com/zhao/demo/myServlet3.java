package com.zhao.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class myServlet3 extends HttpServlet {

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

		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		String url = request.getRequestURL().toString();
		System.out.println("url:" + url);
		String uri = request.getRequestURI();
		System.out.println("uri:" + uri);

		String queryString = request.getQueryString();
		System.out.println("QueryString:" + queryString);
		// String[] querString=queryString.split("&");
		// for(String s:querString){
		// out.print(s+" ");
		// }

		// http://127.0.0.1:8088/myServlet/myServlet3 用该地址测试
		String addr = request.getRemoteAddr();
		int port = request.getRemotePort();
		System.out.println("addr:" + addr + " port:" + port);
		String host = request.getRemoteHost();
		int serverPort = request.getLocalPort();
		System.out.println("host:" + host + " serverPort:" + serverPort);

		Enumeration<String> headers = request.getHeaderNames();
		while (headers.hasMoreElements()) {
			String headerName = headers.nextElement();
			out.println(headerName + ":" + request.getHeader(headerName) + "<br/>");
		}

		out.print("<form action='/myServlet/myServlet1' method='post'>");
		out.print("用户名：<input type='text' name='username'/><br/>");
		out.print("密 码：<input type='password' name='pwd'/><br/>");
		out.print("性 别<input type='radio' name='sex' value='male'/>男<input type='radio' name='sex' value='female'/>女<br/>");
		out.print("爱 好：<input type='checkbox' name='hobby' value='music'/>音乐<input type='checkbox' name='hobby' value='dance'/>舞蹈<input type='checkbox' name='hobby' value='read'/>读书<br/>");
		out.print("所在城市<select name='city'><option value='beijing'>北京</option><option value='xian'>西安</option></select><br/>");
		out.print("简 介：<textarea cols='20' rows='5' name='intro' value='aa'>请输入...</textarea><br/>");
		out.print("提交照片：<input type='file' name='phone'/><br/>");// 暂未实现
		// 不希望用户看到该数据 不希望影响界面 同时必须使用该数据
		out.print("<input type='hidden' name='hidden1' value='hiddenManage'/>");
		out.print("<input type='submit' value='提交'/>");
		out.print("</form>");
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
