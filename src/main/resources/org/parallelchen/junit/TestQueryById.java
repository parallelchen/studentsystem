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
 * 测试根据id查询数据
 * @author parallelchen
 *
 */
public class TestQueryById {

	@Test
	public void testQueryById() {
		
		//获取数据库连接
		Jedis jedis = JedisUtil.getJedis();
		
		List<Student> list = new ArrayList<Student>();
		
		//根据Id查询
		String id = "11b5fc40-d7b5-4231-8856-4421dece88e7";
		
		Set<String> set = jedis.keys(id);
		
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			String key =(String) it.next();
			byte[] bytes = jedis.get(key.getBytes());
			//反序列化并放入集合
			list.add((Student)SerializeUtils.deSerialize(bytes));
		
		//反序列化
		
		}
		
		Student stu = list.get(0);
		System.out.println(stu);
		
		
	}
}
