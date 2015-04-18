package config;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

	public static String applicationURL;
	public static String viewFilePath;
	public static String databaseUrl;
	public static String databaseUser;
	public static String databasePassword;
	public static String databaseDriverClass;
	
	static void readPath(String propertiesFullPath) throws FileNotFoundException, IOException{
		Properties properties = new Properties();
		properties.load(new FileInputStream(propertiesFullPath));
		applicationURL = properties.getProperty("applicationURL");
		viewFilePath = properties.getProperty("viewPath");
		databaseUrl = properties.getProperty("database_url");
		databaseUser = properties.getProperty("database_user");
		databasePassword = properties.getProperty("database_password");
		databaseDriverClass = properties.getProperty("driver_class");
	}


	public static String getApplicationURL() {
		return applicationURL;
	}

	public static String getViewFilePath() {
		return viewFilePath;
	}

	
	public static String getDatabaseUrl() {
		return databaseUrl;
	}

	public static String getDatabaseUser() {
		return databaseUser;
	}

	public static String getDatabasePassword() {
		return databasePassword;
	}

	public static String getDatabaseDriverClass() {
		return databaseDriverClass;
	}
	
	

}
