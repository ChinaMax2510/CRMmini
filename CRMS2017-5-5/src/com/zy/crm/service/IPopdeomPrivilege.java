package com.zy.crm.service;

import java.util.List;

import com.zy.crm.domain.Popdeom;
import com.zy.crm.domain.PopdeomPrivilege;

public interface IPopdeomPrivilege {
	
	public List<Popdeom> updatePopdeom(String roleID , String []strings);

	public List<PopdeomPrivilege> findPopedomPrivilegeByID(String roleId);

	public List<PopdeomPrivilege> findAllpopdeomPrivilege();

	public List<PopdeomPrivilege> findAllpopdeomPrivilegeCache();

}
