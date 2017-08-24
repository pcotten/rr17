package com.reciperex.storage.entity;

import java.sql.SQLException;

import com.reciperex.model.Meal;

public interface MealService {

	public Meal insertNewMeal(Meal meal, Integer userId) throws SQLException;
	
	public int updateMeal(Meal meal) throws SQLException;
	
	public int deleteMeal(Integer id) throws SQLException;

	public Meal getMealById(Integer id);
	
}
