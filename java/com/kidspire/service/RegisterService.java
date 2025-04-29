package com.kidspire.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.kidspire.util.PasswordUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.kidspire.config.DbConfig;
import com.kidspire.model.UserModel;

/**
 * @author kiransaud 23048603
 * Service class responsible for handling user registration operations
 * This class manages database interactions for adding new users to the system
 */
public class RegisterService {
	private Connection dbConn;
	
	
	/**
     * Constructor for RegisterService
     * Initializes the database connection using the DbConfig utility
     * 
     * @throws SQLException if a database access error occurs
     * @throws ClassNotFoundException if the database driver class is not found
     */
	public RegisterService(){
		try {
			this.dbConn =DbConfig.getDbConnection();
			  System.out.println("DB Connection established: " + (dbConn != null));
			
		}catch(SQLException|ClassNotFoundException ex){
			
			System.err.println("Database connection error:"+ ex.getMessage());
			ex.printStackTrace();
		}
		
	}
	
	
	/**
     * Adds a new user to the database
     * Inserts user details into the User table using a prepared statement
     * 
     * @param userModel the UserModel object containing user details such as user name, 
     *        first name, last name, date of birth, contact number, email, and password
     * @return Boolean indicating the success of the operation:
     * true if the user was successfully added
     * false if the insertion failed
     * null if there was a database connection issue or an error occurred
     * @throws SQLException if a database access error occurs during the operation
     */
	public Boolean addUser(UserModel userModel){
		if(dbConn==null) {
			System.out.println("Database connection is not available ");
			return null;
			
		}
		
		
		String insertQuery="INSERT INTO User(userName,firstName,lastName,Dob,contactNumber,email,password)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		try(PreparedStatement userStmt = dbConn.prepareStatement(insertQuery)){
			
			userStmt.setString(1, userModel.getUserName());
			userStmt.setString(2, userModel.getFirstName());
			userStmt.setString(3,userModel.getLastName());
			userStmt.setDate(4, java.sql.Date.valueOf(userModel.getDob()));
			userStmt.setString(5, userModel.getContactNumber());
			userStmt.setString(6, userModel.getEmail());
			userStmt.setString(7, userModel.getPassword());
			
			
			int rowsAffected = userStmt.executeUpdate();
			
			if (rowsAffected > 0) {
	            
	          	     return true;
	        }
	        return false;
				
		}catch (SQLException e) {
			// Log and handle SQL exceptions
			System.err.println("Error during user registration: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
		
		
	}
}
