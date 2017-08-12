package com.zy.crm.web.action;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import com.mchange.v2.beans.BeansUtils;
import com.opensymphony.xwork2.ModelDriven;
import com.zy.crm.annotation.Limit;
import com.zy.crm.bean.RoleSearch2;
import com.zy.crm.container.ServiceProvider;
import com.zy.crm.container.ServiceProviderCore;
import com.zy.crm.domain.Menu;
import com.zy.crm.domain.Popdeom;
import com.zy.crm.domain.PopdeomPrivilege;
import com.zy.crm.domain.Role;
import com.zy.crm.service.IMenuPrivilege;
import com.zy.crm.service.IMenuService;
import com.zy.crm.service.IPopdeom;
import com.zy.crm.service.IPopdeomPrivilege;
import com.zy.crm.service.IRoleService;
import com.zy.crm.web.form.RoleForm;

public class RoleAction extends BeansAction implements ModelDriven<RoleForm> {
	
	
	/**
	 * ˵����ֻ�ܻ�ȡ���ı�������ݺ�url?�������
	 */
	private RoleForm rolefrom=new RoleForm();
	@Override
	public RoleForm getModel() {
		// TODO Auto-generated method stub
		return rolefrom;
	}
	
	//��Spring�л�ȡ����
	IRoleService roleService=(IRoleService) ServiceProvider.getService("roleServiceImpl");
	@SuppressWarnings("unchecked")
	IPopdeom<Popdeom> popdeom=(IPopdeom<Popdeom>) ServiceProvider.getService("PopdeomServiceImpl");
	IPopdeomPrivilege privilege=(IPopdeomPrivilege) ServiceProvider.getService("PopdeomPrivilegeImpl");
	IMenuService menu=(IMenuService) ServiceProvider.getService("MenuServiceImpl");
	IMenuPrivilege MenuPrivilege=(IMenuPrivilege) ServiceProvider.getService("MenuPrivilegeServiceImpl");
	
	@Limit(Module = "role", Privilege = "list")
	public String list(){
		
		RoleSearch2 search=new RoleSearch2();
		search.setName(rolefrom.getName());
		
		List<Role> roles=roleService.findRoleAll(search);
		
		this.request.setAttribute("rolelist", roles);
		return "list";
	}
	@Limit(Module = "role", Privilege = "save")
	public String save() throws IllegalAccessException, InvocationTargetException{
		Role role=new Role();
		if(StringUtils.isNotBlank(rolefrom.getName())||StringUtils.isNotBlank(rolefrom.getRemark())){
			BeanUtils.copyProperties(role, rolefrom);
			roleService.saveRole(role);
		}
		return "LIST";
	}
	
	public String ToAdd(){
		
		return "add";
	}
	@Limit(Module = "role", Privilege = "delete")
	public String delete(){
		String ids[]=request.getParameterValues("ids");
		roleService.deleteRoleByID(ids);
		return "LIST";
	} 
	@Limit(Module = "role", Privilege = "edit")
	public String ToEdit() throws IllegalAccessException, InvocationTargetException{
		String ids=rolefrom.getId();
		Role role=roleService.findRoleByID(ids);
		BeanUtils.copyProperties(rolefrom, role);
		return "edit";
	}
	@Limit(Module = "role", Privilege = "edit")
	public String update() throws IllegalAccessException, InvocationTargetException{
		Role role=new Role();
		BeanUtils.copyProperties(role, rolefrom);
		roleService.updateRole(role);
		return "LIST";
	}
	
	//��ʾ����Ȩ��Ȩ��
	@Limit(Module = "role", Privilege = "list")
	public String ListPopdeom(){
		//��ʾȨ����Ϣ
		String roleId=request.getParameter("roleId");
		Role role=roleService.findRoleByID(roleId);
		List<Popdeom> popdoms=popdeom.findAllPopdeom();
		this.request.setAttribute("sysPopedoms", popdoms);
		this.request.setAttribute("roles", role);
		
		
		//����֮��������õ�Ȩ��
		List<PopdeomPrivilege> privileges=privilege.findPopedomPrivilegeByID(roleId);
		this.request.setAttribute("sysPopedomPriviles", privileges);
		return "listpopdeom";
	}
	
	//����Ȩ��
	@Limit(Module = "role", Privilege = "update")
	public String updatePopdeom(){
		String roleID=request.getParameter("roleId");
		
		//Role role=roleService.findRoleByID(roleID);
		String popedomModule[]=request.getParameterValues("popedomModule");	
		privilege.updatePopdeom(roleID, popedomModule);
		return "update";
	}
	
	//��ʾ�˵�Ȩ��
	@Limit(Module="role" , Privilege="listMenu")
	public String listMenu(){
		//Ȩ������
		String roleID=request.getParameter("roleId");
		
		Role  roles=roleService.findRoleByID(roleID);
		this.request.setAttribute("sysRole", roles);
		//��ʾѡ����Ϣ
		List<Menu> menus=menu.findAllMenu();
		this.request.setAttribute("menuArray", menus);
		//ѡ��Ȩ�޻���
		List<com.zy.crm.domain.MenuPrivilege> privileges=MenuPrivilege.findAllMenuPriByID(roleID);
		this.request.setAttribute("privileges", privileges);
		return "listMenu";
	}
	
	//ѡ��˵�Ȩ��
	@Limit(Module="role" , Privilege="updateMenu")
	public String updateMenu(){
		String roleId=request.getParameter("roleId");
		
		String []menuModule=request.getParameterValues("menuModule");
		MenuPrivilege.updateMenu(roleId, menuModule);
		return "updateMenu";
	}
	
	

}
