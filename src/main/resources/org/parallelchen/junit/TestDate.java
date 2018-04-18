package org.parallelchen.junit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.parallelchen.utils.formatUtil;

public class TestDate {
	
	@Test
	public void testDate() {
		
		String bir = "2018-10-09" ;
		
		String s = "大";
		//日期处理
		
	//	Boolean b = bir.matches("(0[1-9]|1[0-2])-(0[1-9]|1[0-9]|2[0-8])");
		Boolean b = bir.matches("^(?:(?!0000)[0-9]{4}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])-(?:29|30)|(?:0[13578]|1[02])-31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)-02-29)$");
		Boolean z = s.matches("^(?:(?!0000)[0-9]{4}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])-(?:29|30)|(?:0[13578]|1[02])-31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)-02-29)$");
		
		System.out.println(b);
		System.out.println(z);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = null ;
		try {
			
			date = dateFormat.parse(bir);
			
			System.out.println(date.toLocaleString().split(" ")[0]);			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testInt() {
		
		String score = "500" ;
		
		int score1 = formatUtil.string2Int(score);
		System.out.println(score1);
	}

}
