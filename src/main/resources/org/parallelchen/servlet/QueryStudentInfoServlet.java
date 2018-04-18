package org.parallelchen.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.parallelchen.dao.impl.StudentDaoImpl;
import org.parallelchen.entity.Student;
import org.parallelchen.utils.JedisUtil;

import redis.clients.jedis.Jedis;


public class QueryStudentInfoServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//������Id��ѯ����������ʾ��updateStudentInfo.jspҳ��
		
		//��ȡ��ҳ�洫����������id
		String id = request.getParameter("id");
		
		//�����ݿ���ȡ�ø�������
		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
		Student student = studentDaoImpl.findById(id);
		
		//���������ݲ�ѯ��������session��
		HttpSession session = request.getSession();
		
		session.setAttribute("student", student);
		
		Date date = student.getBirthday();
		//��ʽ������
	    StringBuilder sb = new StringBuilder();  
	    sb.append("yyyy��MM��dd��") ;
		SimpleDateFormat dateFormat = new SimpleDateFormat(sb.toString());
		
		String s = dateFormat.format(date);
				
		session.setAttribute("date", s);
		//��id����session
		session.setAttribute("id", id);
				
		request.getRequestDispatcher("updateStudentInfo.jsp").forward(request, response);
	}

	
	

}
