package com.reciperex.storage.entity.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reciperex.model.Meal;
import com.reciperex.model.User;
import com.reciperex.storage.entity.MealService;
import com.reciperex.storage.service.DatabaseConfig;
import com.reciperex.storage.service.DatabaseManager;
import com.reciperex.storage.service.SQLBuilder;

public class MealServiceImpl implements MealService {

	DatabaseConfig config = new DatabaseConfig();
//	QueryRunner queryRunner = new QueryRunner();
//	ObjectMapper mapper = new ObjectMapper();
//	JSONParser parser = new JSONParser();
	DatabaseManager manager = new DatabaseManager();
	
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	String sql = null;
	Map<String, String> constraints = new HashMap<String, String>();
	
	public MealServiceImpl(){
		
	}

	public int insertNewMeal(Meal meal, Integer userId){
		Savepoint savepoint;

		int r = 0;
		
		try {
			conn = manager.getConnection();
			savepoint = conn.setSavepoint();
			try {
				meal = insertMealEntity(meal);
				if (meal.getId() != null){
					r = 1;
				}
				if (r != 0){
					System.out.println("Meal entity " + meal.getName() + " successfully inserted into database");
				}
				else {
					System.out.println("Unable to complete meal insert - failed to insert meal entity");
					throw new SQLException();
				}
								
				r = linkRecipesToMeal(meal);
				if (r != 0){
					System.out.println("Meal recipe successfully linked in database");
				}
				else {
					System.out.println("Unable to complete meal insert - failed to link recipes");
					throw new SQLException();
				}
				
				r = linkMealToUser(meal, userId);
				if (r != 0){
					System.out.println("Meal successfully linked to user in database");
				}
				else {
					System.out.println("Unable to complete meal insert - failed to link meal to user");
					throw new SQLException();
				}
				
			} catch (SQLException e) {
				System.out.println("Attempting rollback");
				conn.rollback(savepoint);
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.println("Unable to perform rollback.");
			e1.printStackTrace();
		}
		return r;
	}
	
	
	public Meal insertMealEntity(Meal meal) throws SQLException{
		
		String result = null;
		conn = manager.getConnection();
		int r = 0;
		pstmt = conn.prepareStatement("INSERT INTO meal (name, lastPrepared)"
				+ "VALUES (?, ?);", Statement.RETURN_GENERATED_KEYS);
		pstmt.setString(1, meal.getName());
		pstmt.setObject(2, meal.getLastPrepared());
		r = pstmt.executeUpdate();
		ResultSet rs = pstmt.getGeneratedKeys();
		if (rs.next()){
			Integer id = Integer.valueOf(rs.getString("GENERATED_KEY"));
			meal.setId(id);
		}
		if (r != 0 && meal.getId() != null){
			System.out.println("Meal entity successfully inserted into database");
		}
		else {
			System.out.println("Meal creation failed - unable to insert meal entity");
			throw new SQLException();
		}
		
		return meal;
	}

	private int linkRecipesToMeal(Meal meal) throws SQLException {
		int result = 0;
		
		if (conn.isClosed()){
			conn = manager.getConnection();
		}
		if (!meal.getRecipes().isEmpty()){
			for (Integer i : meal.getRecipes()){
				
				pstmt = conn.prepareStatement("INSERT INTO recipe_meal (recipeId, mealId) VALUES (?, ?)");
				pstmt.setInt(1, i);
				pstmt.setInt(2, meal.getId());
	
				result = pstmt.executeUpdate();
				
			}
		}
		else return 1;
		return result;
	}
	
	
	private int linkMealToUser(Meal meal, Integer userId) throws SQLException {
		int result = 0;
		
		if (conn.isClosed()){
			conn = manager.getConnection();
		}
		
		pstmt = conn.prepareStatement("INSERT INTO meal_user (mealId, userId) VALUES (?, ?)");
		pstmt.setInt(1, meal.getId());
		pstmt.setInt(2, userId);

		result = pstmt.executeUpdate();
			
		return result;
	}
	
	public int updateMeal(Meal meal){
		//TODO
		return 0;
	}
	
	
	public int deleteMeal(Integer id) throws SQLException{
		int result = -1;

		conn = manager.getConnection();
		pstmt = conn.prepareStatement("DELETE FROM meal WHERE id = ?");
		pstmt.setInt(1, id);
		result = pstmt.executeUpdate();
		if (result != -1){
			System.out.println("Successfully removed meal with id " + id);
		}
		else {
			System.out.println("Unable to remove recipe meal with id " + id);
		}
		
		return result;
	}
}
