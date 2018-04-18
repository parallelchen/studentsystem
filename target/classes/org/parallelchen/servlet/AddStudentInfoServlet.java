package org.parallelchen.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.parallelchen.dao.impl.StudentDaoImpl;
import org.parallelchen.entity.Student;
import org.parallelchen.utils.JedisUtil;
import org.parallelchen.utils.SerializeUtils;
import org.parallelchen.utils.formatUtil;

import redis.clients.jedis.Jedis;

/**
 * Servlet implementation class AddInfoServlet
 */
public class AddStudentInfoServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//��JSPҳ���ȡ����
		
	//	Jedis jedis = JedisUtil.getJedis();
		
		//���ñ���
		request.setCharacterEncoding("utf-8");
		
		//�õ�Session����
	//	HttpSession session = request.getSession();
		
		//��ϵͳ�Զ����������Ψһ��IDֵ����ֵ���������Ķ���
		String uuid = UUID.randomUUID().toString();
		
		String name1 = request.getParameter("name");
		
		//���ڴ���
		String bir = request.getParameter("birthday");
		Date date = formatUtil.string2Date(bir);
		
		//ƽ���ִ���
		String parameter = request.getParameter("avgscore");
		int avgscore = formatUtil.string2Int(parameter);
		
		//����student����,����������
		Student student = new Student(uuid,request.getParameter("name"),date,request.getParameter("description"),avgscore);
		
		//����������ݵķ���
		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
	    studentDaoImpl.addStudentInfo(student);
	    
	    //�ر�����
	    JedisUtil.closeJedis();
		

	   /* byte[] bytes = jedis.get(student.getId().getBytes());
	    System.out.println((Student)SerializeUtils.deSerialize(bytes));
	    System.out.println("aaaaa");*/
		request.getRequestDispatcher("/FindAllServlet").forward(request, response);
	 //   response.sendRedirect("/FindAllServlet");
	}

	
	

}
