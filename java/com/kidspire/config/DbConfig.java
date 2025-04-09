package com.kidspire.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/*
 * this class build a connection with database  
 * ? is used for retrieving data
 * */
public class DbConfig{
	private static final String DB_NAME="KIDspire";
	private static final String URL="jdbc:mysql://localhost:3306/"+DB_NAME;
	private static final String USERNAME="root";
	private static final String PASSWORD= "";
	
	public static Connection getDbConnection() throws SQLException , ClassNotFoundException{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(URL,USERNAME,PASSWORD);
	}
	
}
