package com.zy.crm.domain;

public class OperateeLogg {
	

	/*
	 *    CREATE TABLE `sys_operate_log` (
          `id` INT(11) NOT NULL AUTO_INCREMENT,     #���        
          `userName` VARCHAR(100) DEFAULT NULL,     #��¼�û���   admin
          `cnname` VARCHAR(100) DEFAULT NULL,       #��ʵ�û���   ϵͳ����Ա
          `actionType` VARCHAR(20) DEFAULT NULL,    #��������     ���
          `actionContent` TEXT,                    #��������     ���һ���ͻ���Ϣ(ID:8,�ͻ�����:�廪ͬ���ɷ����޹�˾,�ͻ�����:C-2010-04-0000000001)
          `actionDate` VARCHAR(30) DEFAULT NULL,      #����ʱ��     2010-04-24 17:55:11
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
