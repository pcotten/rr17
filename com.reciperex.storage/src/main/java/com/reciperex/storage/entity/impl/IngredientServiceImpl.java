package com.reciperex.storage.entity.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import com.reciperex.model.Ingredient;
import com.reciperex.model.Recipe;
import com.reciperex.storage.entity.IngredientService;
import com.reciperex.storage.service.DatabaseConfig;
import com.reciperex.storage.service.DatabaseManager;
import com.reciperex.storage.service.SQLBuilder;

public class IngredientServiceImpl implements IngredientService {

	DatabaseConfig config = new DatabaseConfig();
//	QueryRunner queryRunner = new QueryRunner();
//	ObjectMapper mapper = new ObjectMapper();
//	JSONParser parser = new JSONParser();
	DatabaseManager manager = new DatabaseManager();
	
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	String sql = null;
	
	public IngredientServiceImpl(){
		
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
	

	public List<Map<String, Object>> queryIngredients(Recipe recipe){
		
		String ingredientList = "";
		for (String s : recipe.getIngredients().keySet()){
			ingredientList += SQLBuilder.toSQLString(s) + ",";
		}
		ingredientList = ingredientList.substring(0, ingredientList.length()-1);
		sql = "SELECT id, name FROM ingredient WHERE name IN (" + ingredientList + ");";

//		System.out.println(sql);
		
		conn = manager.getConnection();
		List<Map<String, Object>> ingredientMapList = manager.mapListQuery(conn, sql);

		System.out.println("MapList : " + ingredientMapList);
		return ingredientMapList;
	}


	public int updateIngredient(Ingredient ingredient) {
		// TODO Auto-generated method stub
		return 0;
	}


	public int deleteIngredient(Integer id) throws SQLException {
		int result = -1;

		conn = manager.getConnection();
		pstmt = conn.prepareStatement("DELETE FROM ingredient WHERE id = ?");
		pstmt.setInt(1, id);
		result = pstmt.executeUpdate();
		if (result != -1){
			System.out.println("Successfully removed ingredient with id " + id);
		}
		else {
			System.out.println("Unable to remove ingredient entity with id " + id);
		}
		
		return result;
	}
	
	
}