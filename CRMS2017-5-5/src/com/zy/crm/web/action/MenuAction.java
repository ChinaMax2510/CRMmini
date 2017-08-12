package com.zy.crm.web.action;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zy.crm.container.ServiceProvider;
import com.zy.crm.domain.Menu;
import com.zy.crm.service.IMenuPrivilege;
import com.zy.crm.service.IMenuService;

@SuppressWarnings("serial")
public class MenuAction extends BeansAction {
	
	IMenuService menu=(IMenuService) ServiceProvider.getService("MenuServiceImpl");
	IMenuPrivilege MenuPrivilege=(IMenuPrivilege) ServiceProvider.getService("MenuPrivilegeServiceImpl");
	
	
	public String top(){
		System.out.println("");
		return "top";
	}
	public String left(){
		//菜单为公用数据
		List<Menu> menus=menu.findAllMenuCache();
		ServletContext servletContext = ServletActionContext.getServletContext();
		servletContext.setAttribute("menus", menus);
		return "left";
	}
	public String welcome(){
		return "welcome";
	}

}
