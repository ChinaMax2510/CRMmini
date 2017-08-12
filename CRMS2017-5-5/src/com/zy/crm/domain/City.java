package com.zy.crm.domain;

import java.io.Serializable;

public class City implements Serializable {
	
	/**
	 * id	int	11
name	varchar	100
pycode	varchar	50
pid	int	11
postcode	varchar	50
areacode	varchar	50

	 */
	private Integer  id;
	private String name;
	private String pycode;
	private Integer pid;
	
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
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getAreacode() {
		return areacode;
	}
	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}
	private String postcode;
	private String areacode;

}
