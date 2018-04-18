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
	 * 添加学生信息
	 */
	public void addStudentInfo(Student student) {
		
		//1.获取Jedis的数据库连接
		Jedis jedis = JedisUtil.getJedis();
	
		//2.序列化Stu对象并放入Redis数据库
		jedis.set(student.getId().getBytes(), SerializeUtils.serialize(student));
		
	}
	/**
	 * 修改学生信息
	 */
	public void updateStudentInfo(String id ,Student student) {
		
		Jedis jedis = JedisUtil.getJedis();
		
		
		jedis.set(id.getBytes(), SerializeUtils.serialize(student));
		
		
	}
	/**
	 * 删除学生信息
	 */
	public void deleteStudentInfo(String id) {
		

		//获取到数据库的连接
		Jedis jedis = JedisUtil.getJedis();
		
		//判断该id在数据库中是否存在
		
		//查找出所有的id(key)
		Set<String> s = jedis.keys("*");
		
		
		if(s.contains(id)) {
			//id存在
			jedis.del(id);
				
		}else {
			//id不存在,跳入错误页面
			System.out.println("没有该条数据");
		}
		
		
	}
	/**
	 * 查询所有学生信息
	 */
	@SuppressWarnings("rawtypes")
	public List<Student> findAll() {
		
		//创建List集合
		List<Student> list = new ArrayList<Student>();
		
		//获取Redis连接
		Jedis jedis = JedisUtil.getJedis();
		//根据key获取数据
		//获取所有的key
		Set s =jedis.keys("*");
		
		/*if(s.isEmpty()) {
			
			
		}*/
		
		//迭代
		Iterator it = s.iterator();
		
		
		while(it.hasNext()) {
			String key =(String) it.next();
			byte[] bytes = jedis.get(key.getBytes());
			//反序列化并放入集合
			list.add((Student)SerializeUtils.deSerialize(bytes));
			
		}
		
		return list;
	}
	/**
	 * 根据ID查询指定学生信息
	 */
	public Student findById(String id) {
		
		//获取数据库连接
		Jedis jedis = JedisUtil.getJedis();
		
		List<Student> list = new ArrayList<Student>();
						
		Set<String> set = jedis.keys(id);
		
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			String key =(String) it.next();
			byte[] bytes = jedis.get(key.getBytes());
			//反序列化并放入集合
			list.add((Student)SerializeUtils.deSerialize(bytes));
		
		//反序列化
		
		}
		
		Student student = list.get(0);
				
		
		return student;
	}

	//分页查询
	@SuppressWarnings({ "unused" })
	public void getAll(PageBean<Student> page) {
		
		//查询记录总数设置到pb中
		int totalCount = this.getTotalCount();
		page.setTotalCount(totalCount);
		
		//查出来的List数据
		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
		List<Student> list = studentDaoImpl.sortByAvgscore();
		
		//判断，如果当前页面<=0，设置当前页面为1
		//如果当前页>最大页数，把当前页设置为最大页数
		if(page.getCurrentPage() <= 0) {
			page.setCurrentPage(1);
		}else if (page.getCurrentPage() > page.getToalPage()) {
			page.setCurrentPage(page.getToalPage());
		}
		

		//获取当前页面，计算查询的起始行，返回的行数
		int currentPage = page.getCurrentPage();
		//每页的开始数
		page.setStar((page.getCurrentPage() - 1) * page.getPageCount());
		//对list进行截取
		if(list.size() > 0) {
			page.setPageDate(list.subList(page.getStar(), totalCount-page.getStar()>page.getPageCount()?page.getStar()+page.getPageCount():totalCount));
		}
	}
	
	/**
	 * 平均分由小到大排序
	 */
	public List<Student> sortByAvgscore() {
		
		List<Student> list = new ArrayList<Student>();
		
		//获取所有数据
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
