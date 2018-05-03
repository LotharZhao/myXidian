package com.zhao.model2.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.zhao.model2.dao.SqlHelper;
import com.zhao.model2.domain.News;

public class NewsService {
	// ��������
	/**
	 * @author zhaoliangtao
	 * @param keys�û���������йؼ���
	 * @return
	 */
	public ArrayList searchNews(String keys) {
		String keyArr[] = keys.split(" ");
		String sql = "select NEWSID,NEWSTITLE,NEWSDATE from news where";
		for (int i = 0; i < keyArr.length; i++) {
			if (i == keyArr.length - 1) {
				sql += " (newstitle like '%" + keyArr[i]
						+ "%' or newsContent like '%" + keyArr[i] + "%')";
			} else {
				sql += " (newstitle like '%" + keyArr[i]
						+ "%' or newsContent like '%" + keyArr[i] + "%') and";
			}
		}
		ArrayList<News> al = null;
		try {
			// ��ѯ
			ResultSet rs = SqlHelper.executeQuery(sql, null);
			// ��rs->ArrayList(News����)[ҵ���߼����η�װ]
			al = new ArrayList<News>();
			while (rs.next()) {
				News news = new News();
				news.setNewsid(rs.getInt(1));
				news.setNewstitle(rs.getString(2));
				news.setNewsdate(rs.getDate(3));
				al.add(news);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlHelper.close(SqlHelper.getCt(), SqlHelper.getRs(),
					SqlHelper.getPs());
		}
		return al;
	}
}
