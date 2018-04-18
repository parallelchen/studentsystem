package org.parallelchen.junit;

import java.util.Date;

import org.junit.Test;
import org.parallelchen.dao.StudentDao;
import org.parallelchen.dao.impl.StudentDaoImpl;
import org.parallelchen.entity.Student;
import org.parallelchen.utils.JedisUtil;

import redis.clients.jedis.Jedis;

/**
 * ����Jedis����
 * @author parallelchen
 *
 */

public class TestJedis {
	
	StudentDao operator = null ;
	
	public void init() {
		
		operator = new StudentDaoImpl();
		
	}
	
	
	
	//�������ݿ�����
	@Test
	public void testJedis() {
		
		Jedis jedis = JedisUtil.getJedis();
		
		//��keyΪmessage����Ϣд��redis���ݿ���
		jedis.set("message", "Hello Redis");
		//�����ݿ���ȡ��keyΪmessage������
		String value = jedis.get("message");
		System.out.println(value);
		
		//�ر�����
		jedis.close();
		
		
	}
	
	@Test
	public void testAddStudentInfo() {
		
		
		
		Student stu = new Student();
		
		stu.setId("1");
		stu.setName("lili");
		stu.setBirthday(new Date());
		stu.setDescription("����ѧ��");
		stu.setAvgscore(50);
		
		
		
	}

}
