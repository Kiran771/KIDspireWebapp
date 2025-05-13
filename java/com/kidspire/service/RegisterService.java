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
 * Service class responsible for handling user registration operations.
 * This class manages interactions with the database for adding new users and querying user-related statistics.
 * It includes methods to register users, check the total number of users excluding the admin,
 * and count the number of recent user registrations within the last 20 minutes.
 * 
 * It uses a database connection established through the DbConfig utility to perform SQL operations
 * 
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
	 * Checks if a given username already exists in the 'User' table.
	 *
	 * @param userName The username to check for duplication.
	 * @return true if the username exists (i.e., it is a duplicate), false otherwise.
	 * @throws SQLException if a database access error occurs.
	 *
	 * 
	 */
	
	public boolean isDuplicateUser(String userName) throws SQLException{
		if(dbConn==null) {
			System.out.println("Database connection is not available ");
			return false;
			
		}
		String username="SELECT userName FROM User WHERE userName=?";
		try(PreparedStatement stmt=dbConn.prepareStatement(username)){
			stmt.setString(1, userName);
	        ResultSet result = stmt.executeQuery();
	        return result.next();
		}
		
		
	}
	
	/**
	 * Checks if a given contact number already exists in the 'User' table.
	 *
	 * @param userName The contact number to check for duplication.
	 * @return true if the contact number exists (i.e., it is a duplicate), false otherwise.
	 * @throws SQLException if a database access error occurs.
	 *
	 * 
	 */
	public boolean isDuplicateContact(String contact) throws SQLException{
		if(dbConn==null) {
			System.out.println("Database connection is not available ");
			return false;
			
		}
		String userContact="SELECT  contactNumber FROM User WHERE contactNumber=?";
		try(PreparedStatement stmt=dbConn.prepareStatement(userContact)){
			stmt.setString(1, contact);
	        ResultSet result = stmt.executeQuery();
	        return result.next();
		}
		
	}
	
	/**
	 * Checks if a given email already exists in the 'User' table.
	 *
	 * @param userName The email to check for duplication.
	 * @return true if the email exists (i.e., it is a duplicate), false otherwise.
	 * @throws SQLException if a database access error occurs.
	 *
	 * 
	 */
	public boolean isDuplicateEmail(String email) throws SQLException{
		if(dbConn==null) {
			System.out.println("Database connection is not available ");
			return false;
			
		}
		String userContact="SELECT  email FROM User WHERE email=?";
		try(PreparedStatement stmt=dbConn.prepareStatement(userContact)){
			stmt.setString(1, email);
	        ResultSet result = stmt.executeQuery();
	        return result.next();
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
	/**
     * Retrieves the total number of users in the system excluding the admin user.
     * 
     * @return The total number of users excluding the admin user
     * @throws SQLException if a database access error occurs during the operation
     */
	public int getTotalUsersExcludingAdmin() throws SQLException {
		if(dbConn==null) {
			System.out.println("Database connection is not available ");
			return 0;
				
		}
		String totalUser = "SELECT COUNT(*) AS total_users FROM User WHERE userName != ?";
		try(PreparedStatement stmt=dbConn.prepareStatement(totalUser)){
			stmt.setString(1, "admin1");
			ResultSet result = stmt.executeQuery();
			 if (result.next()) {
                 int count = result.getInt("total_users");
                 return count;
             }
			
		}catch(SQLException e) {
			System.err.println("SQL Error in getTotalUsersExcludingAdmin: " + e.getMessage());
		}
		return 0;
		
	}
	
	/**
     * Retrieves the number of users who registered in the last 20 minutes.
     * 
     * @return The number of users who registered within the last 20 minutes
     * @throws SQLException if a database access error occurs during the operation
     */
	public int recentUserRegistered()throws SQLException{
		if(dbConn==null) {
			System.out.println("Database connection is not available ");
			return 0;
				
		}	
		
		String recentUsers="SELECT COUNT(*) AS recent_users FROM User WHERE created_at >= NOW() - INTERVAL 20 MINUTE " ;
		try(PreparedStatement stmt=dbConn.prepareStatement(recentUsers)){
			ResultSet result = stmt.executeQuery();
			if (result.next()) {
                int count = result.getInt("recent_users");
                return count;
            }
		}catch (SQLException e) {
            System.err.println("SQL Error in recentUserRegistered: " + e.getMessage());
            throw new SQLException("Failed to retrieve recent users count: " + e.getMessage(), e);
        }
				
		return 0;		
	}
	
	
}
