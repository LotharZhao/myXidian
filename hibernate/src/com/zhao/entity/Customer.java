package com.zhao.entity;

import java.util.HashSet;
import java.util.Set;

public class Customer {
	private Integer cid;// �ͻ�id
	private String custName;// ����
	private String custLevel;// �ȼ�
	private String custSource;// ��Դ
	private String custPhone;// ��ϵ�绰

	private Set<LinkMan> setLinkMan = new HashSet<LinkMan>();

	public Set<LinkMan> getSetLinkMan() {
		return setLinkMan;
	}

	public void setSetLinkMan(Set<LinkMan> setLinkMan) {
		this.setLinkMan = setLinkMan;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustLevel() {
		return custLevel;
	}

	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
	}

	public String getCustSource() {
		return custSource;
	}

	public void setCustSource(String custSource) {
		this.custSource = custSource;
	}

	public String getCustPhone() {
		return custPhone;
	}

	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}
}
