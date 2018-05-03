package com.zhao.domain;

public class Users {
	private int id;
	private String username;
	private String pwd;
	private String email;
	private int grade;

	public Users() {
		
	}
	
	public Users(int id, String username, String pwd, String email, int grade) {
		super();
		this.id = id;
		this.username = username;
		this.pwd = pwd;
		this.email = email;
		this.grade = grade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
}
