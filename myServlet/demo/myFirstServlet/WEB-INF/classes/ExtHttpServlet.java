//�̳�HttpServlet����
package com.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ExtHttpServlet extends HttpServlet{
	//��HttpServlet�У���post�ύ��get�ύ�ֱ���
	//doGet()��doPost()����Ҳ�ǵ�����service����
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)
		throws ServletException,java.io.IOException{
		resp.getWriter().println("run...doGet()");
	}
	protected void doPost(HttpServletRequest req,HttpServletResponse resp)
		throws ServletException,java.io.IOException{
		resp.getWriter().println("run...doPost()");
	}
}