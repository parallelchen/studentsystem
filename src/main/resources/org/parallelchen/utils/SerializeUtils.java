package org.parallelchen.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;

/**
 * ���л��뷴���л�������
 * @author parallelchen
 *
 */
public class SerializeUtils {
	/**
	 * �������л�
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
			//���Բ����ڴ滺���������ݣ�ת�����ֽ�����
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			//�������������
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(obj);
			bytes = baos.toByteArray();
			//�ر�ͨ��
			baos.close();
			oos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return bytes ;
	}
	/**
	 * �������л�
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
