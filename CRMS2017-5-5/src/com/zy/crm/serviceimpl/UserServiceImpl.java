package com.zy.crm.serviceimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zy.crm.bean.UserSearch;
import com.zy.crm.dao.IUserDao;
import com.zy.crm.domain.User;
import com.zy.crm.service.IUserService;
import com.zy.crm.utils.SessionUtils;

@Transactional(readOnly=true)
public class UserServiceImpl implements IUserService {
	
	@Resource(name="UserDaoImpl")
	private IUserDao userdao;

	@Override
	public User findUser_nameAndPws(String name, String password  ) {
		// TODO Auto-generated method stub
		String hql="";
		List<String> list=new ArrayList<String>();
		HashMap< String, String> map=new HashMap<String, String>();
		if(StringUtils.isNotBlank(name)||StringUtils.isNotBlank(password)){
			hql=" and g.name =? and g.password=? ";
			list.add(name);
			list.add(password);
		}
		Object params[]=list.toArray();
		map.put(" g.id ", " asc ");
		List<User> users=userdao.findObjectConditionNoPage(hql, params, map);
		if(users!=null&&users.size()==1){
			
			return users.get(0);
		}
		return null;
		
		
		
	}

	@Override
	public List<User> findUser_Show() {
		HashMap<String,String> map = new HashMap<String, String>();
		map.put(" g.id ", " asc ");
		// TODO Auto-generated method stub
		return userdao.findObjectConditionNoPage(map);
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userdao.save(user);
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void deleteUser(String is) {
		// TODO Auto-generated method stub
		int ID=Integer.parseInt(is);
		userdao.delete(ID);
	}

	@Override
	public List<User> findUserWithCondition(UserSearch us) {
		// TODO Auto-generated method stub
		String hql="";
		List array=new ArrayList();
		if(StringUtils.isNotBlank(us.getName())){
			hql=" and g.name like ? ";
			array.add("%"+us.getName()+"%");
		}
		if(StringUtils.isNotBlank(us.getCnname())){
			hql=hql+" and g.cnname = ? ";
			array.add(us.getCnname());
		}
		if(StringUtils.isNotBlank(us.getGroupID())){
			hql=hql+" and g.Group.id = ?";
			array.add(Integer.parseInt(us.getGroupID()));
		}
		if(StringUtils.isNotBlank(us.getStatus())){
			hql=hql+" and g.status = ? ";
			array.add(us.getStatus());
		}
		Object params[]=array.toArray();
		for(int i =0 ; i<params.length ; i++){
		}
		HashMap<String,String> map=new HashMap<String, String>();
		map.put(" g.id ", "asc");
		
		return userdao.findObjectConditionNoPage(hql, params, map);
	}

	@Override
	public User findUser_ByID(String id) {
		// TODO Auto-generated method stub
		Integer ID=Integer.parseInt(id);
	
		return userdao.findById(ID);
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userdao.update(user);
		
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void startUser(Integer[] ids) {
		// TODO Auto-generated method stub
		if(ids!=null&&ids.length>0){
			for(int i = 0 ;i<ids.length; i++){
				User user=userdao.findById(ids[i]);
				user.setStatus("Y");
				userdao.save(user);
			}
		}
		
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void disableUser(Integer[] ids) {
		// TODO Auto-generated method stub
		if(ids!=null&&ids.length>0){
			for(int i = 0 ;i<ids.length; i++){
				User user=userdao.findById(ids[i]);
				user.setStatus("N");
				userdao.save(user);
			}
		
	}


	}
}
