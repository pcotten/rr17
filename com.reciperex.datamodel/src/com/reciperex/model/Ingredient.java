package com.reciperex.model;

import java.util.ArrayList;
import java.util.List;

public class Ingredient {

	private Integer id;
	private String name;
	private String description;
	private String quantity;
	private List<Integer> categories;
	
	public Ingredient(){
		
	}
	
	public Ingredient(String name, String description) {
		super();
		this.name = name;
		this.description = description;
		this.categories = new ArrayList<Integer>();
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

	public String getQuantity() {
		return quantity;
	}
	
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public List<Integer> getCategories() {
		return categories;
	}

	public void setCategories(List<Integer> categories) {
		this.categories = categories;
	}
	
}
