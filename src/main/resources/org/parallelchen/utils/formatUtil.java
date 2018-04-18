package org.parallelchen.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//转换日期的工具类
public class formatUtil {
	
	/**
	 * 字符串转换为日期类型
	 * @param str 传入的字符串 2018-05-06
	 * @return
	 */
	public static Date string2Date(String str) {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = null ;
		try {
			
			date = dateFormat.parse(str);
						
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date ;
	}
	
	/**
	 * 将String转换为int类型
	 * @param str
	 * @return
	 */
	public static int string2Int(String str) {
		
		int i = Integer.parseInt(str);
		
		return i ;
	}

}
