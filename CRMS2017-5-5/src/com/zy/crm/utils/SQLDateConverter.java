package com.zy.crm.utils;

import java.sql.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.util.IteratorGenerator.Converter;

public class SQLDateConverter implements org.apache.commons.beanutils.Converter {
	
	/**
	 * ����ת����
	 * arg0ΪĿ�����
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
		//arg1�Ƿ���String �����ʵ������
		if( arg1 instanceof String){
			String str=(String) arg1 ;
			if(StringUtils.isNotBlank(str)){//�п����ǿո�
				return Date.valueOf(str);//�� JDBC ����ת����ʽ���ַ���ת���� Date ֵ��
			}
			
		}
		return null;
	}

	

}
