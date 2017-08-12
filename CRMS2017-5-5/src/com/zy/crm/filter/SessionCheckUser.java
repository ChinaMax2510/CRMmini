package com.zy.crm.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zy.crm.domain.User;
import com.zy.crm.utils.SessionUtils;

/**
 * Servlet Filter implementation class SessionCheckUser
 */
public class SessionCheckUser implements Filter {
	
	List<String> array;

    /**
     * Default constructor. 
     */
    public SessionCheckUser() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req , ServletResponse res , FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)res;
		
		String path=request.getServletPath();
		if(array!=null&&array.contains(path)){
			
			chain.doFilter(request, response);
			return;
		}
		User user=SessionUtils.getUserSession(request);
		
		//判断Session中是否有user对象
		if(user!=null){
			chain.doFilter(request, response);
		}else{
			//请求重定向到 index.jsp (http://127.0.0.1:8080/CRM/)
			response.sendRedirect(request.getContextPath());
		}

		// pass the request along the filter chain
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		//不过滤这些
		array=new ArrayList<String>();
		array.add("/image.jsp");
		array.add("/index.jsp");
		array.add("/WEB-INF/page/login.jsp");
		array.add("/sys/loginAction_UserLogin.do");
	}

}
