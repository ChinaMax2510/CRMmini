package com.zy.crm.serviceimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import com.zy.crm.bean.GroupSearch;
import com.zy.crm.dao.ISysGroupDao;
import com.zy.crm.domain.Group;
import com.zy.crm.service.IGroupService;
//@Service(IGroupService.service_name)
@Transactional(readOnly=false)
public class GroupSerivceImpl<Group> implements IGroupService<Group> {
	
	
	@Resource(name="SysGroupDaoImpl")
	private ISysGroupDao ISysGroupDao;

	
	
	/**
	 * 
	 * 保证我们的这个方法中执行的所有的对数据库的更新操作保持在一个事务中，在事务层里面调用的这些方法要么全部成功，要么全部失败。
	 * 方法级别的事务会覆盖类级别的事务
	 * isolation=>事务的隔离级别
	 * propagation=>事务的传播行为
	 */
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void saveGroup(Group entity) {
		// TODO Auto-generated method stub
		ISysGroupDao.save(entity);
		
	}
	
	


	/**
	 * 通过部门名称  和  负责人 查询 部门
	 * 使用hql语句
	 * 因为HQL语句是面向对象的，所以可以把HQL语句写在service层里 （一般在service层写条件查询）
	 */
	@Override
	
	public List<Group> findGroups(GroupSearch search) {
		// TODO Auto-generated method stub
		
		/**
		 * select * from Group g where 1=1 and g.name like ? and g.principal = ? order by g.id asc , g.principal
		 */
		
		String hql="";
		List<String> paramsArray=new ArrayList<String>();
		
		if(StringUtils.isNotBlank(search.getPrincipal())){
			hql="and g.principal=?";
			paramsArray.add(search.getPrincipal());
		}
		if(StringUtils.isNotBlank(search.getName())){
			hql=hql+"and g.name like ?";
			paramsArray.add("%"+search.getName()+"%");
		}
		Object params[]=paramsArray.toArray();
		
		
		HashMap< String, String> hm=new HashMap<String, String>();
		hm.put("g.id", "asc");
		hm.put("g.name", "desc");
		
		@SuppressWarnings("unchecked")
		List<Group> list = (List<Group>) ISysGroupDao.findObjectConditionNoPage(hql, params, hm);
		
		return list;
	}


	@Override
	
	public List<Group> findAllGroup() {
		// TODO Auto-generated method stub
		/**
		 * 条件语句
		 */
		String hql="";
		/**
		 * 语句参数
		 */
		List params=new ArrayList<String>();
		Object[] parString=params.toArray();
		HashMap<String, String> map=new HashMap<String, String>();
		map.put(" g.id ", " asc");
		return (List<Group>) ISysGroupDao.findObjectConditionNoPage(hql, parString, map);
	}


	@Override
	
	public Group findGroupByid(Serializable ids) {
		// TODO Auto-generated method stub
		
		return (Group) ISysGroupDao.findById(ids);
	}




	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void updateGroup(com.zy.crm.domain.Group entity) {
		ISysGroupDao.update(entity);
		// TODO Auto-generated method stub
		
	}




	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void deleteGroup(Serializable[] ids) {
		// TODO Auto-generated method stub
		
		ISysGroupDao.delete(ids);
		
	}









}
