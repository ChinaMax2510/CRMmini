package com.zy.crm.service;

import java.io.Serializable;
import java.util.List;

import com.zy.crm.bean.GroupSearch;
import com.zy.crm.domain.Group;

@SuppressWarnings("hiding")
public interface IGroupService<Group> {
	
	 //public static final String service_name="com.zy.crm.serviceimpl.GroupSerivceImpl";
	
	
	public void saveGroup(Group entity);
	
	public List<Group> findGroups(GroupSearch groupSearch);
	
	public List<Group> findAllGroup();
	
	public Group findGroupByid(Serializable ids);
	
	public void updateGroup(com.zy.crm.domain.Group entity);
	
	public void deleteGroup(Serializable[] ids);

}
