package com.zy.crm.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Limit {
	String Module();//ģ������
	String Privilege();//��������

}
