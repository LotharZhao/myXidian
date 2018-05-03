package com.zhao.model2.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.zhao.model2.dao.SqlHelper;
import com.zhao.model2.domain.News;

public class NewsService {
	// 搜索新闻
	/**
	 * @author zhaoliangtao
	 * @param keys用户输入的所有关键字
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
			// 查询
			ResultSet rs = SqlHelper.executeQuery(sql, null);
			// 将rs->ArrayList(News对象)[业务逻辑二次封装]
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
