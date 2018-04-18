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
	
	//����Serviceʵ��
	private IStudentService studentService = new IStudentServiceImpl();
	//��ת��Դ
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
			//��ȡ��ǰҳ��������һ�η��ʣ���ǰҳΪ��	
			String currPage = request.getParameter("currentPage");
			//�ж�
			if(currPage == null || "".equals(currPage.trim())){
				currPage = "1" ; //��һ�η��ʣ����õ�ǰҳΪ1
				
			}
			//ת��
			int currentPage = Integer.parseInt(currPage);
			
			//����pagebean�������õ�ǰҳ����������service��������
			PageBean<Student> pageBean = new PageBean<Student>();
			pageBean.setCurrentPage(currentPage);
			
			//����service
			studentService.getAll(pageBean);
			
			HttpSession session = request.getSession();
			
			//����pageBean��������
			session.setAttribute("pageBean", pageBean);
			//��ת
			uri = "studentSystem.jsp";
		} catch (Exception e) {
			//���ִ�����ת����ҳ��
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
