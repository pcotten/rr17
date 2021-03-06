package com.reciperex.model;

import java.util.ArrayList;
import java.util.List;

public class MealPlan {

	private Integer id;
	private String name;
	private String description;
	private List<Integer> meals;
	
	public MealPlan(){
		meals = new ArrayList<Integer>();
	}
	
	public MealPlan(String name) {
		super();
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
		
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Integer> getMeals() {
		return meals;
	}
	public void setMeals(List<Integer> meals) {
		this.meals = meals;
	}
	
	
}
