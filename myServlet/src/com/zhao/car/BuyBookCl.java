package com.zhao.car;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BuyBookCl extends HttpServlet {

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

		String id = request.getParameter("id");
		HttpSession session = request.getSession();

		HashMap<String, Book> hm = (HashMap<String, Book>) request.getSession().getAttribute("mybooks");
		if (hm == null) {
			hm = new LinkedHashMap<String, Book>();
			Book book = new Book();
			book.setId(id);
			book.setName(DB.getBookById(id).getName());
			book.setNum(1);
			hm.put(id, book);
			session.setAttribute("mybooks", hm);
		} else {
			if(hm.containsKey(id)){
				Book book = hm.get(id);
				int num = book.getNum();
				book.setNum(num+1);
			}else{
				Book book =new Book();
				book.setId(id);
				book.setName(DB.getBookById(id).getName());
				book.setNum(1);
				hm.put(id, book);
			}
			session.setAttribute("mybooks", hm);
		}
		request.getRequestDispatcher("/ShowMyCar").forward(request, response);
	}

}
