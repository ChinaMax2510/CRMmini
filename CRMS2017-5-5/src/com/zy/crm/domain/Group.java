package com.zy.crm.domain;

import java.io.Serializable;

public class Group implements Serializable {
//	CREATE TABLE `sys_user_group` (
//			  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '锟斤拷锟脚憋拷锟�',
//			  `remark` varchar(20) DEFAULT NULL COMMENT '锟斤拷注',
//			  `name` varchar(20) NOT NULL,
//			  `principal` varchar(20) NOT NULL COMMENT '锟斤拷锟脚革拷锟斤拷锟斤拷',
//			  `incumbent` varchar(20) NOT NULL,
//			  PRIMARY KEY (`id`)
	private Integer id;//锟斤拷锟脚憋拷锟�
	@Override
	public String toString() {
		return "Group [id=" + id + ", remark=" + remark + ", name=" + name + ", principal=" + principal + ", incumbent="
				+ incumbent + "]";
	}
	private String remark;//锟斤拷注
	private String name;//锟斤拷锟斤拷锟斤拷锟斤拷
	private String principal;//负责人
	private String incumbent;//职能
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrincipal() {
		return principal;
	}
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	public String getIncumbent() {
		return incumbent;
	}
	public void setIncumbent(String incumbent) {
		this.incumbent = incumbent;
	}
	

}
