package com.reciperex.storage.entity.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

import org.apache.commons.dbutils.QueryRunner;
import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reciperex.model.Cookbook;
import com.reciperex.model.User;
import com.reciperex.storage.entity.CookbookService;
import com.reciperex.storage.service.DatabaseConfig;
import com.reciperex.storage.service.DatabaseManager;

public class CookbookServiceImpl implements CookbookService {

	DatabaseConfig config = new DatabaseConfig();
//	QueryRunner queryRunner = new QueryRunner();
//	ObjectMapper mapper = new ObjectMapper();
//	JSONParser parser = new JSONParser();
	DatabaseManager manager = new DatabaseManager();
	
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	String sql = null;
	
	public CookbookServiceImpl(){
		
	}
	
	
	public int insertNewCookbook(Cookbook cookbook, Integer userId){
		
		Savepoint savepoint;

		int r = 0;
		
		try {
			conn = manager.getConnection();
			savepoint = conn.setSavepoint();
			try {
				cookbook = insertCookbookEntity(cookbook);
				if (cookbook.getId() != null){
					r = 1;
				}
				if (r != 0){
					System.out.println("Cookbook entity " + cookbook.getTitle() + " successfully inserted into database");
				}
				else {
					System.out.println("Unable to complete cookbook insert - failed to insert cookbook entity");
					throw new SQLException();
				}
								
				r = linkRecipesToCookbook(cookbook);
				if (r != 0){
					System.out.println("Cookbook recipes successfully linked in database");
				}
				else {
					System.out.println("Unable to complete cookbook insert - failed to link recipes");
					throw new SQLException();
				}
				
				r = linkCookbookToUser(cookbook, userId);
				if (r != 0){
					System.out.println("Cookbook successfully linked to user in database");
				}
				else {
					System.out.println("Unable to complete cookbook insert - failed to link cookbook to user");
					throw new SQLException();
				}
				
				r = linkCookbookToCategories(cookbook);
				if (r != 0){
					System.out.println("Cookbook successfully linked to categories in database");
				}
				else {
					System.out.println("Unable to complete cookbook insert - failed to link cookbook to categories");
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


	private Cookbook insertCookbookEntity(Cookbook cookbook) throws SQLException {
		String result = null;
		conn = manager.getConnection();
		int r = 0;
		pstmt = conn.prepareStatement("INSERT INTO cookbook (title, creatorId)"
				+ "VALUES (?, ?);", Statement.RETURN_GENERATED_KEYS);
		pstmt.setString(1, cookbook.getTitle());
		pstmt.setInt(2, cookbook.getCreatorId());
		r = pstmt.executeUpdate();
		ResultSet rs = pstmt.getGeneratedKeys();
		if (rs.next()){
			Integer id = Integer.valueOf(rs.getString("GENERATED_KEY"));
			cookbook.setId(id);
		}
		if (r != 0 && cookbook.getId() != null){
			System.out.println("Cookbook entity successfully inserted into database");
		}
		else {
			System.out.println("Cookbook creation failed - unable to insert cookbook entity");
			throw new SQLException();
		}
		
		return cookbook;
	}


	private int linkRecipesToCookbook(Cookbook cookbook) throws SQLException{
		int result = 0;
		
		if (conn.isClosed()){
			conn = manager.getConnection();
		}
		if (!cookbook.getRecipes().isEmpty()){
			for (Integer i : cookbook.getRecipes()){
				
				pstmt = conn.prepareStatement("INSERT INTO recipe_cookbook (recipeId, cookbookId) VALUES (?, ?)");
				pstmt.setInt(1, i);
				pstmt.setInt(2, cookbook.getId());
	
				result = pstmt.executeUpdate();
			}
		}
		else return 1;
		return result;
	}


	private int linkCookbookToUser(Cookbook cookbook, Integer userId) throws SQLException{
		int result = 0;
		
		if (conn.isClosed()){
			conn = manager.getConnection();
		}
		
		pstmt = conn.prepareStatement("INSERT INTO user_cookbook (userId, cookbookId) VALUES (?, ?)");
		pstmt.setInt(1, userId);
		pstmt.setInt(2, cookbook.getId());

		result = pstmt.executeUpdate();
		
		return result;
	}
	

	private int linkCookbookToCategories(Cookbook cookbook) throws SQLException {
		int result = 0;
		
		if (conn.isClosed()){
			conn = manager.getConnection();
		}
		if (!cookbook.getCategories().isEmpty()){
			for (Integer i : cookbook.getCategories()){
				
				pstmt = conn.prepareStatement("INSERT INTO cookbook_category (cookbookId, categoryId) VALUES (?, ?)");
				pstmt.setInt(1, cookbook.getId());
				pstmt.setInt(2, i);
			
				result = pstmt.executeUpdate();
			}
		}
		else return 1;
		return result;	
	}


	public int updateCookbook(Cookbook cookbook) {
		// TODO Auto-generated method stub
		return 0;
	}


	public int deleteCookbook(Integer id) throws SQLException {
		int result = -1;

		conn = manager.getConnection();
		pstmt = conn.prepareStatement("DELETE FROM cookbook WHERE id = ?");
		pstmt.setInt(1, id);
		result = pstmt.executeUpdate();
		if (result != -1){
			System.out.println("Successfully removed cookbook with id " + id);
		}
		else {
			System.out.println("Unable to remove cookbook entity with id " + id);
		}
		
		return result;
	}
}
