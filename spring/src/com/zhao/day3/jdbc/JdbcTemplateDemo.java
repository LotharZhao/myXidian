package com.zhao.day3.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcTemplateDemo {

	// 查询list集合
	@Test
	public void testSelect3() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///spring");
		dataSource.setUsername("root");
		dataSource.setPassword("1234");
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		String sql = "select * from user";
		List<User> list = jdbcTemplate.query(sql, new MyRowMapper());
		System.out.println(list);
	}
	
	// 查询对象
	@Test
	public void testSelect2() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///spring");
		dataSource.setUsername("root");
		dataSource.setPassword("1234");

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String sql = "select * from user where username=?";
		User user = jdbcTemplate.queryForObject(sql, new MyRowMapper(), "zhao");
		System.out.println(user);
	}
	
	// 查询某个值
	@Test
	public void testSelect1() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///spring");
		dataSource.setUsername("root");
		dataSource.setPassword("1234");

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String sql = "select count(*) from user";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);
		System.out.println(count);
	}

	// 修改、删除操作
	@Test
	public void testUpdate() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///spring");
		dataSource.setUsername("root");
		dataSource.setPassword("1234");

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

//		String sql = "update user set password=? where username=?";
//		int rows = jdbcTemplate.update(sql, "4321", "zhao");
		String sql = "delete from user where username=?";
		int rows = jdbcTemplate.update(sql, "zhao");
		System.out.println(rows);
	}

	// 添加操作
	@Test
	public void testAdd() {
		// 1设置数据库信息
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///spring");
		dataSource.setUsername("root");
		dataSource.setPassword("1234");
		// 2创建jdbcTemplate对象，设置数据源
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		// 3调用jdbcTemplate对象里面的方法实现操作
		String sql = "insert into user values(?,?)";
		int rows = jdbcTemplate.update(sql, "zhao", "1234");
		System.out.println(rows);
	}
}

class MyRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int num) throws SQLException {
		//从结果集得到数据
		String username = rs.getString("username");
		String password = rs.getString("password");
		//把数据封装到对象中
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		return user;
	}
}
