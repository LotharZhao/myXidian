package com.zhao.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class InitServlet extends HttpServlet {

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log

		// 把ServletContext写入到文件
		String nums = (String) this.getServletContext().getAttribute("nums");
		String filePath = this.getServletContext().getRealPath("record.txt");
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(filePath);
			bw = new BufferedWriter(fw);
			bw.write(nums);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void init() throws ServletException {
		// 从record.txt文件中读取浏览量
		String filePath = this.getServletContext().getRealPath("record.txt");
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(filePath);
			br = new BufferedReader(fr);
			String nums = br.readLine();
			this.getServletContext().setAttribute("nums", nums);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
