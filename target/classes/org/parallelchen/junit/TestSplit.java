package org.parallelchen.junit;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 测试集合分组
 * @author parallelchen
 *
 */
public class TestSplit {
	
	@Test
	public void testSplit() {
		
		List<String> list = new ArrayList<String>();
		list.add("aaaa");
		list.add("bbbb");
		list.add("cccc");
		list.add("dddd");
		list.add("eeee");
		list.add("ffff");
		list.add("gggg");
		list.add("hhhh");
		list.add("iiii");
		
		ArrayList<String> arrayList = new ArrayList<String>();
		//循环分组
		for(int i = 0 ; i < list.size() ; i+=5) {
			arrayList.add(list.get(i));
		}
		for(String s : arrayList) {
			System.out.println(s);
		}
		
		
	}

}
