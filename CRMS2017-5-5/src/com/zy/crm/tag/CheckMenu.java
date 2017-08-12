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
	//�Ŵ����ö���֮һ       ���Ի�ȡ�������磺request  response  session ��
	private PageContext p;
	//��ǩ��
	private JspFragment fragment;
	
	//��ǩ����
	private String module;
	private String privilege;
	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		//��ȡrequest����
		HttpServletRequest request=(HttpServletRequest) p.getRequest();
		//��ȡ��¼�û�����
		User user=SessionUtils.getUserSession(request);
		if(user==null||user.getRole()==null){
			return;
		}
		//��ȡȨ��ID
		String roleID=user.getRole().getId();
		//��ȡȨ��ҵ���
		IMenuPrivilege MenuPrivilege=(IMenuPrivilege) ServiceProvider.getService("MenuPrivilegeServiceImpl");
		//��ȡȨ�ޱ�sys_menu_privilege������
		List<MenuPrivilege> lists=MenuPrivilege.findAllMenuPrivilegeCache();
		//��������
		if(lists!=null&&lists.size()>0){
			for(int i =0 ; i<lists.size();i++){
				MenuPrivilege mp=lists.get(i);
				if(StringUtils.isNotBlank(roleID)&&StringUtils.isNotBlank(module)&&StringUtils.isNotBlank(privilege)){
					if(roleID.equals(mp.getId().getRoleId())&&module.equals(mp.getId().getMenuModule())&&privilege.equals(mp.getId().getMenuPrivilege())){
						this.fragment.invoke(null);//�����ǩ��
						
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
