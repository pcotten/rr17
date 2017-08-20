package com.reciperex.storage.entity.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbutils.QueryRunner;
import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reciperex.model.MealPlan;
import com.reciperex.model.User;
import com.reciperex.storage.entity.MealPlanService;
import com.reciperex.storage.service.DatabaseConfig;
import com.reciperex.storage.service.DatabaseManager;

public class MealPlanServiceImpl implements MealPlanService{

	DatabaseConfig config = new DatabaseConfig();
//	QueryRunner queryRunner = new QueryRunner();
//	ObjectMapper mapper = new ObjectMapper();
//	JSONParser parser = new JSONParser();
	DatabaseManager manager = new DatabaseManager();
	
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	String sql = null;
	
	public MealPlanServiceImpl(){
		
	}
	
	
	public int insertNewMealPlan(MealPlan mealPlan, Integer userId){
		int r = 0;
		String result = null;
		conn = manager.getConnection();
		
		return r;
	}
	
	public int updateMealPlan(MealPlan mealplan){
		//TODO
		return 0;
	}
	
	public int deleteMealPlan(Integer id) throws SQLException{
		int result = -1;

		conn = manager.getConnection();
		pstmt = conn.prepareStatement("DELETE FROM mealplan WHERE id = ?");
		pstmt.setInt(1, id);
		result = pstmt.executeUpdate();
		if (result != -1){
			System.out.println("Successfully removed mealPlan with id " + id);
		}
		else {
			System.out.println("Unable to remove mealPlan entity with id " + id);
		}
		
		return result;
	}
}