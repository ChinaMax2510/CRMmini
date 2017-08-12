 package com.zy.crm.web.action;


import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zy.crm.annotation.Limit;
import com.zy.crm.bean.GroupSearch;
import com.zy.crm.container.ServiceProvider;
import com.zy.crm.domain.Group;
import com.zy.crm.service.IGroupService;
import com.zy.crm.utils.TypeChange;
import com.zy.crm.web.form.GroupForm;

@SuppressWarnings("serial")
public class GroupAction extends ActionSupport 
		implements ModelDriven<GroupForm>,ServletRequestAware{

	private HttpServletRequest request;//map栈
	private GroupForm gf=new GroupForm();
	//获取service对象 从Pring容器中获取service对象
	@SuppressWarnings("unchecked")
	IGroupService<Group> igs=(IGroupService<Group>)ServiceProvider
			                    .getService("GroupSerivceImpl");
	
	
	@Override
	public GroupForm getModel() {
		// TODO Auto-generated method stub
		return gf;
	}
	
	@Limit(Module="group", Privilege = "save")
	public String save() throws IllegalAccessException, InvocationTargetException{
		System.out.println(gf.getName());
		//实例化对象
		Group group=new Group();
		BeanUtils.copyProperties(group, gf);//把vo对象（与表单对应）赋值到po对象（与表关联的javabean）
		
		igs.saveGroup(group);
		return "LIST";
	}
	
	/**
	 * 显示添加页面
	 */
	@Limit(Module="group",Privilege="add")
	public String add(){
		
		return "add";
	}
	
	/**
	 * 显示查询结果列表
	 */
	@Limit(Module="group",Privilege="list")
	public String list(){
		
		GroupSearch search=new GroupSearch();
		if(StringUtils.isNotBlank(gf.getName())){
		search.setName(gf.getName());
		}
		List<Group> list=igs.findGroups(search);
		//List list=igs.findAllGroup();
		//把结果回送给表现层
		request.setAttribute("sysUserGroups", list);
		return "list";
	}
	@Limit(Module = "group", Privilege = "edit")
	public String edit() throws IllegalAccessException, InvocationTargetException{
		Group group = null;
		//获取对象id
		String id=gf.getId();
		Integer ID=Integer.parseInt(id.trim());
	    group=igs.findGroupByid(ID);
		BeanUtils.copyProperties(gf, group);//数据回显
		return "edit";
	}
	@Limit(Module = "group", Privilege = "group")
	public String update() throws IllegalAccessException, InvocationTargetException{
		Group group=new Group();
		BeanUtils.copyProperties(group, gf);
		igs.updateGroup(group);
		List<Group> list=igs.findAllGroup();
		request.setAttribute("sysUserGroups", list);
		return "list";
	}
	@Limit(Module = "group", Privilege = "delete")
	public String delete(){
		String[] IDs=request.getParameterValues("ids");
		Integer []IDS=TypeChange.ArrayStringToInt(IDs);
		igs.deleteGroup(IDS);
		return "LIST";
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request=arg0;
		// TODO Auto-generated method stub
		
	}

}
