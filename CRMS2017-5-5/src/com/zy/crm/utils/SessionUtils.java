package com.zy.crm.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import com.zy.crm.domain.User;

public class SessionUtils {
	
	/**
	 * ��¼��֤��
	 * @param request
	 * @return
	 */
	public static boolean isCheck(HttpServletRequest request){
		System.out.println("=============");
		//��ȡsessio�е���֤��
		HttpSession session=request.getSession(false);//���û�ҵ���session����ȥ�½�session
		if(session==null){
			return false;
		}
		String sys_check=(String)session.getAttribute("CHECK_NUMBER_KEY");
		if(StringUtils.isBlank(sys_check)){
			System.out.println("a");
			return false;
		}
		//��ȡ�û��������֤��
		String user_check=request.getParameter("ckeckNum");
		if(StringUtils.isBlank(user_check)){
			System.out.println("b");
			return false;
		}
		return user_check.equals(sys_check);
	}
	
	/**
	 * ���û���Ϣ����session������
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
	/**�û���Ϣ�Ǵӵ�¼��֤�ǵõ���
	 * ��session��ȡ���û���Ϣ
	 * @param request
	 * @return
	 */
	public static User getUserSession(HttpServletRequest request){
		return (User) request.getSession().getAttribute("user");
	}

}
