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
		
		
		//将根据Id查询到的数据显示到updateStudentInfo.jsp页面
		
		//获取从页面传过来的数据id
		String id = request.getParameter("id");
		
		//从数据库中取得该条数据
		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
		Student student = studentDaoImpl.findById(id);
		
		//将这条数据查询出来放在session中
		HttpSession session = request.getSession();
		
		session.setAttribute("student", student);
		
		Date date = student.getBirthday();
		//格式化日期
	    StringBuilder sb = new StringBuilder();  
	    sb.append("yyyy年MM月dd日") ;
		SimpleDateFormat dateFormat = new SimpleDateFormat(sb.toString());
		
		String s = dateFormat.format(date);
				
		session.setAttribute("date", s);
		//把id放入session
		session.setAttribute("id", id);
				
		request.getRequestDispatcher("updateStudentInfo.jsp").forward(request, response);
	}

	
	

}
