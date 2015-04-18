package controller;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.DisplayPojo;
import pojo.Job;
import config.Config;
import config.Constants;
import dao.DAO;

public class DoAddJobServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String position = (String) request.getParameter("positionName");
		if(position==null){
			response.sendRedirect(Config.viewFilePath+"index.jsp");
			return;
		}
		
		DAO dao = new DAO();
		try {
			dao.addJobPosition(position);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		List<DisplayPojo> coursesContext = null;
		try{
			coursesContext = dao.getAllRecords();
		}catch(Exception sqle){
			sqle.printStackTrace();
		}
		
		getServletContext().removeAttribute(Constants.JOBSAPP);
		getServletContext().setAttribute(Constants.JOBSAPP,coursesContext);
		
		List<Job> pojoJob = dao.getAllJobPosition();
		if(pojoJob.size()>0){
			getServletContext().removeAttribute(Constants.JOBS);
			getServletContext().setAttribute(Constants.JOBS, pojoJob);
		}
	
		response.sendRedirect(Config.viewFilePath+"index.jsp");

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
