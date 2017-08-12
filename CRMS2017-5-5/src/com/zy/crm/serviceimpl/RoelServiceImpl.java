package com.zy.crm.serviceimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zy.crm.bean.RoleSearch2;
import com.zy.crm.dao.IRoleDao;
import com.zy.crm.domain.Role;
import com.zy.crm.service.IRoleService;

@Transactional(readOnly=true)
public class RoelServiceImpl implements IRoleService{
	
	@Resource(name="RoleDaoImpl")
	private IRoleDao ird;

	@Override
	public List<Role> findRoleAll(RoleSearch2 role) {
		// TODO Auto-generated method stub
		String hql="";
		List<String> param=new ArrayList<String>();
		if(StringUtils.isNotBlank(role.getName())){
			hql=" and g.name like ?";
			param.add(role.getName());
		}
		HashMap<String, String> map=new HashMap<String, String>();
		map.put(" g.name ", " asc ");
		List <Role> list=ird.findObjectConditionNoPage(hql, param.toArray(), map);
		return list;
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,readOnly=false)
	public void saveRole(Role role) {
		ird.save(role);
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,readOnly=false)
	public void deleteRoleByID(Serializable... ids) {
		
		ird.delete(ids);
		// TODO Auto-generated method stub
		
	}

	@Override
	public Role findRoleByID(String ids) {
		
		// TODO Auto-generated method stub
		return ird.findById(ids);
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,readOnly=false)
	public void updateRole(Role role) {
		ird.update(role);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Role> findRoleAll() {
		// TODO Auto-generated method stub
		HashMap<String, String> map=new HashMap<String, String>();
		map.put(" g.id ", " asc ");
		
		return ird.findObjectConditionNoPage(map);
	}

	

}
