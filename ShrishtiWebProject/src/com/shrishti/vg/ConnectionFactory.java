package com.shrishti.vg;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import com.mysql.jdbc.Connection;

public class ConnectionFactory {
	private static Connection con;
	private static String dbname;
	private static String dbhost;
	private static String dbport;
	private static String dbusername;
	private static String dbpassword;

	
	static {
		new ConnectionFactory();
	}
	
	private ConnectionFactory(){
		try{
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			InputStream inputStream = classLoader.getResourceAsStream("application.properties");
			Properties prop = new Properties();	
			prop.load(inputStream);
			dbhost = prop.getProperty("dbhost");
			dbport = prop.getProperty("dbport");
			dbname = prop.getProperty("dbname");
			dbusername = prop.getProperty("dbusername");
			dbpassword = prop.getProperty("dbpassword");	
			
		}catch(FileNotFoundException fnfEx){
			System.out.println("FileNotFound");
		}catch(IOException ioEx){
			System.out.println("InputOutput");			
		}catch(NullPointerException npEx){
			System.out.println("NullPointerException");
		}
	}
	
	public static Connection getConnection(){
		if(con==null){
			try{
				Class.forName("com.mysql.jdbc.Driver");
			}catch(Exception ex){
				ex.printStackTrace();
				return null;
			}

			try{
				con = (Connection) DriverManager.getConnection("jdbc:mysql://" + dbhost + ":" + dbport + "/" + dbname, dbusername, dbpassword);
				return con;
			}catch(SQLException sqlEx){
				sqlEx.printStackTrace();
				return null;
			}
		}else{
			return con;
		}
	}
}