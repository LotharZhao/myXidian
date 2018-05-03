package com.zhao.demo;

import java.sql.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SqlHelper {
	// 定义需要的变量
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

	// 连接数据库参数
	private static String url = "";
	private static String driver = "";
	private static String username = "";
	private static String password = "";

	private static Properties pp = null;
	private static FileInputStream fis = null;

	// 加载驱动，只需要一次
	static {
		try {
			// 从dbinfo.propertis文件中读取配置信息
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

	// 得到连接
	public static Connection getConnection() {
		try {
			ct = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ct;
	}

	// 调用存储过程,有返回值
	public static ResultSet callPro2(String sql, String[] parameters) {
		return null;
	}

	// 调用存储过程
	// sql:{call 过程(?,?,?)}
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

	// 分页?
	public static ResultSet executeQuery2() {
		return null;
	}

	// 统一的select
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

	// 多个update/delete/insert（考虑事务）
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

	// 一个update/delete/insert
	// sql格式：update 表名 set 字段名=? where 字段=?;
	// parameters应该是("abc",123)
	public static void executeUpdate(String sql, String[] parameters) {
		try {
			// 创建一个ps
			ct = getConnection();
			ps = ct.prepareStatement(sql);
			// 给?赋值
			if (parameters != null) {
				for (int i = 0; i < parameters.length; i++) {
					ps.setString(i + 1, parameters[i]);
				}
			}
			// 执行
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();// 开发阶段
			// 抛出运行异常,可以给调用该函数的函数一个是否处理的选择
			throw new RuntimeException(e.getMessage());
		} finally {
			close(ct, rs, ps);
		}
	}

	// 关闭资源
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
