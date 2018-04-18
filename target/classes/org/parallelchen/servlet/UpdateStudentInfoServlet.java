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
		
		//将从JSP页面获取的跟新数据放入Redis数据库中
		String name = request.getParameter("name");
		String bir = request.getParameter("birthday");
		String description = request.getParameter("description");
		String score = request.getParameter("avgscore");
		String id = request.getParameter("id");
		
		//将score转换为int
		int avgscore = formatUtil.string2Int(score);
		
		//将birthday转日期
		Date birthday =formatUtil.string2Date(bir);
		
		//将数据封装在对象里
		Student student = new Student(id, name, birthday, description, avgscore);
		
		//调用跟新的方法
		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
		studentDaoImpl.updateStudentInfo(id, student);
		
		
		//跳转到首页
		//response.sendRedirect("/FindAllServlet");
		request.getRequestDispatcher("/FindAllServlet").forward(request, response);
	}

	

}
