package com.reciperex.storage.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reciperex.model.Ingredient;
import com.reciperex.model.Recipe;
import com.reciperex.model.User;
import com.reciperex.storage.service.DatabaseConfig;
import com.reciperex.storage.service.DatabaseManager;
import com.reciperex.storage.service.SQLBuilder;

public class RecipeService {

	DatabaseConfig config = new DatabaseConfig();
	QueryRunner queryRunner = new QueryRunner();
	ObjectMapper mapper = new ObjectMapper();
	JSONParser parser = new JSONParser();
	DatabaseManager manager = new DatabaseManager();
	
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	String sql = null;
	Map<String, String> constraints = new HashMap<String, String>();
	
	public RecipeService(){
		
	}
	
	
	public int insertNewRecipe(Recipe recipe, Integer userId){
			
		String result = null;
		conn = manager.getConnection();
		int r = 0;
//		try {
		
			// insert Recipe entity
//			pstmt = conn.prepareStatement("INSERT INTO user (title, description, owner, attributedTo, "
//				+ "numberOfServings, ovenTemp, servingSize, cookTime, prepTime) "
//				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);");
//			pstmt.setString(1, recipe.getTitle());
//			pstmt.setString(2, recipe.getDescription());
//			pstmt.setInt(3, recipe.getOwner());
//			pstmt.setString(4, recipe.getAttributedTo());
//			pstmt.setInt(5, recipe.getNumberOfServings());
//			pstmt.setInt(6, recipe.getOvenTemp());
//			pstmt.setString(7, recipe.getServingSize());
//			pstmt.setString(8, recipe.getCookTime());
//			pstmt.setString(9, recipe.getPrepTime());
//			
//			r = pstmt.executeUpdate();
//			if (r != 0){
//				result = "Recipe entity" + recipe.getTitle() + " successfully inserted into database";
//			}
//			else result = "Recipe entity" + recipe.getTitle() + " not created";
			
			// insert ingredients
			

			constraints.clear();
			String ingredientList = "";
			for (String s : recipe.getIngredients().keySet()){
				ingredientList += SQLBuilder.toSQLString(s) + ",";
			}
			ingredientList = ingredientList.substring(0, ingredientList.length()-1);
			sql = "SELECT id, name FROM ingredient WHERE name IN (" + ingredientList + ");";

			System.out.println(sql);
			List<Map<String, Object>> mapList = manager.mapListQuery(conn, sql);
			System.out.println(mapList);
			
//		} catch (SQLException e) {
//			System.out.println("Unable to insert " + recipe.getId() + " into database");
//			e.printStackTrace();
//		}
		System.out.println(result);
		return r;
		
	}
	
	public int deleteUser(Integer id){
		int result = -1;
		Map<String,String> constraints = new HashMap<String, String>();
		constraints.put("id", id.toString());
		result = manager.DeleteEntity("user", constraints);
		return result;
	}
}