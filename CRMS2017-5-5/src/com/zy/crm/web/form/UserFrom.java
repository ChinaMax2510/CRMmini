package com.zy.crm.web.form;

import java.io.Serializable;
import java.sql.Date;

import com.zy.crm.domain.Group;
import com.zy.crm.domain.Role;

public class UserFrom implements Serializable {
	
	private String id;
	private String name;
	private String cnname;
	private String password;
	private String creator; // #������
	private String createTime; // ����ʱ�� yyyy-mm-dd HH24:mm:ss
	private String updater; // �޸���
	private String updateTime; // �޽�ʱ�� yyyy-mm-dd HH24:mm:ss
	private String beginDate; // ��ʼ��Ч�� yyyy-mm-dd
	private String endDate; // ��ֹ��Ч�� yyyy-mm-dd
	private String RoleID;  // ����û���Ӧһ����ɫ(Ȩ����)
	private String GroupID;  // ����û�����һ������
	private String status; // #״̬(Y N)
	private String birthday; // ��������
	private String workDate; // ��ְ����
	private String finishSchoolDate; // ��ҵ����
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCnname() {
		return cnname;
	}
	public void setCnname(String cnname) {
		this.cnname = cnname;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdater() {
		return updater;
	}
	public void setUpdater(String updater) {
		this.updater = updater;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getRoleID() {
		return RoleID;
	}
	public void setRoleID(String roleID) {
		RoleID = roleID;
	}
	public String getGroupID() {
		return GroupID;
	}
	public void setGroupID(String groupID) {
		GroupID = groupID;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getWorkDate() {
		return workDate;
	}
	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}
	public String getFinishSchoolDate() {
		return finishSchoolDate;
	}
	public void setFinishSchoolDate(String finishSchoolDate) {
		this.finishSchoolDate = finishSchoolDate;
	}
	
}
