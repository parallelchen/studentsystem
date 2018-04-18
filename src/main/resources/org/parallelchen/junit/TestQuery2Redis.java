package org.parallelchen.junit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.parallelchen.entity.Student;
import org.parallelchen.utils.JedisUtil;
import org.parallelchen.utils.SerializeUtils;

import redis.clients.jedis.Jedis;

/**
 * ���Դ�Redis��ȡ����
 * @author parallelchen
 *
 */
public class TestQuery2Redis {

	@Test
	public void testQuery2Redis() {
		
		List<Student> list = new ArrayList<Student>();
		
		//��ȡRedis����
		Jedis jedis = JedisUtil.getJedis();
		//����key��ȡ����
		Set s =jedis.keys("*");
		
		//����
		Iterator it = s.iterator();
		
		while(it.hasNext()) {
			String key =(String) it.next();
			byte[] bytes = jedis.get(key.getBytes());
		//	System.out.println((Student)SerializeUtils.deSerialize(bytes));
			list.add((Student)SerializeUtils.deSerialize(bytes));
			
		}
		
		int j = list.size();
		
		for(int i = 0 ; i < list.size() ; i++) {
			Student student = list.get(i);
			System.out.println(student);
		}
		
		
	}
}
