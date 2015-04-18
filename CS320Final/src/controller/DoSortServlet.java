package controller;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.DisplayPojo;
import config.Config;
import config.Constants;
import dao.DAO;

public class DoSortServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String method = (String) request.getParameter("method");
		
		DAO dao = new DAO();
		List<DisplayPojo> coursesContext = null;
		try{
			coursesContext = dao.getAllRecordsSortBy(method);
		}catch(Exception sqle){
			sqle.printStackTrace();
		}
		
		getServletContext().removeAttribute(Constants.JOBSAPP);
		getServletContext().setAttribute(Constants.JOBSAPP,coursesContext);
		
	
		response.sendRedirect(Config.viewFilePath+"index.jsp");

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
