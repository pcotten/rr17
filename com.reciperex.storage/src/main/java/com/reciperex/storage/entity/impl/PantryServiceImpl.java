package com.reciperex.storage.entity.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.RandomStringUtils;

import com.reciperex.model.Pantry;
import com.reciperex.storage.entity.PantryService;
import com.reciperex.storage.service.DatabaseConfig;
import com.reciperex.storage.service.DatabaseManager;

public class PantryServiceImpl implements PantryService{

	DatabaseConfig config = new DatabaseConfig();

	DatabaseManager manager = new DatabaseManager();
	
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	String sql = null;
	
	public PantryServiceImpl(){
		
	}
	
	// creates a new Pantry Entity in the database and returns it's pantryCode
	public String insertNewPantry(String description){
		
		int result = 0;
		
		String pantryCode = generatePantryCode();
		
		try {
		conn = manager.getConnection();
		pstmt = conn.prepareStatement("INSERT INTO pantry (pantryCode) VALUES (?);");
		pstmt.setString(1, pantryCode);

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
	
	public int updatePantry(Integer id, String description){
		//TODO
		return 0;
	}
	
	public int deletePantry(Integer id) throws SQLException{
		int result = -1;

		conn = manager.getConnection();
		pstmt = conn.prepareStatement("DELETE FROM pantry WHERE id = ?");
		pstmt.setInt(1, id);
		result = pstmt.executeUpdate();
		if (result != -1){
			System.out.println("Successfully removed pantry with id " + id);
		}
		else {
			System.out.println("Unable to remove pantry entity with id " + id);
		}
		
		return result;
	}
	

	
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
