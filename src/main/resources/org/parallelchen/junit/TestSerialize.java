package org.parallelchen.junit;
/**
 * 序列化测试类
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
		
		
		
		//1.获取Redis数据库连接
		Jedis jedis = JedisUtil.getJedis();
		
		Student student = new Student("1","小明",new Date(),"学生干部",450);
	//	Student student = new Student("1","小明","三好学生");
		jedis.set(student.getId().getBytes(),SerializeUtils.serialize(student));
		
		byte[] bytes = jedis.get(student.getId().getBytes());
		System.out.println((Student)SerializeUtils.deSerialize(bytes));
	}
	
}
