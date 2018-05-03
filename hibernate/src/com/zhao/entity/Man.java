package com.zhao.entity;

import java.util.HashSet;
import java.util.Set;

public class Man {

	private Integer manid;
	private String manName;
	private String manAge;

	private Set<Role> setRole = new HashSet<Role>();

	public Set<Role> getSetRole() {
		return setRole;
	}

	public void setSetRole(Set<Role> setRole) {
		this.setRole = setRole;
	}

	public Integer getManid() {
		return manid;
	}

	public void setManid(Integer manid) {
		this.manid = manid;
	}

	public String getManName() {
		return manName;
	}

	public void setManName(String manName) {
		this.manName = manName;
	}

	public String getManAge() {
		return manAge;
	}

	public void setManAge(String manAge) {
		this.manAge = manAge;
	}
}
