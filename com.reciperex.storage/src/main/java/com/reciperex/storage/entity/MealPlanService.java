package com.reciperex.storage.entity;

import java.sql.SQLException;

import com.reciperex.model.Meal;
import com.reciperex.model.MealPlan;

public interface MealPlanService {

	public MealPlan insertNewMealPlan(MealPlan mealPlan, Integer userId) throws SQLException;
	
	public int updateMealPlan(MealPlan mealPlan) throws SQLException;
	
	public int deleteMealPlan(Integer id) throws SQLException;

	public MealPlan getMealPlanById(Integer id);
	
}
