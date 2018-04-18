package org.parallelchen.junit;
/**
 * ���л�������
 * @author parallelchen
 *
 */

import java.util.Date;

import org.junit.Test;
import org.parallelchen.entity.Student;
import org.parallelchen.utils.JedisUtil;
import org.parallelchen.utils.SerializeUtils;

import redis.clients.jedis.Jedis;

public class TestSerialize {

	
	@Test
	public void testSerialize() {
		
		
		
		//1.��ȡRedis���ݿ�����
		Jedis jedis = JedisUtil.getJedis();
		
		Student student = new Student("1","С��",new Date(),"ѧ���ɲ�",450);
	//	Student student = new Student("1","С��","����ѧ��");
		jedis.set(student.getId().getBytes(),SerializeUtils.serialize(student));
		
		byte[] bytes = jedis.get(student.getId().getBytes());
		System.out.println((Student)SerializeUtils.deSerialize(bytes));
	}
	
}
