//servlet三种开发方式之一：实现Servlet接口
package com.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

class ImpServlet implements Servlet{
	//初始化servlet,将servlet加载到内存，只能调用一次
	public void init(ServletConfig config)
		throws ServletException{
		
	}
	//得到ServletConfig对象
	public ServletConfig getServletConfig(){
		return null;
	}
	//服务函数，业务逻辑代码写在这里
	public void service(ServletRequest req,ServletResponse res)
		throws ServletException,java.io.IOException{
		System.out.println("run..."+new java.util.Date());
	}
	//得到servlet配置信息
	public java.lang.String getServletInfo(){
		return null;
	}
	//销毁该servlet，只能调用一次
	public void destroy(){

	}
}