package com.zhao.model2.domain;

import java.util.Date;

public class News {
	private int newsid;
	private String newstitle;
	private Date newsdate;
	private String newscontent;

	public int getNewsid() {
		return newsid;
	}

	public void setNewsid(int newsid) {
		this.newsid = newsid;
	}

	public String getNewstitle() {
		return newstitle;
	}

	public void setNewstitle(String newstitle) {
		this.newstitle = newstitle;
	}

	public Date getNewsdate() {
		return newsdate;
	}

	public void setNewsdate(Date newsdate) {
		this.newsdate = newsdate;
	}

	public String getNewscontent() {
		return newscontent;
	}

	public void setNewscontent(String newscontent) {
		this.newscontent = newscontent;
	}
}
