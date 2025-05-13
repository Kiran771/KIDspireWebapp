package com.kidspire.service;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.kidspire.config.DbConfig;
import com.kidspire.model.UserModel;


/**
 * The ProfileService class provides methods for retrieving and updating user profile details.
 * It interacts with the database to fetch and modify user information based on their username
 * It supports fetching a user's details by username and updating the user's details
 */

public class ProfileService {
	private Connection dbConn;
	
	/**
     * Initializes a new instance of ProfileService and establishes a database connection.
     * Throws an exception if the connection cannot be established.
     */
	
	public ProfileService() {
		try {
			this.dbConn =DbConfig.getDbConnection();
			  System.out.println("DB Connection established: " + (dbConn != null));
			
		}catch(SQLException|ClassNotFoundException ex){
			
			System.err.println("Database connection error:"+ ex.getMessage());
			ex.printStackTrace();
		}
       
    }
	
	/**
     * Retrieves a user's profile details based on their username.
     * 
     * @param username The username of the user whose profile is to be fetched.
     * @return A UserModel object containing the user's details, or null if no user is found.
     * @throws SQLException If an SQL error occurs while querying the database.
     */
	
	  public UserModel getUserByUsername(String username) throws SQLException {
	        if (dbConn == null) {
	            throw new SQLException("Database connection is not available");
	        }
	        String query = "SELECT userName, firstName, lastName, contactNumber, email FROM User WHERE userName = ?";
	        try (PreparedStatement stmt = dbConn.prepareStatement(query)) {
	            stmt.setString(1, username);
	            try (ResultSet rs = stmt.executeQuery()) {
	                if (rs.next()) {
	                    return new UserModel(
	                        rs.getString("userName"),
	                        rs.getString("firstName"),
	                        rs.getString("lastName"),
	                        rs.getString("contactNumber"),
	                        rs.getString("email")
	                    );
	                }
	            }
	        }
	        return null;
	    }
	  
	  /**
	   * Updates the details of a user in the database.
	   * 
	   * @param user A UserModel object containing the updated user details.
	   * @throws SQLException If an SQL error occurs during the update process or if no user is found with the specified username.
	   */
	  public void updateUserDetails(UserModel user)throws SQLException {
		  if (dbConn == null) {
	            throw new SQLException("Database connection is not available");
	        }
		  String updateQuery="UPDATE User SET firstName=?,lastName=?,contactNumber=?,email=? WHERE userName=?";
		  try(PreparedStatement stmt=dbConn.prepareStatement(updateQuery)){
			  stmt.setString(1,user.getFirstName() );
			  stmt.setString(2, user.getLastName());
			  stmt.setString(3, user.getContactNumber());
			  stmt.setString(4, user.getEmail());
			  stmt.setString(5, user.getUserName());
			  int rowsAffected = stmt.executeUpdate();
	            if (rowsAffected == 0) {
	                throw new SQLException("No user found with username: " + user.getUserName());
	            }
		  }
	  }
	
	
	
	
	

}
