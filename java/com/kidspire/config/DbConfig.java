package com.kidspire.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/*
 * @author Kiransaud
 * This class build a connection with KIDspire database  
 * 
 * */
public class DbConfig{
	private static final String DB_NAME="KIDspire";
	private static final String URL="jdbc:mysql://localhost:3306/"+DB_NAME;
	private static final String USERNAME="root";
	private static final String PASSWORD= "";
	
	/**
     * Establishes a connection to the KIDspire database.
     *
     * @return Connection object
     * @throws SQLException if a database access error occurs
     * @throws ClassNotFoundException if the JDBC driver is not found
     */
	public static Connection getDbConnection() throws SQLException , ClassNotFoundException{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(URL,USERNAME,PASSWORD);
	}
	
}
