package com.kidspire.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.kidspire.config.DbConfig;

public class RegisterService {
	private Connection dbconn;
	private Boolean hasConnectionError = false;
	
	public RegisterService(){
		try {
			this.dbconn=DbConfig.getDbConnection();
			
		}catch(SQLException|ClassNotFound ex){
			hasConnectionError = true;
			System.err.println("Database connection error:"+ ex.getMessage());
			ex.printStackTrace();
		}
		
	}
}
