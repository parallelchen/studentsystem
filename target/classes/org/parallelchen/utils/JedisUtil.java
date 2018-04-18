package org.parallelchen.utils;

import redis.clients.jedis.Jedis;

//Jedis工具类
public class JedisUtil {
	
	
	/**
	 * @author parallelchen
	 * @return jedis 返回连接指定数据库的对象
	 */
	public static Jedis getJedis() {
		
		//1.实例化一个jedis对象，连接到指定服务器，指定端口。
	//	Jedis jedis = new Jedis("127.0.0.1",6379);
	//	Jedis jedis = new Jedis("localhost",6379);
		Jedis jedis = new Jedis("106.15.186.162",6379);
		jedis.auth("chenming");
		
		return jedis ;
	}
	
	public static void closeJedis() {
		
		//2.关闭连接。
		getJedis().close();
	}
	
}
