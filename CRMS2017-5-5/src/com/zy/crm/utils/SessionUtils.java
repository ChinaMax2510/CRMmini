package com.zy.crm.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import com.zy.crm.domain.User;

public class SessionUtils {
	
	/**
	 * 登录验证码
	 * @param request
	 * @return
	 */
	public static boolean isCheck(HttpServletRequest request){
		System.out.println("=============");
		//获取sessio中的验证码
		HttpSession session=request.getSession(false);//如果没找到改session不会去新建session
		if(session==null){
			return false;
		}
		String sys_check=(String)session.getAttribute("CHECK_NUMBER_KEY");
		if(StringUtils.isBlank(sys_check)){
			System.out.println("a");
			return false;
		}
		//获取用户输入的验证码
		String user_check=request.getParameter("ckeckNum");
		if(StringUtils.isBlank(user_check)){
			System.out.println("b");
			return false;
		}
		return user_check.equals(sys_check);
	}
	
	/**
	 * 把用户信息放入session对象中
	 * @param request
	 * @param user
	 */
	public static void setUserSession(HttpServletRequest request , User user){
		if(user!=null){
			System.out.println("usersession");
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
		}
	}
	/**用户信息是从登录验证那得到的
	 * 从session中取出用户信息
	 * @param request
	 * @return
	 */
	public static User getUserSession(HttpServletRequest request){
		return (User) request.getSession().getAttribute("user");
	}

}
