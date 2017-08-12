package com.zy.crm.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class PingyinUtils {
	
	/**   
     * 汉字转换为汉语拼音首字母，英文字符不变   
     * @param chines 汉字   
     * @return 拼音
     */      
    public static String converterToFirstSpell(String chines){              
         String pinyinName = "";   
         
         //杞寲涓哄瓧绗�
         char[] nameChar = chines.toCharArray();
//         for(int i=0;i<nameChar.length;i++){
//        	 System.out.println(nameChar[i]);
//         }
         
         //姹夎鎷奸煶鏍煎紡杈撳嚭绫�   
         HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
         
         //杈撳嚭璁剧疆,澶у皬鍐�,闊虫爣鏂瑰紡绛�   
         defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);       
         defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);       
         
         for (int i = 0; i < nameChar.length; i++) {       
             //濡傛灉鏄腑鏂�
        	 if (nameChar[i] > 128) {
                try {       
                     pinyinName += 
                    	   PinyinHelper.toHanyuPinyinStringArray(nameChar[i], defaultFormat)[0].charAt(0);       
                 } catch (BadHanyuPinyinOutputFormatCombination e) {       
                     e.printStackTrace();       
                 }       
             }else{//涓鸿嫳鏂囧瓧绗�    
                 pinyinName += nameChar[i];       
             }       
         }       
        return pinyinName;       
     }       
        
    /**   
     * 汉字转换位汉语拼音，英文字符不变   
     * @param chines 汉字   
     * @return 拼音   
     */     
    public static String converterToSpell(String chines){               
        String pinyinName = "";       
        char[] nameChar = chines.toCharArray();       
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();       
        defaultFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);       
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);       
        for (int i = 0; i < nameChar.length; i++) {       
            if (nameChar[i] > 128) {       
                try {       
                     pinyinName += PinyinHelper.toHanyuPinyinStringArray(nameChar[i], defaultFormat)[0];       
                 } catch (BadHanyuPinyinOutputFormatCombination e) {       
                     e.printStackTrace();       
                 }       
             }else{       
                 pinyinName += nameChar[i];       
             }       
         }       
        return pinyinName;       
     }       
           
    public static void main(String[] args) {       
        System.out.println(converterToFirstSpell("虎"));
    	
        //System.out.println(converterToSpell("娆ч槼閿�"));
    	//System.out.println(converterToFirstSpell("娆ч槼閿�"));
     }       
}
