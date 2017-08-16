package com.reciperex.model;

import java.util.List;

public class Cookbook {

	private Integer id;
	private String name;
	private List<Integer> recipes;
	private List<Integer> categories;
	
	
	public Cookbook() {
		super();
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

	public List<Integer> getCategories() {
		return categories;
	}

	public void setCategories(List<Integer> categories) {
		this.categories = categories;
	}
	
	
}
