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
 * 因为每个点击动作都有一个对应的action方法,所以要设置一个拦截器拦截指定的动作(action)实现权限控制
 * 如不做以下配置，会拦截所有action方法
 * <param name="excludeMethods">UserLogin,top,left,welcome</param>排除action方法
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class LimitInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation a) throws Exception {
		// TODO Auto-generated method stub
		
		//获取请求的action对象
		Object action=a.getAction();
		//获取请求的方法名
		String MethodName=a .getProxy().getMethod();
		//获取action方法的封装类  action中的方法没有参数所以为空，方法可以重载，所以要加参数。反射机制
		Method method=action.getClass().getMethod(MethodName, null);
		
		//获取登录用户(SESSION中)
		HttpServletRequest request=ServletActionContext.getRequest();
		//处理注解
		boolean falg=this.isCheckLimit(request,method);
		//没有权限
		if(!falg){
			return "popmsg_popedom";
		}
		//有权限
		String actionMaethod=a.invoke();//action方法的返回值
		return actionMaethod;
	}

	private boolean isCheckLimit(HttpServletRequest request, Method method) {
		
		// TODO Auto-generated method stub
		boolean falg=false;
		if(method==null){
			return falg;
		}
		//获取登录用户
		User user=SessionUtils.getUserSession(request);
		if(user==null||user.getRole()==null){
			return falg;
		}
		//权限组ID
		String roleID=user.getRole().getId();
		//判断action中方法是否有Limit注解
		boolean isAnnotationPresent=method.isAnnotationPresent(Limit.class);
		//如果不存在注解
		if(!isAnnotationPresent){
			return falg;
		}
		//获取注解的值
		Limit limit=method.getAnnotation(Limit.class);
		String module=limit.Module();
		String privilege=limit.Privilege();
		
		
		//获取PopdeomServiceImpl对象
		IPopdeomPrivilege popdeomPrivilege=(IPopdeomPrivilege) ServiceProvider.getService("PopdeomPrivilegeImpl");
		//从PopdeomPrivilege表中获取数据
		List<PopdeomPrivilege> list=popdeomPrivilege.findAllpopdeomPrivilegeCache();
		if(list!=null&&list.size()>0){
			for(int i = 0 ; i<list.size();i++){
				PopdeomPrivilege pp=list.get(i);
				if(pp!=null){
					//如果用户权限组的id ， 和表中有对应值
					//并且 注解中 module 和 privilege 的值 与popdeomPrivilege表有对应值，说明有该权限
					if(roleID.equals(pp.getIds().getRoleId())&&module.equals(pp.getIds().getPopedomModule())&&privilege.equals(pp.getIds().getPopedomPrivilege())){
						falg=true;
					}
				}
			}
		}
		return falg;
	}

}
