package com.zy.crm.utils;

import java.lang.reflect.Field;

import com.zy.crm.domain.User;

public class Beanutils {

	public static void main(String[] args) throws IllegalAccessException {
		// TODO Auto-generated method stub
		User user = new User();
		Person person=new Person();
		person.setName("С��");
		//person.setSex("sss");
		System.out.println(checkObjFieldIsNull(user));
		//System.out.println(user.getName()+"���� ");

	}
	/**java�������
	 * �ж϶��������Ƿ�Ϊ��
	 * @param bo
	 * @return
	 * @throws IllegalAccessException
	 */
	public static boolean checkObjFieldIsNull(Object bo) throws IllegalAccessException {

		 
		    if(bo == null){  
		        return true;  
		    }  
		    Class clz = bo.getClass();  
		    Field[] f = clz.getDeclaredFields();  //���ظö��������ֶ�����
		    try {  
		        for (int i = 0; i < f.length; i++) {  
		            f[i].setAccessible(true);  //ʹ�����˽�����Կ��ӻ�
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
