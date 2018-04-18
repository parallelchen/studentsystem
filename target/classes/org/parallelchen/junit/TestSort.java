package org.parallelchen.junit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;
import org.parallelchen.dao.impl.StudentDaoImpl;
import org.parallelchen.entity.Student;

/**
 * 排序测试类:以平均分数由小到大排序
 * @author parallelchen
 *
 */
public class TestSort {
	
	
	@Test
	public void testSort() {
		
		List<Student> list = new ArrayList<Student>();
		
		//获取所有数据
		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
		List<Student> students = studentDaoImpl.findAll();
		
		Collections.sort(students, new Comparator<Student>() {

			public int compare(Student o1,Student o2) {
				int i = o1.getAvgscore() - o2.getAvgscore();
				if(i == 0) {
					return o1.getId().hashCode() - o2.getId().hashCode();
				}
				
				return i;
			}
		});
		for(Student stu : students) {
			System.out.println("scor:" + stu.getAvgscore());
		}
		
	}

}
