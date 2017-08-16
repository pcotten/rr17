package com.reciperex.storage.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.reciperex.model.Ingredient;
import com.reciperex.storage.service.DatabaseConfig;
import com.reciperex.storage.service.DatabaseManager;

public class IngredientService {

	DatabaseConfig config = new DatabaseConfig();
//	QueryRunner queryRunner = new QueryRunner();
//	ObjectMapper mapper = new ObjectMapper();
//	JSONParser parser = new JSONParser();
	DatabaseManager manager = new DatabaseManager();
	
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	String sql = null;
	
	public IngredientService(){
		
	}
	
	
	public int insertNewIngredient(Ingredient ingredient){
		
		String result = null;
		conn = manager.getConnection();
		int r = 0;
		try {
		pstmt = conn.prepareStatement("INSERT INTO ingredient (name, description) "
				+ "VALUES (?, ?);");
		pstmt.setString(1, ingredient.getName());
		pstmt.setString(2, ingredient.getDescription());

		
			r = pstmt.executeUpdate();
			if (r != 0){
				result = "Ingredient " + ingredient.getName() + " successfully inserted into database";
			}
			else result = "Ingredient " + ingredient.getName() + " not created";
			
		} catch (SQLException e) {
			System.out.println("Unable to insert " + ingredient.getName() + " into database");
			e.printStackTrace();
		}
		System.out.println(result);
		return r;
	}
	
}