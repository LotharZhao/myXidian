package com.zhao.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class myServlet2 extends HttpServlet {

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

		String host = request.getHeader("Host");
		String referer = request.getHeader("Referer");
		// 判断来源
		if (referer == null || !referer.startsWith("http://localhost:8088/myServlet")) {
			response.sendRedirect("/myServlet/LoginServlet");
			return;
		}
		response.getWriter().println("host=" + host + " referer=" + referer);
		
		// 过5秒，刷新到/myServlet/myServlet1
		response.setHeader("Refresh", "5;url=/myServlet/myServlet1");
/*
		// 演示下载文件
		response.setHeader("Content-Disposition", "attachment;filename=fly.jpg");
		String path = this.getServletContext().getRealPath("/images/fly.jpg");// 得到图片的全路径
		FileInputStream fis = new FileInputStream(path);
		byte buff[] = new byte[1024];// 缓存字节数组
		int len = 0;
		// response的getOutputStream()和getWriter()不能同时出现
		OutputStream os = response.getOutputStream();
		while ((len = fis.read(buff)) > 0) {
			os.write(buff, 0, len);
		}
		os.close();
		fis.close();
*/
		// 指定缓存时间为一天
		response.setDateHeader("Expires", System.currentTimeMillis()+3600*1000*24);
		// 保证兼容性
		//response.setHeader("Cache-Control", "no-cache");
		//response.setHeader("Pragma", "no-cache");
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
