package org.parallelchen.utils;

import redis.clients.jedis.Jedis;

//Jedis������
public class JedisUtil {
	
	
	/**
	 * @author parallelchen
	 * @return jedis ��������ָ�����ݿ�Ķ���
	 */
	public static Jedis getJedis() {
		
		//1.ʵ����һ��jedis�������ӵ�ָ����������ָ���˿ڡ�
	//	Jedis jedis = new Jedis("127.0.0.1",6379);
	//	Jedis jedis = new Jedis("localhost",6379);
		Jedis jedis = new Jedis("106.15.186.162",6379);
		jedis.auth("chenming");
		
		return jedis ;
	}
	
	public static void closeJedis() {
		
		//2.�ر����ӡ�
		getJedis().close();
	}
	
}
