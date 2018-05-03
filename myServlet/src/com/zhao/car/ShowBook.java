package com.zhao.car;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowBook extends HttpServlet {

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

		out.print("<h2>»¶Ó­¹ºÂò</h2>");

		ArrayList<Book> mydb = DB.getDB();
		
		//·ÃÎÊÒ»ÏÂsession
		request.getSession();
		
		for (Book book : mydb) {
			String url = response.encodeURL("/myServlet/BuyBookCl?id=" + book.getId());
			out.print(book.getName() + "<a href='" + url + "'>µã»÷¹ºÂò</a><br/>");
		}
	}
}
