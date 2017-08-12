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
	private String creator; // #创建人
	private String createTime; // 创建时间 yyyy-mm-dd HH24:mm:ss
	private String updater; // 修改人
	private String updateTime; // 修建时间 yyyy-mm-dd HH24:mm:ss
	private String beginDate; // 起始有效期 yyyy-mm-dd
	private String endDate; // 终止有效期 yyyy-mm-dd
	private String RoleID;  // 多个用户对应一个角色(权限组)
	private String GroupID;  // 多个用户属于一个部门
	private String status; // #状态(Y N)
	private String birthday; // 出生日期
	private String workDate; // 入职日期
	private String finishSchoolDate; // 毕业日期
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
