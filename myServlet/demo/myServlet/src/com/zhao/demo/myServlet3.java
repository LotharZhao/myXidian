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

		// http://127.0.0.1:8088/myServlet/myServlet3 �øõ�ַ����
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
		out.print("�û�����<input type='text' name='username'/><br/>");
		out.print("�� �룺<input type='password' name='pwd'/><br/>");
		out.print("�� ��<input type='radio' name='sex' value='male'/>��<input type='radio' name='sex' value='female'/>Ů<br/>");
		out.print("�� �ã�<input type='checkbox' name='hobby' value='music'/>����<input type='checkbox' name='hobby' value='dance'/>�赸<input type='checkbox' name='hobby' value='read'/>����<br/>");
		out.print("���ڳ���<select name='city'><option value='beijing'>����</option><option value='xian'>����</option></select><br/>");
		out.print("�� �飺<textarea cols='20' rows='5' name='intro' value='aa'>������...</textarea><br/>");
		out.print("�ύ��Ƭ��<input type='file' name='phone'/><br/>");// ��δʵ��
		// ��ϣ���û����������� ��ϣ��Ӱ����� ͬʱ����ʹ�ø�����
		out.print("<input type='hidden' name='hidden1' value='hiddenManage'/>");
		out.print("<input type='submit' value='�ύ'/>");
		out.print("</form>");
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
