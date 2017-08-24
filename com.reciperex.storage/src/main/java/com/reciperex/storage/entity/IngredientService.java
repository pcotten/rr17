package com.reciperex.storage.entity;

import java.sql.SQLException;

import com.reciperex.model.Ingredient;

public interface IngredientService {

	public Ingredient insertNewIngredient(Ingredient ingredient) throws SQLException;
	
	public int updateIngredient(Ingredient ingredient) throws SQLException;
	
	public int deleteIngredient(Integer id) throws SQLException;

	public Ingredient getIngredientById(Integer id);
	
}
