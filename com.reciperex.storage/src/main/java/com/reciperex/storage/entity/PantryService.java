package com.reciperex.storage.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.RandomStringUtils;

import com.reciperex.model.Pantry;
import com.reciperex.storage.service.DatabaseConfig;
import com.reciperex.storage.service.DatabaseManager;

public class PantryService {

	DatabaseConfig config = new DatabaseConfig();

	DatabaseManager manager = new DatabaseManager();
	
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	String sql = null;
	
	public PantryService(){
		
	}
	
	// creates a new Pantry Entity in the database and returns it's pantryCode
	public String createNewPantry(){
		
		int result = 0;
		
		String pantryCode = generatePantryCode();
		
		try {
		conn = manager.getConnection();
		pstmt = conn.prepareStatement("INSERT INTO pantry (pantryCode) VALUES (?);");
		pstmt.setString(1, pantryCode);
//		sql = "INSERT INTO pantry (pantryCode) "
//				+ "VALUES (\"" + pantryCode + "\");"; 		
//			stmt = conn.createStatement();
			result = pstmt.executeUpdate();
			if (result != 0){
				System.out.println("New pantry successfully created in database");
			}
			else System.out.println("Pantry not created");
			
		} catch (SQLException e) {
			System.out.println("SQLException: Unable to create new Pantry");
			e.printStackTrace();
		}
		return pantryCode;
	}
	
	
//	public int insertNewPantry(Integer userId) {
//		conn = manager.getConnection();
//		int result = 0;
//		Map<String, String> constraints = new HashMap<String, String>();
//		constraints.put("id", userId.toString());
//		User user = (User) manager.retrieveSingleEntity(constraints, User.class);
//		
//		sql = "INSERT INTO pantry (description) "
//				+ "VALUES (\"" + user.getLastName() + " family pantry\");"; 
//		
//		try {
//			conn = manager.getConnection();
//			stmt = conn.createStatement();
//			result = stmt.executeUpdate(sql);
//			if (result != 0){
//				System.out.println("New pantry successfully created in database");
//			}
//			else System.out.println("Pantry not created");
//			
//			if (result != 0){
//				constraints.clear();
//				constraints.put("description", user.getLastName() + " family pantry");
//				Pantry pantry = (Pantry) manager.retrieveSingleEntity(constraints, Pantry.class);
//				sql = "UPDATE user SET pantryId = " + pantry.getId() + " WHERE id = " + user.getId() + ";";
//				result = stmt.executeUpdate(sql);
//				
//				if (result != 0){
//					System.out.println("User updated with pantryId");
//				}
//				else System.out.println("User not updated.  No pantry linked to user");
//			}
//		} catch (SQLException e) {
//			System.out.println("Unable to insert pantry for " + userId + " into database");
//			e.printStackTrace();
//		}
//		return result;
//	}
	
	private String generatePantryCode(){
		String newCode = null;
		boolean unique = true;
		boolean complete = false;
		Map<String, String> constraints = new HashMap<String, String>();
		List<Object> pantryList = manager.retrieveEntities(constraints, Pantry.class);
		while (!complete){
			newCode = RandomStringUtils.randomAlphanumeric(8);
			newCode = newCode.substring(0, 4) + "-" + newCode.substring(4);
			if (!pantryList.isEmpty())
				for (Object o : pantryList){
					Pantry p = (Pantry)o;
					if (p.getPantryCode().equals(newCode)){
						unique = false;
						break;
					}
					if (pantryList.indexOf(o) == pantryList.size()-1){
						unique = true;
					}
				}
			if (unique == true){
				complete = true;
			}
		}
		
		return newCode;
	}
}
