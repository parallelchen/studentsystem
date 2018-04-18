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
 * ���Ը��·���
 * @author parallelchen
 *
 */
public class TestUpdate2Redis {
	
	@Test
	public void testUpdate2Redis() {
		
		Jedis jedis = JedisUtil.getJedis();
		
		//ȡ����ͬ��ID
		String id = "11b5fc40-d7b5-4231-8856-4421dece88e7" ;
		
		//��������ֵ
		String name = "���" ;
		Date birthday = new Date();
		String description = "��������" ;
		int avgscore = 50 ;
		
		//��������
		Student student = new Student(id, name, birthday, description, avgscore);
		
		//���л�����
//		byte[] bs = SerializeUtils.serialize(student);
		//����Redis
		jedis.set(id.getBytes(), SerializeUtils.serialize(student));
		
		//��ѯ
		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
		Student stu = studentDaoImpl.findById(id);
		System.out.println(stu);
		
	}
}
