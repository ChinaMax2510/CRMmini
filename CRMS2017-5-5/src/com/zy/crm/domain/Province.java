package com.zy.crm.domain;

import java.io.Serializable;
/**
 * 省份
 * @author Administrator
 *
 */
public class Province implements Serializable {
	
	/**
	 * id	int
		name	varchar
		pycode	varchar

	 */
	
	private Integer id;
	private String name;//省份名
	private String pycode;//省份缩写
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPycode() {
		return pycode;
	}
	public void setPycode(String pycode) {
		this.pycode = pycode;
	}

}
