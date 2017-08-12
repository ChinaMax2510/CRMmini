package com.zy.crm.web.action;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.*;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.core.convert.converter.ConverterRegistry;

import com.opensymphony.xwork2.ModelDriven;
import com.zy.crm.annotation.Limit;
import com.zy.crm.bean.UserSearch;
import com.zy.crm.domain.Group;
import com.zy.crm.domain.Role;
import com.zy.crm.domain.User;
import com.zy.crm.service.IGroupService;
import com.zy.crm.service.IRoleService;
import com.zy.crm.service.IUserService;
import com.zy.crm.serviceimpl.UserServiceImpl;
import com.zy.crm.utils.MD5keyBean;
import com.zy.crm.utils.SQLDateConverter;
import com.zy.crm.utils.SessionUtils;
import com.zy.crm.utils.TypeChange;
import com.zy.crm.web.form.UserFrom;

public class UserAction extends BeansAction implements ModelDriven<UserFrom> {
	
	@Resource(name="UserServiceImpl")
	private IUserService userService;
	@Resource(name="roleServiceImpl")
	private IRoleService roleService; 
	@Resource(name="GroupSerivceImpl")
	private IGroupService<Group> groupService;
	
	private UserFrom userfrom=new UserFrom();

	@Override
	public UserFrom getModel() {
		// TODO Auto-generated method stub
		return userfrom;
	}
	
	/**
	 * �û���¼
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String UserLogin() throws UnsupportedEncodingException{
		MD5keyBean m = new MD5keyBean();
		
		boolean b=SessionUtils.isCheck(request);//��֤�봦��
		if(!b){
			this.addFieldError("checkNum", "�������֤������");
			return "login";
		}
		String name=userfrom.getName();
		String password=userfrom.getPassword();
		
		String MD5password = m.getkeyBeanofStr(password);
		
		//�û������봦��
		User users=userService.findUser_nameAndPws(name, MD5password);
		
		SessionUtils.setUserSession(request, users);
		if(users==null){
			this.addFieldError("name", "�û������������");
			return "login";
		}
	
		String checkbox=request.getParameter("check");
		if(StringUtils.isNotBlank(checkbox)){
		addCookies(name, password, request, response);
		}
		return "main";
		
	}
	@Limit(Module = "user", Privilege = "list")
	public String userShow(){
		List users=userService.findUser_Show();
		List<Group> groups=groupService.findAllGroup();
		this.request.setAttribute("sysUserGroupSelect", groups);
		this.request.setAttribute("users", users);
		return "show";
	}
	@Limit(Module = "user", Privilege = "save")
	public String userAdd() throws IllegalAccessException, InvocationTargetException{
		//Ȩ��������
		List<Role> roles=roleService.findRoleAll();
		//����������
		List<Group> groups=groupService.findAllGroup();
		this.request.setAttribute("roles", roles);
		this.request.setAttribute("sysUserGroupSelect", groups);
		//��ȡ��ǰʱ��
		String createTime=DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
		//��session�л�ȡuser����
		User user = (User) request.getSession().getAttribute("user");
		userfrom.setCreateTime(createTime);
		userfrom.setUpdateTime(createTime);
		userfrom.setCreator(user.getName());
		userfrom.setUpdater(user.getUpdater());;
		return "add";
	}
	@Limit(Module = "user", Privilege = "save")
	public String userSave() throws IllegalAccessException, InvocationTargetException{
		//ʵ����po����
		User user=new User();
		//ע������ת����
		ConvertUtils.register(new SQLDateConverter(), java.sql.Date.class);
		BeanUtils.copyProperties(user, userfrom);
		
		//���⴦�� Role  group ��������
		Group group = new Group();
		Role role = new Role();
		//��user����roleid �� groupid �����
		if(StringUtils.isNotBlank(userfrom.getGroupID())){
			
			group.setId(Integer.parseInt(userfrom.getGroupID()));
			user.setGroup(group);
		}
		if(StringUtils.isNotBlank(userfrom.getRoleID())){
			role.setId(userfrom.getRoleID());
			user.setRole(role);
		}
		userService.addUser(user);
		
		return "SHOW";
	}
	@Limit(Module = "user", Privilege = "delete")
	public String userDelete(){
		String id=request.getParameter("ids");
		userService.deleteUser(id);
		
		return "SHOW";
	}
	@Limit(Module = "user", Privilege = "list")
	public String userSearch() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		
		UserSearch us=new UserSearch();
		BeanUtils.copyProperties(us, userfrom);
		//PropertyUtils.copyProperties(us, userfrom);
		List<User> users=userService.findUserWithCondition(us);
		this.request.setAttribute("users", users);
		return "show";
	}
	
	//��ת�༭ҳ��
	@Limit(Module = "user", Privilege = "edit")
	public String ToEdit() throws IllegalAccessException, InvocationTargetException{
		//��ȡ���û�����ID
		String id = request.getParameter("id");
		
		//ͨ��ID�����û���Ϣ
		User user=userService.findUser_ByID(id);
		//��Ϣ���Ա༭ҳ��
		BeanUtils.copyProperties(userfrom, user);
			//����������
			List<Group> groups=groupService.findAllGroup();
			request.setAttribute("sysUserGroupSelect", groups);
			//Ȩ��������
			List<Role> roles=roleService.findRoleAll();
			request.setAttribute("sysRoleSelect", roles);
			
		return "edit";
	}
	@Limit(Module = "user", Privilege = "update")
	public String userUpdate() throws IllegalAccessException, InvocationTargetException{
		//ʵ����po����
		User user=new User();
		Group group = new Group();
		Role role = new Role();
		//��userfrom��String ����ת���� user��Date����
		ConvertUtils.register(new SQLDateConverter(), java.sql.Date.class);
		BeanUtils.copyProperties(user, userfrom);
		if(StringUtils.isNotBlank(userfrom.getGroupID())){
			group.setId(Integer.parseInt(userfrom.getGroupID()));
			user.setGroup(group);
		}
		if(StringUtils.isNotBlank(userfrom.getRoleID())){
			role.setId(userfrom.getRoleID());
			user.setRole(role);
		}
		//��ȡ��ǰ��¼�û�����
		User myUser=SessionUtils.getUserSession(request);
		user.setUpdater(myUser.getCnname());
		user.setUpdateTime(myUser.getUpdateTime());
		
		
		userService.updateUser(user);
		
		return "SHOW";
	}
	
	//������Ȩ
	@Limit(Module = "user", Privilege = "enable")
	public String enable(){
		
		//��ȡ��������id
		String []ids=request.getParameterValues("ids");
		Integer []IDS=TypeChange.ArrayStringToInt(ids);
		userService.startUser(IDS);
		
		return "SHOW";
	}
	
	//ͣ��
	@Limit(Module = "user", Privilege = "disable")
	public String disable(){
		
		String []ids=request.getParameterValues("ids");
		Integer []IDS=TypeChange.ArrayStringToInt(ids);
		userService.disableUser(IDS);
		return "SHOW";
	}


	private void addCookies(String name, String password, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		if(StringUtils.isNotBlank(name)||StringUtils.isNotBlank(password)){
			Cookie cname=new Cookie("name", URLEncoder.encode(name,"utf-8"));
			Cookie cpsw=new Cookie("password",password);
			cname.setPath(request.getContextPath()+"/");
			cpsw.setPath(request.getContextPath()+"/");
			cname.setMaxAge(3600*24*7);//����Cookies����
			cpsw.setMaxAge(3600*24*7);
			response.addCookie(cpsw);//����
			response.addCookie(cname);
		}
		
	}
	
	

}
