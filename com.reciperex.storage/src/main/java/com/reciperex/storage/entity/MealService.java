package com.reciperex.storage.entity;

import java.sql.SQLException;

import com.reciperex.model.Meal;

public interface MealService {

	public int insertNewMeal(Meal meal, Integer userId);
	
	public int updateMeal(Meal meal);
	
	public int deleteMeal(Integer id) throws SQLException;
	
}
