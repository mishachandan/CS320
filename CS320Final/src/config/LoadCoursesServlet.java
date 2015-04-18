package config;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.DisplayPojo;
import pojo.Job;
import dao.DAO;


public class LoadCoursesServlet  extends HttpServlet {

	 @Override
	public void init() throws ServletException {
		super.init();
	
		ServletContext context = getServletContext();
		String fullPath = context.getRealPath("conf.properties");
		try {
			Config.readPath(fullPath);
			
			DAO  dao = new DAO();
			List<DisplayPojo> pojo = dao.getAllRecords();
			if(pojo.size()>0){
				getServletContext().setAttribute(Constants.JOBSAPP, pojo);
			}
			
			List<Job> pojoJob = dao.getAllJobPosition();
			if(pojoJob.size()>0){
				getServletContext().setAttribute(Constants.JOBS, pojoJob);
			}
		} catch (FileNotFoundException e) {
		e.printStackTrace();
		} catch (IOException e) {
				e.printStackTrace();
		}
	}
	 
	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
		 resp.sendRedirect("views/index.jsp");
	}
	 
}
