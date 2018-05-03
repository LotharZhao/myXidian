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
		// �ж���Դ
		if (referer == null || !referer.startsWith("http://localhost:8088/myServlet")) {
			response.sendRedirect("/myServlet/LoginServlet");
			return;
		}
		response.getWriter().println("host=" + host + " referer=" + referer);
		
		// ��5�룬ˢ�µ�/myServlet/myServlet1
		response.setHeader("Refresh", "5;url=/myServlet/myServlet1");
/*
		// ��ʾ�����ļ�
		response.setHeader("Content-Disposition", "attachment;filename=fly.jpg");
		String path = this.getServletContext().getRealPath("/images/fly.jpg");// �õ�ͼƬ��ȫ·��
		FileInputStream fis = new FileInputStream(path);
		byte buff[] = new byte[1024];// �����ֽ�����
		int len = 0;
		// response��getOutputStream()��getWriter()����ͬʱ����
		OutputStream os = response.getOutputStream();
		while ((len = fis.read(buff)) > 0) {
			os.write(buff, 0, len);
		}
		os.close();
		fis.close();
*/
		// ָ������ʱ��Ϊһ��
		response.setDateHeader("Expires", System.currentTimeMillis()+3600*1000*24);
		// ��֤������
		//response.setHeader("Cache-Control", "no-cache");
		//response.setHeader("Pragma", "no-cache");
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
