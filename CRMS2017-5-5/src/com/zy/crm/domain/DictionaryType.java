package com.zy.crm.domain;

import java.io.Serializable;

public class DictionaryType implements Serializable {
	
	/**
	 * id	int
		sort	int
		remark	text
		code	varchar
		value	varchar
		sysFlag	char

	 */
	
	private Integer id ;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Character getSysFlag() {
		return sysFlag;
	}
	public void setSysFlag(Character sysFlag) {
		this.sysFlag = sysFlag;
	}
	private Integer sort;//ÅÅÐò
	private String remark;//±¸×¢
	private String code;
	private String value;
	private Character sysFlag;

}
