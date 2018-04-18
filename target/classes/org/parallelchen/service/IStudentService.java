package org.parallelchen.service;

import org.parallelchen.entity.PageBean;
import org.parallelchen.entity.Student;

public interface IStudentService {
	
	/**
	 * ∑÷“≥≤È—Ø
	 */
	
	public void getAll(PageBean<Student> page);

}
