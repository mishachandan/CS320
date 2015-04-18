package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pojo.Applicant;
import pojo.DisplayPojo;
import pojo.Job;
import database.ConnectionFactory;
import database.DbUtil;

public class DAO {

	public DAO() {
		super();
	}
	
	public ArrayList<DisplayPojo> getAllRecords(){
		ArrayList<DisplayPojo> listPojo = new ArrayList<>();
		String query = " SELECT j.name , a.name , ja.date FROM  jobposition j, jobapp ja , applicant a WHERE j.id = ja.jobid AND a.id= ja.appid ORDER BY j.name ; ";

		ResultSet rs = null;
		
		Statement  statement = null;
		Connection connection = null;
		
		try{
			connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            
            while(rs.next()){
            	DisplayPojo  pojo = new DisplayPojo();
            	pojo.setJobname(rs.getString(1));
            	pojo.setAppname(rs.getString(2));
            	String dateStr = rs.getTimestamp(3).toString();
            	pojo.setDate(dateStr.substring(0, dateStr.indexOf('.')));
            	listPojo.add(pojo);
            }
		}catch(Exception e){
			
		}
		return listPojo;
	}
	
	public void addJobPosition(String positionName) throws SQLException{
		String insertTableSql = "insert into jobposition (name) values ('"+positionName+"')";
		
		//insert main table;
		Connection connection = ConnectionFactory.getConnection();
		Statement statement =null;
		try {
			statement = connection.createStatement();
			 statement.executeUpdate(insertTableSql);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		 
		
	}
	
	public List<Job> getAllJobPosition(){
		ArrayList<Job> listPojo = new ArrayList<>();
		String query = " SELECT j.id, j.name FROM jobposition j ";

		ResultSet rs = null;
		
		Statement  statement = null;
		Connection connection = null;
		
		try{
			connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            
            while(rs.next()){
            	Job  pojo = new Job();
            	pojo.setId(rs.getInt(1));
            	pojo.setName(rs.getString(2));
            	
            	listPojo.add(pojo);
            }
		}catch(Exception e){
			
		}
		return listPojo;
	}
	
	public void addJobPosition(String applicantName, String[] jobID) throws SQLException{
		String insertTableSql = "insert into applicant (name) values ('"+applicantName+"')";
		System.out.println(insertTableSql);
		//insert main table;
		Connection connection = ConnectionFactory.getConnection();
		Statement statement =null;
		
		try {
			statement = connection.createStatement();
			 statement.executeUpdate(insertTableSql);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			DbUtil.close(statement);
		}
		Statement statementApp =null;
		ResultSet rs = null;
		String strGetAppId = "select id from applicant where name	='"+applicantName+"'";
		Applicant appPojo = new Applicant();
		try{
		
            statementApp= connection.createStatement();
          //  System.out.println(strGetAppId);
            rs = statementApp.executeQuery(strGetAppId);
            
            if(rs.next()){
            	appPojo.setId(rs.getInt(1));
            }
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(statementApp);
		}
		
		for (String string : jobID) {
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			  Date utilDate = new Date(timestamp.getTime());
			//  System.out.println(" utile ... : "+utilDate);
			   Timestamp sqlTimeStamp = new Timestamp(utilDate.getTime());
			
			
		//	System.out.println(" DATE time: "+sqlTimeStamp);
			String insertTableSql1 = "insert into jobapp (jobid,appid,date) values ("+Integer.parseInt(string)+","+appPojo.getId()+",'"+sqlTimeStamp+"')";
		//	System.out.println(insertTableSql1);
			//insert main table;
			
			Statement statement1 =null;
			try {
				statement1 = connection.createStatement();
				statement1.executeUpdate(insertTableSql1);
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			}
		}
		 
		
		
	}
	public static void main(String[] args) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		  Date utilDate = new Date(timestamp.getTime());
		//  System.out.println(" utile ... : "+utilDate);
		   Timestamp sqlTimeStamp = new Timestamp(utilDate.getTime());
		
	//	System.out.println(" DATE: "+sqlTimeStamp);
	}
	public ArrayList<DisplayPojo> getAllRecordsSortBy(String sortBy){
		ArrayList<DisplayPojo> listPojo = new ArrayList<>();
		String query =null;
		if(sortBy.equalsIgnoreCase("position")){
			query = "  SELECT j.name , a.name , ja.date FROM  jobposition j, jobapp ja , applicant a WHERE j.id = ja.jobid AND a.id= ja.appid ORDER BY j.name ";
		}else if(sortBy.equalsIgnoreCase("applicant")){
			query = " SELECT j.name , a.name , ja.date FROM  jobposition j, jobapp ja , applicant a WHERE j.id = ja.jobid AND a.id= ja.appid ORDER BY a.name ";
		}else if(sortBy.equalsIgnoreCase("date")){
			query = " SELECT j.name , a.name , ja.date FROM  jobposition j, jobapp ja , applicant a WHERE j.id = ja.jobid AND a.id= ja.appid ORDER BY ja.date ";
		}
		

		ResultSet rs = null;
		
		Statement  statement = null;
		Connection connection = null;
		
		try{
			connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            
            while(rs.next()){
            	DisplayPojo  pojo = new DisplayPojo();
            	pojo.setJobname(rs.getString(1));
            	pojo.setAppname(rs.getString(2));
            	
            	String dateStr = rs.getTimestamp(3).toString();
            	pojo.setDate(dateStr.substring(0, dateStr.indexOf('.')));
            
            	listPojo.add(pojo);
            }
		}catch(Exception e){
			
		}
		return listPojo;
	}
}
 