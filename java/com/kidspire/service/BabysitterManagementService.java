package com.kidspire.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kidspire.config.DbConfig;
import com.kidspire.model.BabysitterModel;

public class BabysitterManagementService {
	private Connection dbConn;
	public BabysitterManagementService() {
		try {
			this.dbConn =DbConfig.getDbConnection();
			  System.out.println("DB Connection established: " + (dbConn != null));
			
		}catch(SQLException|ClassNotFoundException ex){
			
			System.err.println("Database connection error:"+ ex.getMessage());
			ex.printStackTrace();
		}
		
	}
	
	public Boolean addBabysitter(BabysitterModel babysitter)throws SQLException{
		if(dbConn==null) {
			System.out.println("Database connection is not available ");
			return null;
			
		}
		String insertQuery ="INSERT INTO Babysitter (Name,Age,Experience,Email,contactNumber,Status)"
				+"VALUES(?,?,?,?,?,?)";
		try(PreparedStatement sittersStmt = dbConn.prepareStatement(insertQuery)){
			sittersStmt.setString(1, babysitter.getName());
			sittersStmt.setShort(2,babysitter.getAge());
			sittersStmt.setString(3,babysitter.getExperience());
			sittersStmt.setString(4, babysitter.getEmail());
			sittersStmt.setString(5, babysitter.getContactNumber());
			sittersStmt.setString(6, babysitter.getStatus());
			
			int rowsAffected = sittersStmt.executeUpdate();
			
			if (rowsAffected > 0) {
	            
	          	     return true;
	        }
	        return false;
				
		}catch (SQLException e) {
			
			System.err.println("Error during add: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
		
	
	}
	public void updateBabysitter(BabysitterModel updatedSitter) throws SQLException{
		String updateQuery="UPDATE Babysitter SET Name=?,Age=?,Experience=?,Email=?,contactNumber=?,Status=? WHERE  BabysitterId= ?";
		try(PreparedStatement updateStmt=dbConn.prepareStatement(updateQuery)){
			updateStmt.setString(1,updatedSitter.getName());
			updateStmt.setShort(2,updatedSitter.getAge());
			updateStmt.setString(3,updatedSitter.getExperience());
			updateStmt.setString(4,updatedSitter.getEmail());
			updateStmt.setString(5,updatedSitter.getContactNumber());
			updateStmt.setString(6,updatedSitter.getStatus());
			updateStmt.setInt(7,updatedSitter.getBabysitterId());
			updateStmt.executeUpdate();
			
			
		}catch(SQLException e) {
			System.err.println("Error during update: " + e.getMessage());
			e.printStackTrace();
			
		}
	}
	
	public void deleteBabysitter(String babysitterId) throws SQLException{
		int id = Integer.parseInt(babysitterId);
		String deleteQuery="DELETE FROM Babysitter WHERE BabysitterId=?";
		try(PreparedStatement deleteStmt=dbConn.prepareStatement(deleteQuery)){
			deleteStmt.setInt(1,id);
			 int rows = deleteStmt.executeUpdate();
	            if (rows == 0) {
	                throw new SQLException("No babysitter found with ID: " + babysitterId);
	            }
	        } catch (SQLException e) {
	            System.err.println("Error during delete: " + e.getMessage());
	            e.printStackTrace();
	        }
	}
		
	
	
	public List<BabysitterModel> getAllBabysitters() throws SQLException{
		String select="SELECT BabysitterId,Name,Age,Experience,Email,ContactNumber,Status FROM Babysitter";
		List<BabysitterModel> babysitters = new ArrayList<>();
		try(PreparedStatement getStmt=dbConn.prepareStatement(select)){
			ResultSet result = getStmt.executeQuery();
			while (result.next()) {
					BabysitterModel babysitter = new BabysitterModel(
		                result.getString("Name"),
		                result.getShort("Age"),
		                result.getString("Experience"),
		                result.getString("Email"),
		                result.getString("ContactNumber"),
		                result.getString("Status")
					);
					babysitter.setBabysitterId(result.getInt("BabysitterId"));
		            babysitters.add(babysitter);
			}
			
		}
		return babysitters;
		
	}
	public  BabysitterModel getBabysitterById(String babysitterId) throws SQLException {
		int id = Integer.parseInt(babysitterId);
		String getById="SELECT BabysitterId, Name,Age,Experience,Email,ContactNumber,Status FROM Babysitter "
				+ "WHERE BabysitterId=?";
		try(PreparedStatement getIdStmt=dbConn.prepareStatement(getById)){
			getIdStmt.setInt(1, id);
			ResultSet result = getIdStmt.executeQuery();
			if (result.next()) {
                BabysitterModel babysitter = new BabysitterModel(
                    result.getString("Name"),
                    result.getShort("Age"),
                    result.getString("Experience"),
                    result.getString("Email"),
                    result.getString("ContactNumber"),
                    result.getString("status")
                );
                babysitter.setBabysitterId(result.getInt("BabysitterId"));
                return babysitter;
            }
		}
		return null;
		
	}
	public int getAvailableBabysitters() throws SQLException{
		String availableBabysitters="SELECT COUNT(*) AS available_babysitters FROM Babysitter WHERE status=?";
		try(PreparedStatement stmt=dbConn.prepareStatement(availableBabysitters)){
			stmt.setString(1,"available");
			ResultSet result = stmt.executeQuery();
			 if (result.next()) {
                int count = result.getInt("available_babysitters");
               
                return count;
            }
			
		}catch(SQLException e) {
			System.err.println("SQL Error in getAvailableBabysitters: " + e.getMessage());
		}
		return 0;
	}
	public List<BabysitterModel> getBabysitters() throws SQLException {
		String getBabysitter="SELECT BabysitterId,Name,Experience FROM Babysitter ORDER BY BabysitterId";
		List<BabysitterModel> babysitters = new ArrayList<>();
		try (PreparedStatement getStmt = dbConn.prepareStatement(getBabysitter)) {
	        ResultSet result = getStmt.executeQuery();
	        while (result.next()) {
	            BabysitterModel babysitter = new BabysitterModel(
	                result.getString("Name"),
	                result.getString("Experience")
	                
	            );
	            babysitter.setBabysitterId(result.getInt("BabysitterId"));
	            babysitters.add(babysitter);
	        }
	    }
	    return babysitters;
	}
	
	public List<BabysitterModel> searchByName(String searchName) throws SQLException{
		List<BabysitterModel> babysitters = new ArrayList<>();
		String select = "SELECT BabysitterId, Name, Experience FROM Babysitter WHERE LOWER(Name) LIKE ? ORDER BY BabysitterId";
		try (PreparedStatement stmt = dbConn.prepareStatement(select)) {
			String searchPattern = searchName == null || searchName.trim().isEmpty() ? "%" : "%" + searchName.trim().toLowerCase() + "%";
			stmt.setString(1,searchPattern);
			ResultSet result = stmt.executeQuery();
			 while (result.next()) {
	                BabysitterModel babysitter = new BabysitterModel(
	                    result.getString("Name"),
	                    result.getString("Experience")
	                   
	                );
	                int babysitterId = result.getInt("BabysitterId");
	                System.out.println("Search Result - BabysitterId: " + babysitterId + ", Name: " + result.getString("Name"));
	                babysitter.setBabysitterId(babysitterId);
	                babysitters.add(babysitter);
	                
	            }
	        }
	      return babysitters;
			
	}
	
	


}
