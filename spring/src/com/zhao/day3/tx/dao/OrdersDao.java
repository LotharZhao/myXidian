package com.zhao.day3.tx.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class OrdersDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/*
	 * 对数据库操作的方法，不写业务操作
	 */
	// q少钱的方法
	public void lessMoney() {
		String sql = "update account set salary=salary+? where username=?";
		jdbcTemplate.update(sql, -500, "q");
	}

	// w多钱的方法
	public void moreMoney() {
		String sql = "update account set salary=salary+? where username=?";
		jdbcTemplate.update(sql, 500, "w");
	}
}
