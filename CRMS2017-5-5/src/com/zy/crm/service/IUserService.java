package com.zy.crm.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.zy.crm.bean.UserSearch;
import com.zy.crm.domain.User;

public interface IUserService {
	
	//登录验证
	public User findUser_nameAndPws(String name , String password  );
	
	//用户显示列表
	public List<User> findUser_Show();

	public void addUser(User user);
	
	public void deleteUser(String is);

	public List<User> findUserWithCondition(UserSearch us);

	public User findUser_ByID(String id);

	public void updateUser(User user);

	public void startUser(Integer[] iDS);

	public void disableUser(Integer[] iDS);

}
