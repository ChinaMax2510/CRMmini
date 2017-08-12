package com.zy.crm.utils;

import org.junit.Test;

public class TypeChange {
	
	public static Integer[] ArrayStringToInt(String []strings){
		Integer []integers=new Integer[strings.length];
		if(strings!=null&&strings.length>0){
			for(int i = 0;i<strings.length;i++){
				if(strings[i].equals("")){
					continue;//结束本次循环，继续下一次循环
				}
				integers[i]=Integer.parseInt(strings[i]);
			}
			return integers;
		}
		
		return null;
	}
	
	public static String getFristNumber(Integer glideBit){
		if(glideBit==null&&glideBit<3){
			glideBit=3;
		}
		String bit="";
		for(int i=1 ; i<glideBit;i++){
			bit=bit+"0";
			
		}
		bit=bit+"1";
		return bit;
	}
	
	public static String getNextNumber(String glideBit){
		
		String GlideBit="1"+glideBit;
		int IntGB=Integer.parseInt(GlideBit);
		IntGB++;
		String myGlideBit=(IntGB+"").substring(1);
		return myGlideBit;
	}
	
	public static void main(String[] args) {
		System.out.println(getNextNumber("001"));
		
	}

}
