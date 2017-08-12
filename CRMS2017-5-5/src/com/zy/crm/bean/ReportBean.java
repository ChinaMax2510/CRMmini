package com.zy.crm.bean;

import java.io.Serializable;

import com.zy.crm.domain.Company;

@SuppressWarnings("serial")
public class ReportBean implements Serializable {

	private String type;
	private long count;

	public ReportBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	
	public ReportBean(String type, long count) {
		super();
		this.type = type;
		this.count = count;
	}
	}