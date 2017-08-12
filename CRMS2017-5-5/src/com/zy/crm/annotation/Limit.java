package com.zy.crm.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Limit {
	String Module();//模块名称
	String Privilege();//操作名称

}
