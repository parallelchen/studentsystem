package org.parallelchen.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.parallelchen.dao.impl.StudentDaoImpl;


public class AlertStudentServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		//����ҳ�洫������key��id��
		String id = request.getParameter("id");
		
		//����idɾ������
		StudentDaoImpl daoImpl = new StudentDaoImpl();
		daoImpl.deleteStudentInfo(id);
		
		
		request.getRequestDispatcher("/FindAllServlet").forward(request, response);
	}

	

}
