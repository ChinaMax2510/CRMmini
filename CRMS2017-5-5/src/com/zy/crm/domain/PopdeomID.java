package com.zy.crm.domain;

import java.io.Serializable;

public class PopdeomID implements Serializable {
	
	/**两个主键
	 * popedomModule	varchar	30	0	0	0	0	0	0		0		gb2312	gb2312_chinese_ci		-1	0
popedomPrivilege	varchar	30	0	0	0	0	0	0		0		gb2
	 */
	
	private String popedomModule;//权限模块
	private String popedomPrivilege;//各种权限
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((popedomModule == null) ? 0 : popedomModule.hashCode());
		result = prime * result + ((popedomPrivilege == null) ? 0 : popedomPrivilege.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PopdeomID other = (PopdeomID) obj;
		if (popedomModule == null) {
			if (other.popedomModule != null)
				return false;
		} else if (!popedomModule.equals(other.popedomModule))
			return false;
		if (popedomPrivilege == null) {
			if (other.popedomPrivilege != null)
				return false;
		} else if (!popedomPrivilege.equals(other.popedomPrivilege))
			return false;
		return true;
	}
	
	public String getpopedomModule() {
		return popedomModule;
	}
	public void setpopedomModule(String popedomModule) {
		this.popedomModule = popedomModule;
	}
	public String getPopedomPrivilege() {
		return popedomPrivilege;
	}
	public void setPopedomPrivilege(String popedomPrivilege) {
		this.popedomPrivilege = popedomPrivilege;
	}

}
