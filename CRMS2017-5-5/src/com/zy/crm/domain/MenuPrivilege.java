package com.zy.crm.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MenuPrivilege implements Serializable {
	
	private MenuPrivilegeID id;

	public MenuPrivilegeID getId() {
		return id;
	}

	public void setId(MenuPrivilegeID id) {
		this.id = id;
	}

}
