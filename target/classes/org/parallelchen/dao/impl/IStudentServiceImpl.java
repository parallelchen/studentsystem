package org.parallelchen.dao.impl;

import org.parallelchen.entity.PageBean;
import org.parallelchen.entity.Student;
import org.parallelchen.service.IStudentService;

public class IStudentServiceImpl implements IStudentService {
	
	StudentDaoImpl studentDaoImpl = new StudentDaoImpl();

	public void getAll(PageBean<Student> page) {
		
		try {
			studentDaoImpl.getAll(page);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

}
