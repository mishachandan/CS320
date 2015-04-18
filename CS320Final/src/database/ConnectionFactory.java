package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import config.Config;


public class ConnectionFactory {
	private static ConnectionFactory instance = new ConnectionFactory();
	
	    private ConnectionFactory() {
	    	try {
	            Class.forName(Config.databaseDriverClass);
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    private Connection createConnection() {
	        Connection connection = null;
	        try {
	            connection = DriverManager.getConnection(Config.databaseUrl, Config.databaseUser, Config.databasePassword);
	        } catch (SQLException e) {
	            System.out.println("ERROR: Unable to Connect to Database.");
	        }
	        return connection;
	    }  
	    
	    public static Connection getConnection() {
	        return instance.createConnection();
	    }
}
