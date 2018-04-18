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
 * ���Ը���id��ѯ����
 * @author parallelchen
 *
 */
public class TestQueryById {

	@Test
	public void testQueryById() {
		
		//��ȡ���ݿ�����
		Jedis jedis = JedisUtil.getJedis();
		
		List<Student> list = new ArrayList<Student>();
		
		//����Id��ѯ
		String id = "11b5fc40-d7b5-4231-8856-4421dece88e7";
		
		Set<String> set = jedis.keys(id);
		
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			String key =(String) it.next();
			byte[] bytes = jedis.get(key.getBytes());
			//�����л������뼯��
			list.add((Student)SerializeUtils.deSerialize(bytes));
		
		//�����л�
		
		}
		
		Student stu = list.get(0);
		System.out.println(stu);
		
		
	}
}
