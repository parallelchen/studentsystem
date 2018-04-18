package org.parallelchen.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;

/**
 * 序列化与反序列化工具类
 * @author parallelchen
 *
 */
public class SerializeUtils {
	/**
	 * 对象序列化
	 * @param obj
	 * @return
	 */
	public static byte[] serialize(Object obj) {
		
		byte[] bytes = null ;
		/*
		Set<String> set = new HashSet<String>();  
        set.add("11111");  
        set.add("22222"); 
		*/
		try {
			//可以捕获内存缓冲区的数据，转换成字节数组
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			//创建对象输出流
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(obj);
			bytes = baos.toByteArray();
			//关闭通道
			baos.close();
			oos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return bytes ;
	}
	/**
	 * 对象反序列化
	 * @param bytes
	 * @return
	 */
	public static Object deSerialize(byte[] bytes) {
		
		Object obj = null ;
		
		try {
			ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
			ObjectInputStream ois = new ObjectInputStream(bais);
			
			obj = ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return obj ;
	}

}
