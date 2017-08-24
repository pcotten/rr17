package com.reciperex.storage.entity.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.reciperex.model.Image;
import com.reciperex.model.Recipe;
import com.reciperex.storage.entity.ImageService;
import com.reciperex.storage.entity.RecipeService;
import com.reciperex.storage.entity.impl.ImageServiceImpl;
import com.reciperex.storage.entity.impl.RecipeServiceImpl;
import com.reciperex.storage.service.DatabaseManager;

public class RecipeService_Test {

	DatabaseManager manager;
	RecipeService recipeService;
	ImageService imageService;
	Image recipePic;
	Recipe recipe;
	
	@Before
	public void init(){
		manager = new DatabaseManager();
		recipeService = new RecipeServiceImpl();
		imageService = new ImageServiceImpl();

		recipePic = new Image();
		recipePic.setImagePath("file:///c:/Path/To/Pic");
		recipePic.setText("Profile picture text");
		
		recipe = new Recipe();
		recipe.setTitle("Test Recipe");
		recipe.setOwner("testUser1");
		recipe.setAttributedTo("unknown");
		recipe.setDescription("This is the best chocolate cake recipe I have found to date");
		recipe.setOvenTemp(350);
		recipe.setAttributedTo("Unknown");
		recipe.setNumberOfServings(12);
		recipe.setCookTime("30 minutes");
		recipe.setPrepTime("30 minutes");
		recipe.getIngredients().put("salt", "1 teaspoon");
		recipe.getInstructions().put(1, "Do this.");

		
	}
	
	@Test
	public void RecipeService_CRUD() throws SQLException {
		int result = 0;
		
		// Test create operation
		recipe = recipeService.insertNewRecipe(recipe, 1);
		Assert.assertTrue(recipe.getId() != null); 
		
		// Test read operations
		recipe = recipeService.getRecipeById(recipe.getId());
		
		// Test update operation
		
		recipe.setOvenTemp(999);
		recipe.setNumberOfServings(100);
		recipe.setTitle("Changed Recipe Title");
		
		result = recipeService.updateRecipe(recipe);
		Assert.assertTrue(result == 1);
		
		// Test delete operation
		result = -1;
		try {
			result = recipeService.deleteRecipe(recipe.getId());
//			result = userService.deleteUser(59);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(result != -1);
		
		// Check database for user
		Connection conn = manager.getConnection();
		
		Statement stmt = conn.createStatement();
		String sql = "SELECT COUNT(*) FROM recipe WHERE id = " + recipe.getId();
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		Assert.assertTrue(rs.getInt("COUNT(*)") == 0);
		
	}
}
