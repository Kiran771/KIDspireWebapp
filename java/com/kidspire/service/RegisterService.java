package com.kidspire.service;

import java.sql.Connection;

import com.kidspire.config.DbConfig;

public class RegisterService {
	private Connection dbconn;
	
	public RegisterService(){
		try {
			this.dbconn=DbConfig.getDbConnection();
			
		}catch(SQLException|ClassNotFound ex){
			System.err.println("Database connection error:"+ ex.getMessage());
			ex.printStackTrace();
		}
		
	}
}
