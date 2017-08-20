package com.reciperex.storage.entity;

import java.sql.SQLException;

import com.reciperex.model.Ingredient;

public interface IngredientService {

	public int insertNewIngredient(Ingredient ingredient);
	
	public int updateIngredient(Ingredient ingredient);
	
	public int deleteIngredient(Integer id) throws SQLException;
	
}
