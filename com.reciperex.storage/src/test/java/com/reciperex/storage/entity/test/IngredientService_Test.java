package com.reciperex.storage.entity.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;

import com.reciperex.model.Ingredient;
import com.reciperex.storage.entity.IngredientService;
import com.reciperex.storage.entity.impl.IngredientServiceImpl;
import com.reciperex.storage.service.DatabaseManager;

public class IngredientService_Test {

	DatabaseManager manager;
	IngredientService ingredientService;
	Ingredient ingredient;

	@Before
	public void init(){
		manager = new DatabaseManager();
		ingredientService = new IngredientServiceImpl();
		ingredient = new Ingredient();
		
		ingredient.setName("TestIngredient");
		ingredient.setDescription("Test description");
		ingredient.setQuantity("3 bits");
		
	}
	
	@Test
	public void IngredientService_CRUD() throws SQLException {
		int result = 0;
		
		// Test create operation
		ingredient = ingredientService.insertNewIngredient(ingredient);
		assertTrue(ingredient.getId() != null); 
		
		// Test read operations
		
		ingredient = ingredientService.getIngredientById(ingredient.getId());
		
		// Test update operation
		
		ingredient.setDescription("Changed description");
		ingredient.setQuantity("1 shnarf");
		
		result = ingredientService.updateIngredient(ingredient);
		assertTrue(result == 1);
		
		// Test delete operation
		result = -1;
		try {
			result = ingredientService.deleteIngredient(ingredient.getId());
//			result = userService.deleteUser(59);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertTrue(result != -1);
		
		// Check database for user
		Connection conn = manager.getConnection();
		
		Statement stmt = conn.createStatement();
		String sql = "SELECT COUNT(*) FROM ingredient WHERE id = " + ingredient.getId();
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		assertTrue(rs.getInt("COUNT(*)") == 0);
		
	}
}
