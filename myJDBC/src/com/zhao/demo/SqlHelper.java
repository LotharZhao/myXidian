package com.zhao.demo;

import java.sql.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SqlHelper {
	// ������Ҫ�ı���
	private static Connection ct = null;
	private static ResultSet rs = null;
	private static PreparedStatement ps = null;
	private static CallableStatement cs = null;

	public static Connection getCt() {
		return ct;
	}

	public static PreparedStatement getPs() {
		return ps;
	}

	public static ResultSet getRs() {
		return rs;
	}

	// �������ݿ����
	private static String url = "";
	private static String driver = "";
	private static String username = "";
	private static String password = "";

	private static Properties pp = null;
	private static FileInputStream fis = null;

	// ����������ֻ��Ҫһ��
	static {
		try {
			// ��dbinfo.propertis�ļ��ж�ȡ������Ϣ
			pp = new Properties();
			fis = new FileInputStream("dbinfo.properties");
			pp.load(fis);
			url = pp.getProperty("url");
			driver = pp.getProperty("driver");
			username = pp.getProperty("username");
			password = pp.getProperty("password");

			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			fis = null;
		}
	}

	// �õ�����
	public static Connection getConnection() {
		try {
			ct = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ct;
	}

	// ���ô洢����,�з���ֵ
	public static ResultSet callPro2(String sql, String[] parameters) {
		return null;
	}

	// ���ô洢����
	// sql:{call ����(?,?,?)}
	public static void callPro1(String sql, String[] parameters) {
		try {
			ct = getConnection();
			cs = ct.prepareCall(sql);
			if (parameters != null) {
				for (int i = 0; i < parameters.length; i++) {
					cs.setObject(i + 1, parameters[i]);
				}
			}
			cs.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally {
			close(ct, rs, cs);
		}
	}

	// ��ҳ?
	public static ResultSet executeQuery2() {
		return null;
	}

	// ͳһ��select
	public static ResultSet executeQuery(String sql, String[] parameters) {
		try {
			ct = getConnection();
			ps = ct.prepareStatement(sql);
			if (parameters != null) {
				for (int i = 0; i < parameters.length; i++) {
					ps.setString(i + 1, parameters[i]);
				}
			}
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally {
			// close(ct, rs, ps);
		}
		return rs;
	}

	// ���update/delete/insert����������
	public static void executeUpdate2(String[] sql, String[][] parameters) {
		try {
			ct = getConnection();
			ct.setAutoCommit(false);
			for (int i = 0; i < sql.length; i++) {
				if (parameters[i] != null) {
					ps = ct.prepareStatement(sql[i]);
					for (int j = 0; j < parameters[i].length; j++) {
						ps.setString(j + 1, parameters[i][j]);
					}
					ps.executeUpdate();
				}
			}
			ct.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally {
			close(ct, rs, ps);
		}
	}

	// һ��update/delete/insert
	// sql��ʽ��update ���� set �ֶ���=? where �ֶ�=?;
	// parametersӦ����("abc",123)
	public static void executeUpdate(String sql, String[] parameters) {
		try {
			// ����һ��ps
			ct = getConnection();
			ps = ct.prepareStatement(sql);
			// ��?��ֵ
			if (parameters != null) {
				for (int i = 0; i < parameters.length; i++) {
					ps.setString(i + 1, parameters[i]);
				}
			}
			// ִ��
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();// �����׶�
			// �׳������쳣,���Ը����øú����ĺ���һ���Ƿ����ѡ��
			throw new RuntimeException(e.getMessage());
		} finally {
			close(ct, rs, ps);
		}
	}

	// �ر���Դ
	public static void close(Connection ct, ResultSet rs, Statement ps) {
		if (ct != null) {
			try {
				ct.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ct = null;
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ps = null;
		}
	}

}
