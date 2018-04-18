package org.parallelchen.junit;

import java.util.Date;

import org.junit.Test;
import org.parallelchen.dao.StudentDao;
import org.parallelchen.dao.impl.StudentDaoImpl;
import org.parallelchen.entity.Student;
import org.parallelchen.utils.JedisUtil;

import redis.clients.jedis.Jedis;

/**
 * 测试Jedis连接
 * @author parallelchen
 *
 */

public class TestJedis {
	
	StudentDao operator = null ;
	
	public void init() {
		
		operator = new StudentDaoImpl();
		
	}
	
	
	
	//测试数据库连接
	@Test
	public void testJedis() {
		
		Jedis jedis = JedisUtil.getJedis();
		
		//将key为message的信息写入redis数据库中
		jedis.set("message", "Hello Redis");
		//从数据库中取出key为message的数据
		String value = jedis.get("message");
		System.out.println(value);
		
		//关闭连接
		jedis.close();
		
		
	}
	
	@Test
	public void testAddStudentInfo() {
		
		
		
		Student stu = new Student();
		
		stu.setId("1");
		stu.setName("lili");
		stu.setBirthday(new Date());
		stu.setDescription("三好学生");
		stu.setAvgscore(50);
		
		
		
	}

}
