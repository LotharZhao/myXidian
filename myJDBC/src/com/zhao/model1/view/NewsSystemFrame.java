package com.zhao.model1.view;

import java.io.*;
import java.sql.ResultSet;
import com.zhao.model1.util.SqlHelper;

public class NewsSystemFrame {
	public static void main(String[] args) throws Exception {

		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		System.out.println("*********欢迎登录到系统*********");
		System.out.println("请输入用户编号：");
		String userid = br.readLine();
		System.out.println("请输入密码：");
		String pwd = br.readLine();

		// 去数据库验证

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
					String keyArr[] = keys.split(" ");
					String sql = "select NEWSID,NEWSTITLE,NEWSDATE from news where";
					for (int i = 0; i < keyArr.length; i++) {
						if (i == keyArr.length - 1) {
							sql += " (newstitle like '%" + keyArr[i]
									+ "%' or newsContent like '%" + keyArr[i]
									+ "%')";
						} else {
							sql += " (newstitle like '%" + keyArr[i]
									+ "%' or newsContent like '%" + keyArr[i]
									+ "%') and";
						}
					}
					// 使用SqlHelper完成到数据库的查询
					try {
						ResultSet rs = SqlHelper.executeQuery(sql, null);
						while (rs.next()) {
							System.out.println(rs.getInt(1) + "\t"
									+ rs.getString(2) + "\t"
									+ rs.getDate(3).toString());
						}
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						SqlHelper.close(SqlHelper.getCt(), SqlHelper.getRs(),
								SqlHelper.getPs());
					}
					System.out.println("请输入具体要查询的新闻编号：");
					String newsId = br.readLine();
					sql = "select NEWSTITLE,NEWSCONTENT from news where newsid=?";
					String parameters[] = { newsId };
					try {
						ResultSet rs = SqlHelper.executeQuery(sql, parameters);
						while (rs.next()) {
							System.out.println(rs.getString(1) + "\t"
									+ rs.getString(2));
						}
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						SqlHelper.close(SqlHelper.getCt(), SqlHelper.getRs(),
								SqlHelper.getPs());
					}
				} else if (operType.equals("add")) {
					System.out.println("请输入新闻的标题：");
					String newsTitle = br.readLine();
					System.out.println("请输入新闻的内容：");
					String newsContent = br.readLine();
					String sql = "insert into news(newsid,newstitle,newscontent) values(news_seq.nextval,?,?)";
					String parameters[] = { newsTitle, newsContent };
					try {
						SqlHelper.executeUpdate(sql, parameters);
					} catch (Exception e) {
						System.out.println("添加失败！");
						throw new RuntimeException(e.getMessage());
					}
					System.out.println("添加成功！");
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
