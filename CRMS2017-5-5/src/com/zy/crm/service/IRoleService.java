package com.zy.crm.service;

import java.io.Serializable;
import java.util.List;

import com.zy.crm.bean.RoleSearch2;
import com.zy.crm.domain.Role;

public interface IRoleService {
	
	//搜索权限
	public List<Role> findRoleAll(RoleSearch2 role);
	
	//权限下拉表
	public List<Role> findRoleAll();

	public void saveRole(Role role);
	
	public void deleteRoleByID(Serializable ... ids);

	public Role findRoleByID(String ids);

	public void updateRole(Role role);

}
