package org.parallelchen.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.parallelchen.dao.impl.StudentDaoImpl;
import org.parallelchen.entity.Student;
import org.parallelchen.utils.SerializeUtils;
import org.parallelchen.utils.formatUtil;


public class UpdateStudentInfoServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		//����JSPҳ���ȡ�ĸ������ݷ���Redis���ݿ���
		String name = request.getParameter("name");
		String bir = request.getParameter("birthday");
		String description = request.getParameter("description");
		String score = request.getParameter("avgscore");
		String id = request.getParameter("id");
		
		//��scoreת��Ϊint
		int avgscore = formatUtil.string2Int(score);
		
		//��birthdayת����
		Date birthday =formatUtil.string2Date(bir);
		
		//�����ݷ�װ�ڶ�����
		Student student = new Student(id, name, birthday, description, avgscore);
		
		//���ø��µķ���
		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
		studentDaoImpl.updateStudentInfo(id, student);
		
		
		//��ת����ҳ
		//response.sendRedirect("/FindAllServlet");
		request.getRequestDispatcher("/FindAllServlet").forward(request, response);
	}

	

}
