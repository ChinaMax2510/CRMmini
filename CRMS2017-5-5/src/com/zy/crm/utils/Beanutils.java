package com.zy.crm.utils;

import java.lang.reflect.Field;

import com.zy.crm.domain.User;

public class Beanutils {

	public static void main(String[] args) throws IllegalAccessException {
		// TODO Auto-generated method stub
		User user = new User();
		Person person=new Person();
		person.setName("小明");
		//person.setSex("sss");
		System.out.println(checkObjFieldIsNull(user));
		//System.out.println(user.getName()+"名字 ");

	}
	/**java反射机制
	 * 判断对象属性是否为空
	 * @param bo
	 * @return
	 * @throws IllegalAccessException
	 */
	public static boolean checkObjFieldIsNull(Object bo) throws IllegalAccessException {

		 
		    if(bo == null){  
		        return true;  
		    }  
		    Class clz = bo.getClass();  
		    Field[] f = clz.getDeclaredFields();  //返回该对象所有字段属性
		    try {  
		        for (int i = 0; i < f.length; i++) {  
		            f[i].setAccessible(true);  //使对象的私有属性可视化
		            if (f[i].get(bo) != null) {  
		               // f[i].set(bo, "default");  
		            	return false;
		            }  
		        }  
		    } catch (IllegalArgumentException e) {  
		        e.printStackTrace();  
		    } catch (IllegalAccessException e) {  
		        e.printStackTrace();  
		    }  
		    return true;  
		
	}

}
class Person{
	private String name;
	private String sex;

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
