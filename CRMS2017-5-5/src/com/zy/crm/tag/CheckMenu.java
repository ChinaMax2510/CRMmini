package com.zy.crm.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang3.StringUtils;

import com.zy.crm.container.ServiceProvider;
import com.zy.crm.domain.MenuPrivilege;
import com.zy.crm.domain.User;
import com.zy.crm.service.IMenuPrivilege;
import com.zy.crm.utils.SessionUtils;

import freemarker.template.utility.StringUtil;

public class CheckMenu implements SimpleTag {
	//九大内置对象之一       可以获取对项域如：request  response  session 等
	private PageContext p;
	//标签体
	private JspFragment fragment;
	
	//标签属性
	private String module;
	private String privilege;
	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		//获取request对象
		HttpServletRequest request=(HttpServletRequest) p.getRequest();
		//获取登录用户对象
		User user=SessionUtils.getUserSession(request);
		if(user==null||user.getRole()==null){
			return;
		}
		//获取权限ID
		String roleID=user.getRole().getId();
		//获取权限业务层
		IMenuPrivilege MenuPrivilege=(IMenuPrivilege) ServiceProvider.getService("MenuPrivilegeServiceImpl");
		//获取权限表（sys_menu_privilege）数据
		List<MenuPrivilege> lists=MenuPrivilege.findAllMenuPrivilegeCache();
		//遍历集合
		if(lists!=null&&lists.size()>0){
			for(int i =0 ; i<lists.size();i++){
				MenuPrivilege mp=lists.get(i);
				if(StringUtils.isNotBlank(roleID)&&StringUtils.isNotBlank(module)&&StringUtils.isNotBlank(privilege)){
					if(roleID.equals(mp.getId().getRoleId())&&module.equals(mp.getId().getMenuModule())&&privilege.equals(mp.getId().getMenuPrivilege())){
						this.fragment.invoke(null);//输出标签体
						
						break;
					}
				}
			}
		}
	}

	@Override
	public JspTag getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setJspBody(JspFragment arg0) {
		// TODO Auto-generated method stub
		this.fragment=arg0;
		
	}

	@Override
	public void setJspContext(JspContext arg0) {
		// TODO Auto-generated method stub
		this.p=(PageContext) arg0;
		
	}

	@Override
	public void setParent(JspTag arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void setModule(String module) {
		this.module = module;
	}

	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}

	
}
