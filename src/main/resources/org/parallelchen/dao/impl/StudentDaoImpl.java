package org.parallelchen.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.parallelchen.dao.StudentDao;
import org.parallelchen.entity.PageBean;
import org.parallelchen.entity.Student;
import org.parallelchen.utils.JedisUtil;
import org.parallelchen.utils.SerializeUtils;

import redis.clients.jedis.Jedis;

public class StudentDaoImpl implements StudentDao{

	/**
	 * ���ѧ����Ϣ
	 */
	public void addStudentInfo(Student student) {
		
		//1.��ȡJedis�����ݿ�����
		Jedis jedis = JedisUtil.getJedis();
	
		//2.���л�Stu���󲢷���Redis���ݿ�
		jedis.set(student.getId().getBytes(), SerializeUtils.serialize(student));
		
	}
	/**
	 * �޸�ѧ����Ϣ
	 */
	public void updateStudentInfo(String id ,Student student) {
		
		Jedis jedis = JedisUtil.getJedis();
		
		
		jedis.set(id.getBytes(), SerializeUtils.serialize(student));
		
		
	}
	/**
	 * ɾ��ѧ����Ϣ
	 */
	public void deleteStudentInfo(String id) {
		

		//��ȡ�����ݿ������
		Jedis jedis = JedisUtil.getJedis();
		
		//�жϸ�id�����ݿ����Ƿ����
		
		//���ҳ����е�id(key)
		Set<String> s = jedis.keys("*");
		
		
		if(s.contains(id)) {
			//id����
			jedis.del(id);
				
		}else {
			//id������,�������ҳ��
			System.out.println("û�и�������");
		}
		
		
	}
	/**
	 * ��ѯ����ѧ����Ϣ
	 */
	@SuppressWarnings("rawtypes")
	public List<Student> findAll() {
		
		//����List����
		List<Student> list = new ArrayList<Student>();
		
		//��ȡRedis����
		Jedis jedis = JedisUtil.getJedis();
		//����key��ȡ����
		//��ȡ���е�key
		Set s =jedis.keys("*");
		
		/*if(s.isEmpty()) {
			
			
		}*/
		
		//����
		Iterator it = s.iterator();
		
		
		while(it.hasNext()) {
			String key =(String) it.next();
			byte[] bytes = jedis.get(key.getBytes());
			//�����л������뼯��
			list.add((Student)SerializeUtils.deSerialize(bytes));
			
		}
		
		return list;
	}
	/**
	 * ����ID��ѯָ��ѧ����Ϣ
	 */
	public Student findById(String id) {
		
		//��ȡ���ݿ�����
		Jedis jedis = JedisUtil.getJedis();
		
		List<Student> list = new ArrayList<Student>();
						
		Set<String> set = jedis.keys(id);
		
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			String key =(String) it.next();
			byte[] bytes = jedis.get(key.getBytes());
			//�����л������뼯��
			list.add((Student)SerializeUtils.deSerialize(bytes));
		
		//�����л�
		
		}
		
		Student student = list.get(0);
				
		
		return student;
	}

	//��ҳ��ѯ
	@SuppressWarnings({ "unused" })
	public void getAll(PageBean<Student> page) {
		
		//��ѯ��¼�������õ�pb��
		int totalCount = this.getTotalCount();
		page.setTotalCount(totalCount);
		
		//�������List����
		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
		List<Student> list = studentDaoImpl.sortByAvgscore();
		
		//�жϣ������ǰҳ��<=0�����õ�ǰҳ��Ϊ1
		//�����ǰҳ>���ҳ�����ѵ�ǰҳ����Ϊ���ҳ��
		if(page.getCurrentPage() <= 0) {
			page.setCurrentPage(1);
		}else if (page.getCurrentPage() > page.getToalPage()) {
			page.setCurrentPage(page.getToalPage());
		}
		

		//��ȡ��ǰҳ�棬�����ѯ����ʼ�У����ص�����
		int currentPage = page.getCurrentPage();
		//ÿҳ�Ŀ�ʼ��
		page.setStar((page.getCurrentPage() - 1) * page.getPageCount());
		//��list���н�ȡ
		if(list.size() > 0) {
			page.setPageDate(list.subList(page.getStar(), totalCount-page.getStar()>page.getPageCount()?page.getStar()+page.getPageCount():totalCount));
		}
	}
	
	/**
	 * ƽ������С��������
	 */
	public List<Student> sortByAvgscore() {
		
		List<Student> list = new ArrayList<Student>();
		
		//��ȡ��������
		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
		List<Student> students = studentDaoImpl.findAll();
		if(students.size() > 0) {
			Collections.sort(students, new Comparator<Student>() {

				
				public int compare(Student o1,Student o2) {
					int i = o1.getAvgscore() - o2.getAvgscore();
					if(i == 0) {
						return o1.getId().hashCode() - o2.getId().hashCode();
					}
					
					return i;
				}
			});
			
			
		}
		
		
		
		return students ;
	}
	
	public int getTotalCount() {
		List<Student> list = this.findAll();
		int count = list.size();
		return count;
	}
		

}
