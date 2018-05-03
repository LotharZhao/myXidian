package com.zhao.demo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class Demo2 {
	// 测试SqlHelper工具类是否正常使用
	@Test
	public void testSqlHelper() {
		String sql = "insert into user1 values(user1_seq.nextval,?,?,?,sysDate,?)";
		String parameters[] = { "小明", "111", "xiao@1.com", "20" };
		SqlHelper.executeUpdate(sql, parameters);
	}

	@Test
	public void testSqlHelper2() {
		String sql1 = "update user1 set name=? where id=?";
		String sql2 = null;
		String sql[] = { sql1, sql2 };
		String parameters1[] = { "aaa", "8" };
		String parameters2[] = null;
		String parameters[][] = { parameters1, parameters2 };
		SqlHelper.executeUpdate2(sql, parameters);
	}

	@Test
	public void testSqlHelper3() {
		String sql = "select * from user1";
		try {
			ResultSet rs = SqlHelper.executeQuery(sql, null);
			while (rs.next()) {
				System.out.println(rs.getString("id") + rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlHelper.close(SqlHelper.getCt(), SqlHelper.getRs(),
					SqlHelper.getPs());
		}
	}

	@Test
	public void testSqlHelper4() {
		String sql = "{call pro1(?,?)}";
		String parameters[] = { "77", "sql" };
		SqlHelper.callPro1(sql, parameters);
	}
}
