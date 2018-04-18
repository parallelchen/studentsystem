package org.parallelchen.dao;

import java.util.List;

import org.parallelchen.entity.PageBean;
import org.parallelchen.entity.Student;

/**
 * 
 * ѧ����Ϣϵͳ��DAO�ӿ�
 * @author parallelchen
 *
 */
public interface StudentDao {
	
	//1.���ѧ����Ϣ
	public void addStudentInfo(Student student);
	//2.�޸�ѧ����Ϣ
	public void updateStudentInfo(String id ,Student student);
	//3.ɾ��ѧ����Ϣ
	public void deleteStudentInfo(String id);
	//4.��ѯ����ѧ����Ϣ
	public List<Student> findAll();
	//5.����ID��ѯָ��ѧ����Ϣ
	public Student findById(String id);
	//6.����
	public List<Student> sortByAvgscore();
	//7.��ҳ��ѯ
	public void getAll(PageBean<Student> pb);
	//8.��ѯ�ܼ�¼��
	public int getTotalCount();
	

}
