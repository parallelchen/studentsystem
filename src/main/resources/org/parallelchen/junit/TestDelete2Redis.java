package org.parallelchen.junit;

import org.junit.Test;
import org.parallelchen.utils.JedisUtil;

import redis.clients.jedis.Jedis;

/**
 * ����ɾ������
 * @author parallelchen
 *
 */
public class TestDelete2Redis {
	
	@Test
	public void testDelete2Redis() {
		
		//��ȡ��Redis������
		Jedis jedis = JedisUtil.getJedis();
		
		String key = "02a4b287-3fd4-474c-b03d-25dab673e9ea";
		
		//�����ݿ⵱�л�ȡ��ָ��key
		//jedis.get()
		
		//ɾ��ָ��KEY����
		jedis.del(key);
		
		
		
	}

}
