package com.zy.crm.service;

import java.io.Serializable;
import java.util.List;

import com.zy.crm.bean.RoleSearch2;
import com.zy.crm.domain.Role;

public interface IRoleService {
	
	//����Ȩ��
	public List<Role> findRoleAll(RoleSearch2 role);
	
	//Ȩ��������
	public List<Role> findRoleAll();

	public void saveRole(Role role);
	
	public void deleteRoleByID(Serializable ... ids);

	public Role findRoleByID(String ids);

	public void updateRole(Role role);

}
