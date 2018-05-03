package com.zhao.model2.view;

import java.io.*;
import java.util.ArrayList;

import com.zhao.model2.domain.News;
import com.zhao.model2.service.NewsService;

public class NewsSystemFrame {

	public static void main(String[] args) throws Exception {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		System.out.println("*********欢迎登录到系统*********");
		System.out.println("请输入用户编号：");
		String userid = br.readLine();
		System.out.println("请输入密码：");
		String pwd = br.readLine();

		// 去数据库验证 略

		if ("10000".equals(userid) && "10000".equals(pwd)) {
			// 合法
			while (true) {
				System.out.println("************管理界面************");
				System.out.println("请输入你要进行的操作：");
				System.out.println("search \t 查询新闻");
				System.out.println("add \t 添加新闻");
				System.out.println("exit \t 退出系统");
				String operType = br.readLine();
				if (operType.equals("search")) {
					System.out.println("请输入关键字：");
					String keys = br.readLine();
					// 调用service完成任务
					NewsService ns = new NewsService();
					ArrayList<News> al = ns.searchNews(keys);
					for (News news : al) {
						System.out.println(news.getNewsid() + "\t"
								+ news.getNewstitle() + "\t"
								+ news.getNewsdate().toString());
					}
				} else if (operType.equals("add")) {
					System.out.println("add");
				} else if (operType.equals("exit")) {
					System.exit(0);
				} else {
					System.out.println("error");
				}
			}
		} else {
			System.out.println("error");
		}
	}
}
