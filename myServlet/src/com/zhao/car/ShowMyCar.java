package com.zhao.car;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowMyCar extends HttpServlet {

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
		
		out.print("<h2>购物车：</h2>");

		HashMap<String, Book> mybooks = (HashMap<String, Book>) request.getSession().getAttribute("mybooks");
		Iterator iterator = mybooks.keySet().iterator();
		while(iterator.hasNext()){
			String key = (String) iterator.next();
			Book book = mybooks.get(key);
			out.print(book.getName()+":"+book.getNum()+"<br/>");
		}
		
		String url = response.encodeURL("/myServlet/ShowBook");
		out.print("<br/><a href='" + url + "'>返回购物大厅</a>");
	}

}
