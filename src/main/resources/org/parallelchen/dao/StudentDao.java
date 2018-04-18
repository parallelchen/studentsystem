package org.parallelchen.dao;

import java.util.List;

import org.parallelchen.entity.PageBean;
import org.parallelchen.entity.Student;

/**
 * 
 * 学生信息系统的DAO接口
 * @author parallelchen
 *
 */
public interface StudentDao {
	
	//1.添加学生信息
	public void addStudentInfo(Student student);
	//2.修改学生信息
	public void updateStudentInfo(String id ,Student student);
	//3.删除学生信息
	public void deleteStudentInfo(String id);
	//4.查询所有学生信息
	public List<Student> findAll();
	//5.根据ID查询指定学生信息
	public Student findById(String id);
	//6.排序
	public List<Student> sortByAvgscore();
	//7.分页查询
	public void getAll(PageBean<Student> pb);
	//8.查询总记录数
	public int getTotalCount();
	

}
