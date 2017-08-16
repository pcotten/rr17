package com.reciperex.model;

import java.util.Date;
import java.util.List;

public class Meal {

	private Integer id;
	private String name;
	private List<Recipe> recipes;
	private Date lastPrepared;
	
	public Meal(){
		
	}
	
	public Meal(String name) {
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
	
	public List<Recipe> getRecipes() {
		return recipes;
	}
	
	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}
	
	public Date getLastPrepared() {
		return lastPrepared;
	}
	
	public void setLastPrepared(Date lastPrepared) {
		this.lastPrepared = lastPrepared;
	}
	
	
	
}
