package com.zy.crm.utils;

import java.lang.reflect.ParameterizedType;
/**
 *  获取泛型实际类型 泛型反射
 * @author Administrator
 *
 */
public class GenericClass {
	
	public static Class getGenericClass(Class c){
		Class classs=(Class) ((ParameterizedType) c.getGenericSuperclass()).getActualTypeArguments()[0];
		return classs;
	}

}
