package com.reciperex.storage.entity.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.reciperex.model.Category;
import com.reciperex.model.User;
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

	public int insertNewCategory(Category category){
		conn = manager.getConnection();
		int r = 0;
		try {
			pstmt = conn.prepareStatement("INSERT INTO category (name, description) "
					+ "VALUES (?, ?);");
			pstmt.setString(1, category.getName());
			pstmt.setString(2, category.getDescription());
	
			r = pstmt.executeUpdate();
			if (r != 0){
				System.out.println("Category '" + category.getName() + "' successfully inserted into database");
			}
			else {
				System.out.println("Category '" + category.getName() + "' not created");
			}
			
		} catch (SQLException e) {
			System.out.println("Unable to insert category '" + category.getName() + "' into database");
			e.printStackTrace();
		}
		return r;
	}
	
	public int updateCategory(Category category){
		conn = manager.getConnection();
		int r = 0;
		try {
			
			pstmt = conn.prepareStatement("UPDATE category SET name = ?, description = ? WHERE id = ?");
			pstmt.setString(1, category.getName());
			pstmt.setString(2, category.getDescription());
			pstmt.setInt(3, category.getId());
			
			r = pstmt.executeUpdate();
			if (r != 0){
				System.out.println("Category '" + category.getName() + "' successfully updated in database");
			}
			else {
				System.out.println("Category '" + category.getName() + "' not updated");
			}
		} catch (SQLException e){
			System.out.println("Unable to update category '" + category.getName() + "' in database");
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
	
	public Category getCategoryByName(String name){
		Map<String, String> constraints = new HashMap<String, String>();
		constraints.put("name", SQLBuilder.toSQLString(name));
		return (Category) manager.retrieveSingleEntity(constraints, Category.class);

	}
}
