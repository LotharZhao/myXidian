package com.zhao.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class SqlHelper {
	// ������Ҫ�ı���
	private static Connection ct = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
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
	private static InputStream fis = null;

	// ����������ֻ��Ҫһ��
	static {
		try {
			// ��dbinfo.propertis�ļ��ж�ȡ������Ϣ
			pp = new Properties();
			// ��ʹ��java web��Ŀ��ʱ�򣬶�ȡ�ļ���Ҫ�������,Ĭ����Ŀ¼��src
			fis = SqlHelper.class.getClassLoader().getResourceAsStream(
					"com/zhao/util/db.properties");
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

	// ���ô洢����,�з���ֵ ��
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
			close(ct, ps, rs);
		}
	}

	// select����ArrayList
	public static ArrayList executeQuery2(String sql, String[] parameters) {
		try {
			ct = getConnection();
			ps = ct.prepareStatement(sql);
			if (parameters != null) {
				for (int i = 0; i < parameters.length; i++) {
					ps.setString(i + 1, parameters[i]);
				}
			}
			rs = ps.executeQuery();

			ArrayList al = new ArrayList();
			ResultSetMetaData rsmd = rs.getMetaData();
			int column = rsmd.getColumnCount();

			while (rs.next()) {
				Object[] ob = new Object[column];
				for (int i = 1; i <= column; i++) {
					ob[i - 1] = rs.getObject(i);
				}
				al.add(ob);
			}
			return al;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally {
			close(ct, ps, rs);
		}
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
			// close(ct, ps, rs);
		}
		return rs;
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
			close(ct, ps, rs);
		}
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
			close(ct, ps, rs);
		}
	}

	// �ر���Դ
	public static void close(Connection ct, Statement ps, ResultSet rs) {
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
