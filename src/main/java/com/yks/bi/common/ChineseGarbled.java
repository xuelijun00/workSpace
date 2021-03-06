package com.yks.bi.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
 * 验证字符是否是中文，并转码
 * spring 默认字符集 ISO8859-1
 * @author Administrator
 *
 */
public class ChineseGarbled {
	
	private static boolean isChinese(char c) {  
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);  
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS  
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS  
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A  
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION  
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION  
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {  
            return true;  
        }  
        return false;  
    }  
    
	/*
	  判断中文是否乱码
    */
    public static boolean isMessyCode(String strName) {  
        Pattern p = Pattern.compile("\\s*|\t*|\r*|\n*");  
        Matcher m = p.matcher(strName);  
        String after = m.replaceAll("");  
        String temp = after.replaceAll("\\p{P}", "");  
        char[] ch = temp.trim().toCharArray();  
        float chLength = 0 ;  
        float count = 0;  
        for (int i = 0; i < ch.length; i++) {  
            char c = ch[i];  
            if (!Character.isLetterOrDigit(c)) {  
                if (!isChinese(c)) {  
                    count = count + 1;  
                }  
                chLength++;   
            }  
        }  
        float result = count / chLength ;  
        if (result > 0.4) {  
            return true;  
        } else {  
            return false;  
        }  
    }  
      
    public static String toChinese(Object msg){  
        String tempMsg = msg.toString() ;  
        if(isMessyCode(tempMsg)){  
            try {return new String(tempMsg.getBytes("ISO8859-1"), "UTF-8");} catch (Exception e) {}  //String的getBytes()方法是得到一个系统默认的编码格式的字节数组 getBytes("utf-8")  得到一个UTF-8格式的字节数组


        }  
        return tempMsg ;   
    } 
    
    public static String chineseGarbled(String param){
    	if(StringUtils.isNotEmpty(param) && isMessyCode(param)){
    		return toChinese(param);
    	}else{
    		return param;
    	}
    }
    
    public static void main(String[] a){
    	String s = "éé¹";
    	System.out.println();
    	System.out.println(toChinese(s));
    }

}
