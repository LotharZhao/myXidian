//servlet���ֿ�����ʽ֮һ��ʵ��Servlet�ӿ�
package com.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

class ImpServlet implements Servlet{
	//��ʼ��servlet,��servlet���ص��ڴ棬ֻ�ܵ���һ��
	public void init(ServletConfig config)
		throws ServletException{
		
	}
	//�õ�ServletConfig����
	public ServletConfig getServletConfig(){
		return null;
	}
	//��������ҵ���߼�����д������
	public void service(ServletRequest req,ServletResponse res)
		throws ServletException,java.io.IOException{
		System.out.println("run..."+new java.util.Date());
	}
	//�õ�servlet������Ϣ
	public java.lang.String getServletInfo(){
		return null;
	}
	//���ٸ�servlet��ֻ�ܵ���һ��
	public void destroy(){

	}
}