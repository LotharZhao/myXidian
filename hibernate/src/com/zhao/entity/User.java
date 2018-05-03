package com.zhao.entity;

public class User {

	private int uid;
//	private String uid;
	private String username;
	private String pwd;
	private String address;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

//	public String getUid() {
//		return uid;
//	}
//
//	public void setUid(String uid) {
//		this.uid = uid;
//	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", pwd=" + pwd
				+ ", address=" + address + "]";
	}
}
