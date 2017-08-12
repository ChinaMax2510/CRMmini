package com.zy.crm.domain;

public class OperateeLogg {
	

	/*
	 *    CREATE TABLE `sys_operate_log` (
          `id` INT(11) NOT NULL AUTO_INCREMENT,     #编号        
          `userName` VARCHAR(100) DEFAULT NULL,     #登录用户名   admin
          `cnname` VARCHAR(100) DEFAULT NULL,       #真实用户名   系统管理员
          `actionType` VARCHAR(20) DEFAULT NULL,    #操作类型     添加
          `actionContent` TEXT,                    #操作内容     添加一个客户信息(ID:8,客户名称:清华同方股份有限公司,客户编码:C-2010-04-0000000001)
          `actionDate` VARCHAR(30) DEFAULT NULL,      #发生时间     2010-04-24 17:55:11
      PRIMARY KEY  (`id`)
      )
	 */
	
	private Integer id;
	private String userName;
	private String cnname;
	private String actionType;
	private String actionContent;
	private String actionDate;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCnname() {
		return cnname;
	}
	public void setCnname(String cnname) {
		this.cnname = cnname;
	}
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	public String getActionContent() {
		return actionContent;
	}
	public void setActionContent(String actionContent) {
		this.actionContent = actionContent;
	}
	public String getActionDate() {
		return actionDate;
	}
	public void setActionDate(String actionDate) {
		this.actionDate = actionDate;
	}

}
