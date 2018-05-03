package com.zhao.model1.view;

import java.io.*;
import java.sql.ResultSet;
import com.zhao.model1.util.SqlHelper;

public class NewsSystemFrame {
	public static void main(String[] args) throws Exception {

		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		System.out.println("*********��ӭ��¼��ϵͳ*********");
		System.out.println("�������û���ţ�");
		String userid = br.readLine();
		System.out.println("���������룺");
		String pwd = br.readLine();

		// ȥ���ݿ���֤

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
					// ʹ��SqlHelper��ɵ����ݿ�Ĳ�ѯ
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
					System.out.println("���������Ҫ��ѯ�����ű�ţ�");
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
					System.out.println("���������ŵı��⣺");
					String newsTitle = br.readLine();
					System.out.println("���������ŵ����ݣ�");
					String newsContent = br.readLine();
					String sql = "insert into news(newsid,newstitle,newscontent) values(news_seq.nextval,?,?)";
					String parameters[] = { newsTitle, newsContent };
					try {
						SqlHelper.executeUpdate(sql, parameters);
					} catch (Exception e) {
						System.out.println("���ʧ�ܣ�");
						throw new RuntimeException(e.getMessage());
					}
					System.out.println("��ӳɹ���");
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
