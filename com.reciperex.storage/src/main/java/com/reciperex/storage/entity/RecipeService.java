package com.reciperex.storage.entity;

import java.sql.SQLException;

import com.reciperex.model.Recipe;

public interface RecipeService {

	public int insertNewRecipe(Recipe recipe, Integer userId);
	
	public int updateRecipe(Recipe recipe);
	
	public int deleteRecipe(Integer id) throws SQLException;

	public Recipe getRecipeById(Integer id);
	
}
