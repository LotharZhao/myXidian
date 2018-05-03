//继承HttpServlet开发
package com.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ExtHttpServlet extends HttpServlet{
	//在HttpServlet中，对post提交和get提交分别处理
	//doGet()和doPost()最终也是调用了service方法
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)
		throws ServletException,java.io.IOException{
		resp.getWriter().println("run...doGet()");
	}
	protected void doPost(HttpServletRequest req,HttpServletResponse resp)
		throws ServletException,java.io.IOException{
		resp.getWriter().println("run...doPost()");
	}
}