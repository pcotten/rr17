package com.reciperex.storage.entity.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reciperex.model.Ingredient;
import com.reciperex.model.Instruction;
import com.reciperex.model.Recipe;
import com.reciperex.model.User;
import com.reciperex.storage.entity.InstructionService;
import com.reciperex.storage.service.DatabaseConfig;
import com.reciperex.storage.service.DatabaseManager;
import com.reciperex.storage.service.SQLBuilder;

public class InstructionServiceImpl implements InstructionService{

	DatabaseConfig config = new DatabaseConfig();
//	QueryRunner queryRunner = new QueryRunner();
//	ObjectMapper mapper = new ObjectMapper();
//	JSONParser parser = new JSONParser();
	DatabaseManager manager = new DatabaseManager();
	
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	String sql = null;
	
	public InstructionServiceImpl(){
		
	}
	
	
public int insertNewInstruction(Instruction instruction){
		
		String result = null;
		conn = manager.getConnection();
		int r = 0;
		try {
		pstmt = conn.prepareStatement("INSERT INTO instruction (orderIndex, text, recipeId) "
				+ "VALUES (?, ?, ?);");
		pstmt.setInt(1, instruction.getOrderIndex());
		pstmt.setString(2, instruction.getText());
		pstmt.setInt(3, instruction.getRecipeId());

			r = pstmt.executeUpdate();
			if (r != 0){
				result = "Instruction successfully inserted into database";
			}
			else result = "Instruction not created";
			
		} catch (SQLException e) {
			System.out.println("Unable to insert instruction into database");
			e.printStackTrace();
		}
		System.out.println(result);
		return r;
	}

	public int updateInstruction(Instruction instruction){
		//TODO
		return 0;
	}
	
	public int deleteInstruction(Integer id) throws SQLException{
		int result = -1;

		conn = manager.getConnection();
		pstmt = conn.prepareStatement("DELETE FROM instruction WHERE id = ?");
		pstmt.setInt(1, id);
		result = pstmt.executeUpdate();
		if (result != -1){
			System.out.println("Successfully removed instruction with id " + id);
		}
		else {
			System.out.println("Unable to remove instruction entity with id " + id);
		}
		
		return result;
	}
	
	public List<Map<String, Object>> queryInstructions(Recipe recipe){
		
		sql = "SELECT * FROM instruction WHERE recipeId = " + recipe.getId();
		
		conn = manager.getConnection();
		List<Map<String, Object>> instructionMapList = manager.mapListQuery(conn, sql);

		System.out.println("MapList : " + instructionMapList);
		return instructionMapList;
	}
}
