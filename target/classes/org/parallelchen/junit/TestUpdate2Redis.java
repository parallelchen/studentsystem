package org.parallelchen.junit;

import java.util.Date;

import org.junit.Test;
import org.parallelchen.dao.impl.StudentDaoImpl;
import org.parallelchen.entity.Student;
import org.parallelchen.utils.JedisUtil;
import org.parallelchen.utils.SerializeUtils;
import org.parallelchen.utils.formatUtil;

import redis.clients.jedis.Jedis;

/**
 * 测试跟新方法
 * @author parallelchen
 *
 */
public class TestUpdate2Redis {
	
	@Test
	public void testUpdate2Redis() {
		
		Jedis jedis = JedisUtil.getJedis();
		
		//取得相同的ID
		String id = "11b5fc40-d7b5-4231-8856-4421dece88e7" ;
		
		//设置其它值
		String name = "李二" ;
		Date birthday = new Date();
		String description = "啊啊啊啊" ;
		int avgscore = 50 ;
		
		//创建对象
		Student student = new Student(id, name, birthday, description, avgscore);
		
		//序列化对象
//		byte[] bs = SerializeUtils.serialize(student);
		//放入Redis
		jedis.set(id.getBytes(), SerializeUtils.serialize(student));
		
		//查询
		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
		Student stu = studentDaoImpl.findById(id);
		System.out.println(stu);
		
	}
}
