package com.zhao.demo;

import java.sql.*;

import oracle.jdbc.driver.OracleDriver;

public class Demo1 {

	public static void main(String[] args) {
		test2();
	}

	private static void test2() {
		Connection ct = null;
		PreparedStatement ps = null;// ��ֹsqlע��
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			ct = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			ps = ct.prepareStatement("select * from user1 where id=? and pwd=?");
			ps.setInt(1, 3);
			ps.setString(2, "123");
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ct != null) {
				try {
					ct.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				ct = null;
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				ps = null;
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				rs = null;
			}
		}
	}

	private static void test1() {
		Connection ct = null;
		Statement statement = null;
		try {
			// 1.��������
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// DriverManager.registerDriver(new OracleDriver());
			// 2.�õ�����
			ct = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			// 3.����sql����Statement/PreparedStatement/CallableStatement��
			statement = ct.createStatement();
			// 4.ͨ��statement�����ݿⷢ��sqlָ��
			statement
					.executeUpdate("insert into user1 values(user1_seq.nextval,'zhao','123','zhao@163.com',sysdate,30)");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// �ر���Դ���ȿ���ϡ�
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				statement = null;
			}
			if (ct != null) {
				try {
					ct.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				ct = null;
			}
		}
	}
}
