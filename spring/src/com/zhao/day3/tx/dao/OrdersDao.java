package com.zhao.day3.tx.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class OrdersDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/*
	 * �����ݿ�����ķ�������дҵ�����
	 */
	// q��Ǯ�ķ���
	public void lessMoney() {
		String sql = "update account set salary=salary+? where username=?";
		jdbcTemplate.update(sql, -500, "q");
	}

	// w��Ǯ�ķ���
	public void moreMoney() {
		String sql = "update account set salary=salary+? where username=?";
		jdbcTemplate.update(sql, 500, "w");
	}
}
