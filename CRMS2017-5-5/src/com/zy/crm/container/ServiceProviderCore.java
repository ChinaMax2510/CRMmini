package com.zy.crm.container;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceProviderCore {
	
	protected ApplicationContext ac;
	
	public void load(String name){
		ac=new ClassPathXmlApplicationContext(name);
	}

	

}
