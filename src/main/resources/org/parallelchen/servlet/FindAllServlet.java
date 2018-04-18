package org.parallelchen.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.parallelchen.dao.impl.IStudentServiceImpl;
import org.parallelchen.dao.impl.StudentDaoImpl;
import org.parallelchen.entity.PageBean;
import org.parallelchen.entity.Student;
import org.parallelchen.service.IStudentService;

public class FindAllServlet extends HttpServlet {
	
	//创建Service实例
	private IStudentService studentService = new IStudentServiceImpl();
	//跳转资源
	private String uri ;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			StudentDaoImpl daoImpl = new StudentDaoImpl();
			List<Student> findAll = daoImpl.findAll();
			
			/*if(findAll.isEmpty()) {
				
				request.getRequestDispatcher("/addStudentInfo.jsp").forward(request, response);
				
			}*/
			//获取当前页参数，第一次访问，当前页为空	
			String currPage = request.getParameter("currentPage");
			//判断
			if(currPage == null || "".equals(currPage.trim())){
				currPage = "1" ; //第一次访问，设置当前页为1
				
			}
			//转换
			int currentPage = Integer.parseInt(currPage);
			
			//创建pagebean对象，设置当前页参数，传入service方法参数
			PageBean<Student> pageBean = new PageBean<Student>();
			pageBean.setCurrentPage(currentPage);
			
			//调用service
			studentService.getAll(pageBean);
			
			HttpSession session = request.getSession();
			
			//保存pageBean对象到域中
			session.setAttribute("pageBean", pageBean);
			//跳转
			uri = "studentSystem.jsp";
		} catch (Exception e) {
			//出现错误，跳转错误页面
			uri = "/error/error.jsp";
		}
			RequestDispatcher dr = request.getRequestDispatcher(uri);
		try {
			
			dr.forward(request, response);
			return ;
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
