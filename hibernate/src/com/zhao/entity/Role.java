package com.zhao.entity;

import java.util.HashSet;
import java.util.Set;

public class Role {

	private Integer roleid;
	private String roleName;
	private String roleMemo;// √Ë ˆ

	private Set<Man> setMan = new HashSet<Man>();

	public Set<Man> getSetMan() {
		return setMan;
	}

	public void setSetMan(Set<Man> setMan) {
		this.setMan = setMan;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleMemo() {
		return roleMemo;
	}

	public void setRoleMemo(String roleMemo) {
		this.roleMemo = roleMemo;
	}
}
