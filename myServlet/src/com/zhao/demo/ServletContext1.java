package com.zhao.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContext1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		// ��ȡServletContext��������
		// 1.tͨ��thisֱ�ӻ�ȡ
		ServletContext sc = this.getServletContext();
		//2.ͨ��ServletConfig��ȡ
//		ServletContext sc2 = this.getServletConfig().getServletContext();
		
		sc.setAttribute("name", "zhao");
		sc.setAttribute("name2", "zhao2");
		
		this.getServletContext().getRequestDispatcher("/ServletContext2").forward(request, response);
	}

}
