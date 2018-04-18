package org.parallelchen.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//ת�����ڵĹ�����
public class formatUtil {
	
	/**
	 * �ַ���ת��Ϊ��������
	 * @param str ������ַ��� 2018-05-06
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
	 * ��Stringת��Ϊint����
	 * @param str
	 * @return
	 */
	public static int string2Int(String str) {
		
		int i = Integer.parseInt(str);
		
		return i ;
	}

}
