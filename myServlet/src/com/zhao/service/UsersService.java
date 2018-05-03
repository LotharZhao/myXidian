package com.zhao.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.zhao.domain.Users;
import com.zhao.util.SqlHelper;

public class UsersService {

	// ����û�
	public boolean addUser(Users user) {
		String sql = "select nextval('users_seq')";// mysql�����б����ѯ��һ��id
		ResultSet rs = SqlHelper.executeQuery(sql, null);
		int nextVal = 0;
		try {
			rs.next();
			nextVal = rs.getInt(1);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			SqlHelper.close(SqlHelper.getCt(), SqlHelper.getPs(), rs);
		}

		boolean b = true;
		String sql2 = "insert into users values(" + nextVal + ",?,?,?,?)";
		String parameters[] = { user.getUsername(), user.getPwd(),
				user.getEmail(), user.getGrade() + "" };
		try {
			SqlHelper.executeUpdate(sql2, parameters);
		} catch (Exception e) {
			b = false;
		}
		return b;
	}

	// ɾ���û�
	public boolean delUser(String id) {
		
		boolean b = true;
		String sql2 = "delete from users where id=?";
		String parameters[] = { id };
		try {
			SqlHelper.executeUpdate(sql2, parameters);
		} catch (Exception e) {
			b = false;
		}
		return b;
	}

	// �޸��û�
	public boolean updateUser(Users user) {
		boolean b = true;
		String sql = "update users set username=?,pwd=?,email=?,grade=?where id=?";
		String parameters[] = { user.getUsername(), user.getPwd(),
				user.getEmail(), user.getGrade() + "", user.getId() + "" };
		try {
			SqlHelper.executeUpdate(sql, parameters);
		} catch (Exception e) {
			b = false;
		}
		return b;
	}

	// ͨ��id��ȡ�û�����
	public Users getUserById(String id) {
		Users user = new Users();
		String sql = "select * from users where id=?";
		String parameters[] = { id };
		ResultSet rs = SqlHelper.executeQuery(sql, parameters);
		try {
			if (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPwd(rs.getString("pwd"));
				user.setEmail(rs.getString("email"));
				user.setGrade(rs.getInt("grade"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SqlHelper.close(SqlHelper.getCt(), SqlHelper.getPs(), rs);
		}
		return user;
	}

	// ��ȡpageCount
	public int getPageCount(int pageSize) {
		int rowCount = 1;// ��ʾ�����ټ�¼�������ݿ��
		String sql = "select count(*)from users";
		ResultSet rs = SqlHelper.executeQuery(sql, null);
		try {
			rs.next();
			rowCount = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlHelper.close(SqlHelper.getCt(), SqlHelper.getPs(), rs);
		}
		return (rowCount - 1) / pageSize + 1;
	}

	// ���շ�ҳ����ȡ�û�
	public ArrayList<Users> getUsersByPage(int pageNow, int pageSize) {
		ArrayList<Users> al = new ArrayList<Users>();
		// String sql =
		// "select * from(select t.*,rownum rn from(select * from users order by id) t where rownum<="
		// + pageSize * pageNow + ")where rn>=" + (pageSize * (pageNow - 1) +
		// 1); //oracle��ҳ���
		String sql = "select * from users limit " + (pageNow - 1) * pageSize + "," + pageSize;
		ArrayList al2 = SqlHelper.executeQuery2(sql, null);
		try {
			for (int i = 0; i < al2.size(); i++) {
				Object[] ob = (Object[]) al2.get(i);
				Users user = new Users();
				user.setId(Integer.parseInt(ob[0].toString()));
				user.setUsername(ob[1].toString());
				user.setPwd(ob[2].toString());
				user.setEmail(ob[3].toString());
				user.setGrade(Integer.parseInt(ob[4].toString()));
				al.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}

	// ��֤��½�û��Ƿ�Ϸ�
	public boolean checkUser(Users user) {
		boolean b = false;
		String sql = "select * from users where id=? and pwd=?";
		String parameters[] = { user.getId() + "", user.getPwd() };
		ArrayList al = SqlHelper.executeQuery2(sql, parameters);
		try {
			if (al.size() == 1) {
				b = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

}
