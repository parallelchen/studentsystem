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
		
		//从JSP页面获取数据
		
	//	Jedis jedis = JedisUtil.getJedis();
		
		//设置编码
		request.setCharacterEncoding("utf-8");
		
		//得到Session对象
	//	HttpSession session = request.getSession();
		
		//由系统自动生成随机且唯一的ID值，赋值给传过来的对象
		String uuid = UUID.randomUUID().toString();
		
		String name1 = request.getParameter("name");
		
		//日期处理
		String bir = request.getParameter("birthday");
		Date date = formatUtil.string2Date(bir);
		
		//平均分处理
		String parameter = request.getParameter("avgscore");
		int avgscore = formatUtil.string2Int(parameter);
		
		//创建student对象,并传入数据
		Student student = new Student(uuid,request.getParameter("name"),date,request.getParameter("description"),avgscore);
		
		//调用添加数据的方法
		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
	    studentDaoImpl.addStudentInfo(student);
	    
	    //关闭连接
	    JedisUtil.closeJedis();
		

	   /* byte[] bytes = jedis.get(student.getId().getBytes());
	    System.out.println((Student)SerializeUtils.deSerialize(bytes));
	    System.out.println("aaaaa");*/
		request.getRequestDispatcher("/FindAllServlet").forward(request, response);
	 //   response.sendRedirect("/FindAllServlet");
	}

	
	

}
