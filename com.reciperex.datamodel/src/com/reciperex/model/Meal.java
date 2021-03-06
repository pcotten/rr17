package com.reciperex.model;

import java.time.LocalDate;
import java.util.List;

public class Meal {

	private Integer id;
	private String name;
	private List<Integer> recipes;
	private LocalDate lastPrepared;
	
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
	
	public List<Integer> getRecipes() {
		return recipes;
	}
	
	public void setRecipes(List<Integer> recipes) {
		this.recipes = recipes;
	}
	
	public LocalDate getLastPrepared() {
		return lastPrepared;
	}
	
	public void setLastPrepared(LocalDate lastPrepared) {
		this.lastPrepared = lastPrepared;
	}
	
	
	
}
