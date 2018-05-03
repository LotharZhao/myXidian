package com.zhao.demo;

import java.sql.*;

public class Demo3 {

	public static void main(String[] args) {
		Connection ct = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// ��������
			Class.forName("com.mysql.jdbc.Driver");
			// �õ�����
			ct = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=utf-8", "root", "1234");
			// ����ps
			ps = ct.prepareStatement("select * from users");
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ps = null;
			try {
				if (ct != null) {
					ct.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ct = null;
		}
	}
}
