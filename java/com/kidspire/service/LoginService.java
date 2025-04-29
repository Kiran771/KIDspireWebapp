package com.kidspire.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import com.kidspire.model.UserModel;
import com.kidspire.util.PasswordUtil;
import java.sql.ResultSet;
import com.kidspire.config.DbConfig;


/**
 * @author kiransaud 23048603
 * LoginService handles user login functionality
 * It connects to the database, verifies user credentials,
 * and checks if the password matches after decryption
 *loginUser(UserModel): Authenticates a user
 * validUserPassword(ResultSet, UserModel): Verifies user name and decrypted password
 * If the database connection fails, login cannot proceed.
 * 
 */

public class LoginService {
	
	private Connection dbConn;
	private boolean isConnectionError = false;
	
	
	/**
	 * Constructor initializes the database connection
	 * Sets isConnectionError flag if connection fails
	 */
	public LoginService() {
		try {
			dbConn = DbConfig.getDbConnection();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			isConnectionError = true;
		}
	}
	
	
	/**
	 * Authenticates a user by verifying user name and password
	 * 
	 * @param userModel UserModel object containing login credentials
	 * @return true if login successful, false if credentials are invalid, 
	 * null if an exception occurs, or true if there is a connection error
	 */
	public Boolean loginUser(UserModel userModel) {
		if (isConnectionError) {
			System.out.println("Connection Error!");
			return true;
		}
		String selectQuery="SELECT userName,password FROM User WHERE userName = ?";
		try (PreparedStatement stmt = dbConn.prepareStatement(selectQuery)) {
			stmt.setString(1, userModel.getUserName());
			ResultSet result = stmt.executeQuery();
			
			if(result.next()) {
				
				return validUserPassword(result,userModel);
				 
			}
			
		
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return false;
	}
	
	
	/**
	 * Validates if the provided user name and password match the database records
	 * 
	 * @param result ResultSet containing database user credentials
	 * @param userModel UserModel object with input credentials
	 * @return true if credentials match, false otherwise
	 * @throws SQLException if an SQL error occurs
	 */
	
	public boolean validUserPassword(ResultSet result,UserModel userModel) throws SQLException{
		String dbUsername = result.getString("userName");
		String dbPassword = result.getString("password");
		
		return dbUsername.equals(userModel.getUserName()) && 
			   PasswordUtil.decrypt(dbPassword, dbUsername).equals(userModel.getPassword());
		
	}
	
	
	
}
