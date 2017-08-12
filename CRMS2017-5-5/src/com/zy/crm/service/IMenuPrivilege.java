package com.zy.crm.service;

import java.util.List;

public interface IMenuPrivilege {
	
	public void updateMenu(String string,String []strings);

	public List<com.zy.crm.domain.MenuPrivilege> findAllMenuPriByID(String roleID);

	public List<com.zy.crm.domain.MenuPrivilege> findAllMenuPrivilege();

	public List<com.zy.crm.domain.MenuPrivilege> findAllMenuPrivilegeCache();

}
