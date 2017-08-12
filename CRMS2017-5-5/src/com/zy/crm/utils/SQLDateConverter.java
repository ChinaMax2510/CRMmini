package com.zy.crm.utils;

import java.sql.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.util.IteratorGenerator.Converter;

public class SQLDateConverter implements org.apache.commons.beanutils.Converter {
	
	/**
	 * 类型转换器
	 * arg0为目标对象
	 * arg1(vo)String --> arg0(po)sql.Date
	 */
	@Override
	public Object convert(Class arg0, Object arg1) {
		// TODO Auto-generated method stub
		if(arg1==null||arg0==null){
			return null;
		}
		if(arg0!=Date.class){
			return null;
		}
		//arg1是否是String 对象的实例对象
		if( arg1 instanceof String){
			String str=(String) arg1 ;
			if(StringUtils.isNotBlank(str)){//有可能是空格
				return Date.valueOf(str);//将 JDBC 日期转义形式的字符串转换成 Date 值。
			}
			
		}
		return null;
	}

	

}
