package com.zhao.model2.view;

import java.io.*;
import java.util.ArrayList;

import com.zhao.model2.domain.News;
import com.zhao.model2.service.NewsService;

public class NewsSystemFrame {

	public static void main(String[] args) throws Exception {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		System.out.println("*********��ӭ��¼��ϵͳ*********");
		System.out.println("�������û���ţ�");
		String userid = br.readLine();
		System.out.println("���������룺");
		String pwd = br.readLine();

		// ȥ���ݿ���֤ ��

		if ("10000".equals(userid) && "10000".equals(pwd)) {
			// �Ϸ�
			while (true) {
				System.out.println("************�������************");
				System.out.println("��������Ҫ���еĲ�����");
				System.out.println("search \t ��ѯ����");
				System.out.println("add \t �������");
				System.out.println("exit \t �˳�ϵͳ");
				String operType = br.readLine();
				if (operType.equals("search")) {
					System.out.println("������ؼ��֣�");
					String keys = br.readLine();
					// ����service�������
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
