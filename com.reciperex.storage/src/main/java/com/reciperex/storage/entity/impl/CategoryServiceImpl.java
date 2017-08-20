package com.reciperex.storage.entity.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.reciperex.storage.entity.CategoryService;
import com.reciperex.storage.service.DatabaseConfig;
import com.reciperex.storage.service.DatabaseManager;
import com.reciperex.storage.service.SQLBuilder;

public class CategoryServiceImpl implements CategoryService {
	
	DatabaseConfig config = new DatabaseConfig();
//	QueryRunner queryRunner = new QueryRunner();
//	ObjectMapper mapper = new ObjectMapper();
//	JSONParser parser = new JSONParser();
	DatabaseManager manager = new DatabaseManager();
	
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	String sql = null;
	
	public CategoryServiceImpl(){
		
	}

	public int insertNewCategory(String name, String description){
		conn = manager.getConnection();
		int r = 0;
		try {
			pstmt = conn.prepareStatement("INSERT INTO category (name, description) "
					+ "VALUES (?, ?);");
			pstmt.setString(1, name);
			pstmt.setString(2, description);
	
			r = pstmt.executeUpdate();
			if (r != 0){
				System.out.println("Category '" + name + "' successfully inserted into database");
			}
			else {
				System.out.println("Category '" + name + "' not created");
			}
			
		} catch (SQLException e) {
			System.out.println("Unable to insert category '" + name + "' into database");
			e.printStackTrace();
		}
		return r;
	}
	
	public int updateCategory(Integer id, String name, String description){
		conn = manager.getConnection();
		int r = 0;
		try {
			
			pstmt = conn.prepareStatement("UPDATE category SET name = ?, description = ? WHERE id = ?");
			pstmt.setString(1, name);
			pstmt.setString(2, description);
			pstmt.setInt(3, id);
			
			r = pstmt.executeUpdate();
			if (r != 0){
				System.out.println("Category '" + name + "' successfully updated in database");
			}
			else {
				System.out.println("Category '" + name + "' not updated");
			}
		} catch (SQLException e){
			System.out.println("Unable to update category '" + name + "' in database");
			e.printStackTrace();
		}
		return r;
	}
	
	public int deleteCategory(Integer id) throws SQLException{
		
		int result = -1;

		conn = manager.getConnection();
		pstmt = conn.prepareStatement("DELETE FROM category WHERE id = ?");
		pstmt.setInt(1, id);
		result = pstmt.executeUpdate();
		if (result != -1){
			System.out.println("Successfully removed category with id " + id);
		}
		else {
			System.out.println("Unable to remove image category with id " + id);
		}
		
		return result;
	}
}
