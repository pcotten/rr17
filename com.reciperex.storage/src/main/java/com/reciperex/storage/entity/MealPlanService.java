package com.reciperex.storage.entity;

import java.sql.SQLException;

import com.reciperex.model.MealPlan;

public interface MealPlanService {

	public int insertNewMealPlan(MealPlan mealPlan, Integer userId);
	
	public int updateMealPlan(MealPlan mealPlan);
	
	public int deleteMealPlan(Integer id) throws SQLException;
	
}
