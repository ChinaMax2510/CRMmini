package com.zy.crm.interceptor;

import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.zy.crm.annotation.Limit;
import com.zy.crm.container.ServiceProvider;
import com.zy.crm.domain.PopdeomPrivilege;
import com.zy.crm.domain.User;
import com.zy.crm.service.IPopdeomPrivilege;
import com.zy.crm.utils.SessionUtils;
/**
 * ��Ϊÿ�������������һ����Ӧ��action����,����Ҫ����һ������������ָ���Ķ���(action)ʵ��Ȩ�޿���
 * �粻���������ã�����������action����
 * <param name="excludeMethods">UserLogin,top,left,welcome</param>�ų�action����
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class LimitInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation a) throws Exception {
		// TODO Auto-generated method stub
		
		//��ȡ�����action����
		Object action=a.getAction();
		//��ȡ����ķ�����
		String MethodName=a .getProxy().getMethod();
		//��ȡaction�����ķ�װ��  action�еķ���û�в�������Ϊ�գ������������أ�����Ҫ�Ӳ������������
		Method method=action.getClass().getMethod(MethodName, null);
		
		//��ȡ��¼�û�(SESSION��)
		HttpServletRequest request=ServletActionContext.getRequest();
		//����ע��
		boolean falg=this.isCheckLimit(request,method);
		//û��Ȩ��
		if(!falg){
			return "popmsg_popedom";
		}
		//��Ȩ��
		String actionMaethod=a.invoke();//action�����ķ���ֵ
		return actionMaethod;
	}

	private boolean isCheckLimit(HttpServletRequest request, Method method) {
		
		// TODO Auto-generated method stub
		boolean falg=false;
		if(method==null){
			return falg;
		}
		//��ȡ��¼�û�
		User user=SessionUtils.getUserSession(request);
		if(user==null||user.getRole()==null){
			return falg;
		}
		//Ȩ����ID
		String roleID=user.getRole().getId();
		//�ж�action�з����Ƿ���Limitע��
		boolean isAnnotationPresent=method.isAnnotationPresent(Limit.class);
		//���������ע��
		if(!isAnnotationPresent){
			return falg;
		}
		//��ȡע���ֵ
		Limit limit=method.getAnnotation(Limit.class);
		String module=limit.Module();
		String privilege=limit.Privilege();
		
		
		//��ȡPopdeomServiceImpl����
		IPopdeomPrivilege popdeomPrivilege=(IPopdeomPrivilege) ServiceProvider.getService("PopdeomPrivilegeImpl");
		//��PopdeomPrivilege���л�ȡ����
		List<PopdeomPrivilege> list=popdeomPrivilege.findAllpopdeomPrivilegeCache();
		if(list!=null&&list.size()>0){
			for(int i = 0 ; i<list.size();i++){
				PopdeomPrivilege pp=list.get(i);
				if(pp!=null){
					//����û�Ȩ�����id �� �ͱ����ж�Ӧֵ
					//���� ע���� module �� privilege ��ֵ ��popdeomPrivilege���ж�Ӧֵ��˵���и�Ȩ��
					if(roleID.equals(pp.getIds().getRoleId())&&module.equals(pp.getIds().getPopedomModule())&&privilege.equals(pp.getIds().getPopedomPrivilege())){
						falg=true;
					}
				}
			}
		}
		return falg;
	}

}
