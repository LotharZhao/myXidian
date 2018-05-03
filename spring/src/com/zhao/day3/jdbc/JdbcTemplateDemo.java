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

	// ��ѯlist����
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
	
	// ��ѯ����
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
	
	// ��ѯĳ��ֵ
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

	// �޸ġ�ɾ������
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

	// ��Ӳ���
	@Test
	public void testAdd() {
		// 1�������ݿ���Ϣ
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///spring");
		dataSource.setUsername("root");
		dataSource.setPassword("1234");
		// 2����jdbcTemplate������������Դ
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		// 3����jdbcTemplate��������ķ���ʵ�ֲ���
		String sql = "insert into user values(?,?)";
		int rows = jdbcTemplate.update(sql, "zhao", "1234");
		System.out.println(rows);
	}
}

class MyRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int num) throws SQLException {
		//�ӽ�����õ�����
		String username = rs.getString("username");
		String password = rs.getString("password");
		//�����ݷ�װ��������
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		return user;
	}
}
