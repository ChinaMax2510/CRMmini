package com.zy.crm.utils;

import java.lang.reflect.ParameterizedType;
/**
 *  ��ȡ����ʵ������ ���ͷ���
 * @author Administrator
 *
 */
public class GenericClass {
	
	public static Class getGenericClass(Class c){
		Class classs=(Class) ((ParameterizedType) c.getGenericSuperclass()).getActualTypeArguments()[0];
		return classs;
	}

}
