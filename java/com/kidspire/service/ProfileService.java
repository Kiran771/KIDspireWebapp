package com.kidspire.service;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.kidspire.config.DbConfig;
import com.kidspire.model.UserModel;


public class ProfileService {
	private Connection dbConn;
	
	public ProfileService() {
		try {
			this.dbConn =DbConfig.getDbConnection();
			  System.out.println("DB Connection established: " + (dbConn != null));
			
		}catch(SQLException|ClassNotFoundException ex){
			
			System.err.println("Database connection error:"+ ex.getMessage());
			ex.printStackTrace();
		}
       
    }
	
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
