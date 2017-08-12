package com.zy.crm.container;

import javax.management.RuntimeErrorException;

import org.apache.commons.lang3.StringUtils;

public class ServiceProvider {
	private static ServiceProviderCore spc;
	static {
		spc=new ServiceProviderCore();
		spc.load("applicationContext.xml");
	}
	/**
	 * 在执行方法前线加载static 代码块
	 * @param beanname
	 * @return
	 */
	public static Object getService(String beanname){
		
		if(StringUtils.isBlank(beanname)){
			throw new RuntimeException("bean不能为空！");
		}
		
		Object bean=null;
		if(spc.ac.containsBean(beanname)){
			bean=spc.ac.getBean(beanname);
		}
		if(bean==null){
			throw new RuntimeException(beanname+"不存在");
		}
		
		
		return bean;
	}

}
