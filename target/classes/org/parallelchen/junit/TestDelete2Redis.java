package org.parallelchen.junit;

import org.junit.Test;
import org.parallelchen.utils.JedisUtil;

import redis.clients.jedis.Jedis;

/**
 * 测试删除方法
 * @author parallelchen
 *
 */
public class TestDelete2Redis {
	
	@Test
	public void testDelete2Redis() {
		
		//获取到Redis的连接
		Jedis jedis = JedisUtil.getJedis();
		
		String key = "02a4b287-3fd4-474c-b03d-25dab673e9ea";
		
		//从数据库当中获取到指定key
		//jedis.get()
		
		//删除指定KEY数据
		jedis.del(key);
		
		
		
	}

}
